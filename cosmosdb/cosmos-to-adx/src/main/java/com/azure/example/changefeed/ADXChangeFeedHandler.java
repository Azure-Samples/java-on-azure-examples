package com.azure.example.changefeed;

import com.fasterxml.jackson.databind.JsonNode;
import com.microsoft.azure.kusto.data.auth.ConnectionStringBuilder;
import com.microsoft.azure.kusto.ingest.IngestClient;
import com.microsoft.azure.kusto.ingest.IngestClientFactory;
import com.microsoft.azure.kusto.ingest.IngestionProperties;
import static com.microsoft.azure.kusto.ingest.IngestionProperties.DATA_FORMAT.multijson;
import com.microsoft.azure.kusto.ingest.exceptions.IngestionClientException;
import com.microsoft.azure.kusto.ingest.exceptions.IngestionServiceException;
import com.microsoft.azure.kusto.ingest.result.IngestionResult;
import com.microsoft.azure.kusto.ingest.result.IngestionStatus;
import com.microsoft.azure.kusto.ingest.result.OperationStatus;
import com.microsoft.azure.kusto.ingest.source.StreamSourceInfo;
import com.microsoft.azure.storage.StorageException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The ADX ChangeFeedHandler.
 */
@Component
public class ADXChangeFeedHandler implements ChangeFeedHandler {

    /**
     * Stores the ADX endpoint.
     */
    @Value("${adx.endpoint}")
    private String endpoint;

    /**
     * Stores the ADX client id.
     */
    @Value("${adx.clientId}")
    private String clientId;

    /**
     * Stores the ADX client secret.
     */
    @Value("${adx.clientSecret}")
    private String clientSecret;

    /**
     * Stores the ADX tenant id.
     */
    @Value("${adx.tenantId}")
    private String tenantId;

    /**
     * Stores the ADX database name.
     */
    @Value("${adx.databaseName}")
    private String databaseName;

    /**
     * Stores the ADX table name.
     */
    @Value("${adx.tableName}")
    private String tableName;

    /**
     * Stores the one and only client.
     */
    private IngestClient client;

    /**
     * Initialize the component.
     */
    @PostConstruct
    public void init() {
        try {
            ConnectionStringBuilder connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(
                    endpoint, clientId, clientSecret, tenantId);
            client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("Unable to parse ADX endpoint URI");
        }
    }

    /**
     * Destroy the component.
     */
    @PreDestroy
    public void destroy() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException ex) {
                // nothing can be done.
            }
        }
    }

    /**
     * Process the changes.
     *
     * @param changes the changes.
     */
    @Override
    public void processChanges(List<JsonNode> changes) {
        try {
            StringBuilder content = new StringBuilder();
            changes.forEach(node -> {
                content.append(node.toPrettyString());
            });
            StreamSourceInfo streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.toString().getBytes()));
            IngestionProperties properties = new IngestionProperties(databaseName, tableName);
            properties.setDataFormat(multijson);
            IngestionResult result = client.ingestFromStream(streamSourceInfo, properties);
            IngestionStatus status = result.getIngestionStatusCollection().get(0);
            while (status.status == OperationStatus.Pending) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
                status = result.getIngestionStatusCollection().get(0);
            }
            if (status.status == OperationStatus.Failed) {
                throw new RuntimeException("Ingestion failed with error code: " + status.getErrorCode());
            }            
        } catch (IngestionClientException | IngestionServiceException | StorageException | URISyntaxException ex) {
            throw new RuntimeException("Bailing out because of exception", ex);
        }
    }
}
