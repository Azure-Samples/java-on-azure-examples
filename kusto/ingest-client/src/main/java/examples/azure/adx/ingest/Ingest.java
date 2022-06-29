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
        // Checks the environment variables
        String endpoint = System.getenv("ADX_ENDPOINT");
        if (endpoint == null || endpoint.isEmpty()) {
            System.out.println("You need to set the variable ADX_ENDPOINT");
            return;
        }
        String clientId = System.getenv("ADX_CLIENT_ID");
        if (clientId == null || clientId.isEmpty()) {
            System.out.println("You need to set the variable ADX_CLIENT_ID");
            return;
        }
        String clientSecret = System.getenv("ADX_CLIENT_SECRET");
        if (clientSecret == null || clientSecret.isEmpty()) {
            System.out.println("You need to set the variable ADX_CLIENT_SECRET");
            return;
        }
        String tenantId = System.getenv("ADX_TENANT_ID");
        if (tenantId == null || tenantId.isEmpty()) {
            System.out.println("You need to set the variable ADX_TENANT_ID");
            return;
        }
        String databaseName = System.getenv("ADX_DATABASE_NAME");
        if (databaseName == null || databaseName.isEmpty()) {
            System.out.println("You need to set the variable ADX_DATABASE_NAME");
            return;
        }
        String table = System.getenv("ADX_TABLE");
        if (table == null || table.isEmpty()) {
            System.out.println("You need to set the variable ADX_TABLE");
            return;
        }

        // Ingests from stream
        ConnectionStringBuilder connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
        IngestClient client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
        String content = System.currentTimeMillis() + ",'1234567890'";
        StreamSourceInfo streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
        IngestionProperties ingestionProperties = new IngestionProperties(databaseName, table);
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
