package examples.azure.adx.ingest;

import com.microsoft.azure.kusto.data.auth.ConnectionStringBuilder;
import com.microsoft.azure.kusto.ingest.IngestClientFactory;
import com.microsoft.azure.kusto.ingest.IngestClient;
import com.microsoft.azure.kusto.ingest.IngestionProperties;
import com.microsoft.azure.kusto.ingest.result.IngestionResult;
import com.microsoft.azure.kusto.ingest.result.IngestionStatus;
import com.microsoft.azure.kusto.ingest.result.OperationStatus;
import com.microsoft.azure.kusto.ingest.source.StreamSourceInfo;
import java.io.ByteArrayInputStream;

public class Ingest {

    public static void main(String[] arguments) throws Exception {
        String endpoint = System.getenv("ADX_ENDPOINT");
        String clientId = System.getenv("ADX_CLIENT_ID");
        String clientSecret = System.getenv("ADX_CLIENT_SECRET");
        String tenantId = System.getenv("ADX_TENANT_ID");
        ConnectionStringBuilder connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
        IngestClient client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
        String content = System.currentTimeMillis() + ",'1234567890'";
        StreamSourceInfo streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
        IngestionProperties ingestionProperties = new IngestionProperties(System.getenv("ADX_DATABASE_NAME"), System.getenv("ADX_TABLE"));
        IngestionResult result = client.ingestFromStream(streamSourceInfo, ingestionProperties);
        IngestionStatus status = result.getIngestionStatusCollection().get(0);
        while (status.status == OperationStatus.Pending) {
            Thread.sleep(10);
            status = result.getIngestionStatusCollection().get(0);
        }
        if (status.status == OperationStatus.Succeeded) {
            System.out.println("Ingestion successfully completed");
        } else {
            System.out.println("Ingestion failed");
        }
    }
}
