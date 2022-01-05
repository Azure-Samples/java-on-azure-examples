package cosmos2storage;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@Component
public class ProcessRecordsToBlob implements ChangeFeedHandler {

    @Value("${blob.connectionstring}")
    private String connectionString;

    @Value("${blob.container}")
    private String containerName;

    private BlobContainerClient container;

    @PostConstruct
    public void init() {
        try {
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();
            container = blobServiceClient.getBlobContainerClient(containerName);
        } catch(BlobStorageException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public void processChanges(List<JsonNode> changes) {
        StringBuilder content = new StringBuilder();
        changes.forEach(node -> {
            content.append(node.toPrettyString());
         });

        InputStream inputStream = new ByteArrayInputStream(content.toString().getBytes());
        Timestamp timestamp = Timestamp.from(Instant.now());
        String fileName = timestamp.toString() + ".txt";

        try {
            BlobClient blobClient = container.getBlobClient(fileName);
            blobClient.upload(inputStream, content.toString().getBytes().length);
        } catch (BlobStorageException ex) {
            throw new RuntimeException(ex);
        }
    }
}
