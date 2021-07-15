package example.azure.adx.ingest;

import com.microsoft.azure.kusto.data.auth.ConnectionStringBuilder;
import com.microsoft.azure.kusto.ingest.IngestClientFactory;
import com.microsoft.azure.kusto.ingest.IngestClient;
import com.microsoft.azure.kusto.ingest.IngestionProperties;
import com.microsoft.azure.kusto.ingest.result.IngestionResult;
import com.microsoft.azure.kusto.ingest.result.IngestionStatus;
import com.microsoft.azure.kusto.ingest.result.OperationStatus;
import com.microsoft.azure.kusto.ingest.source.StreamSourceInfo;
import java.io.ByteArrayInputStream;

public class IngestIntoADX {

    public static void main(String[] arguments) throws Exception {
        String endpoint = arguments[0];
        String clientId = arguments[1];
        String clientSecret = arguments[2];
        String tenantId = arguments[3];
        long currentMillis = System.currentTimeMillis();
        ConnectionStringBuilder connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
        IngestClient client = IngestClientFactory.createManagedStreamingIngestClient(connectionStringBuilder, connectionStringBuilder);
        String content = System.currentTimeMillis() + ",'1234567890'";
        StreamSourceInfo streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
        IngestionProperties ingestionProperties = new IngestionProperties("demo", "Events");
        IngestionResult result = client.ingestFromStream(streamSourceInfo, ingestionProperties);
        IngestionStatus status = result.getIngestionStatusCollection().get(0);
        while (status.status == OperationStatus.Pending) {
            Thread.sleep(10);
            status = result.getIngestionStatusCollection().get(0);
        }
        long endMillis = System.currentTimeMillis();
        if (status.status == OperationStatus.Succeeded) {
            System.out.println("Ingestion successfully completed");
        } else {
            System.out.println("Ingestion failed");
        }
        System.out.println((endMillis - currentMillis) + " milleseconds");

        currentMillis = System.currentTimeMillis();
        connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
        client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
        content = System.currentTimeMillis() + ",'1234567890'";
        streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
        ingestionProperties = new IngestionProperties("demo", "Events");
        result = client.ingestFromStream(streamSourceInfo, ingestionProperties);
        status = result.getIngestionStatusCollection().get(0);
        while (status.status == OperationStatus.Pending) {
            Thread.sleep(10);
            status = result.getIngestionStatusCollection().get(0);
        }
        endMillis = System.currentTimeMillis();
        if (status.status == OperationStatus.Succeeded) {
            System.out.println("Ingestion successfully completed");
        } else {
            System.out.println("Ingestion failed");
        }
        System.out.println((endMillis - currentMillis) + " milleseconds");

        currentMillis = System.currentTimeMillis();
        connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
        client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
        content = System.currentTimeMillis() + ",'1234567890'";
        streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
        ingestionProperties = new IngestionProperties("demo", "Events");
        result = client.ingestFromStream(streamSourceInfo, ingestionProperties);
        status = result.getIngestionStatusCollection().get(0);
        while (status.status == OperationStatus.Pending) {
            Thread.sleep(10);
            status = result.getIngestionStatusCollection().get(0);
        }
        endMillis = System.currentTimeMillis();
        if (status.status == OperationStatus.Succeeded) {
            System.out.println("Ingestion successfully completed");
        } else {
            System.out.println("Ingestion failed");
        }
        System.out.println((endMillis - currentMillis) + " milleseconds");

        for (int i = 0; i < 10000; i++) {
            currentMillis = System.currentTimeMillis();
            connectionStringBuilder = ConnectionStringBuilder.createWithAadApplicationCredentials(endpoint, clientId, clientSecret, tenantId);
            client = IngestClientFactory.createStreamingIngestClient(connectionStringBuilder);
            content = System.currentTimeMillis() + ",'1234567890'";
            streamSourceInfo = new StreamSourceInfo(new ByteArrayInputStream(content.getBytes()));
            ingestionProperties = new IngestionProperties("demo", "Events");
            result = client.ingestFromStream(streamSourceInfo, ingestionProperties);
            status = result.getIngestionStatusCollection().get(0);
            while (status.status == OperationStatus.Pending) {
                Thread.sleep(10);
                status = result.getIngestionStatusCollection().get(0);
            }
            endMillis = System.currentTimeMillis();
            if (status.status == OperationStatus.Succeeded) {
                System.out.println("Ingestion successfully completed");
            } else {
                System.out.println("Ingestion failed");
            }
            System.out.println((endMillis - currentMillis) + " milleseconds");
        }
    }
}
