package cosmos2storage;

import com.azure.cosmos.ChangeFeedProcessor;
import com.azure.cosmos.ChangeFeedProcessorBuilder;
import static com.azure.cosmos.ConsistencyLevel.SESSION;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.ChangeFeedProcessorOptions;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.Duration;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChangeFeedComponent {

    @Autowired
    private ProcessRecordsToBlob handler;

    @Value("${cosmosDb.endpoint}")
    private String endpointUri;

    @Value("${cosmosDb.primaryKey}")
    private String primaryKey;

    @Value("${cosmosDb.databaseName}")
    private String databaseName;

    @Value("${cosmosDb.feedContainer}")
    private String feedContainerName;

    @Value("${cosmosDb.leaseContainer}")
    private String leaseContainerName;

    @Value("${cosmosDb.hostName}")
    private String hostName;

    @Value("${cosmosDb.feedPollDelay}")
    private String feedPollDelay;

    @Value("${cosmosDb.maxItemCount}")
    private int maxItemCount;

    private ChangeFeedProcessor changeFeedProcessor;

    @PostConstruct
    public void init() {
        CosmosAsyncClient client = new CosmosClientBuilder()
                .endpoint(endpointUri)
                .key(primaryKey)
                .consistencyLevel(SESSION)
                .contentResponseOnWriteEnabled(true)
                .buildAsyncClient();

        CosmosAsyncDatabase database = client.getDatabase(databaseName);
        CosmosAsyncContainer feedContainer = database.getContainer(feedContainerName);
        CosmosAsyncContainer leaseContainer = database.getContainer(leaseContainerName);

        ChangeFeedProcessorOptions options = new ChangeFeedProcessorOptions();
        options.setFeedPollDelay(Duration.parse(feedPollDelay));
        options.setMaxItemCount(maxItemCount);

        changeFeedProcessor = new ChangeFeedProcessorBuilder()
                .options(options)
                .hostName(hostName)
                .feedContainer(feedContainer)
                .leaseContainer(leaseContainer)
                .handleChanges(
                        (List<JsonNode> changes) -> {
                            handleChanges(changes);
                        })
                .buildChangeFeedProcessor();
        changeFeedProcessor.start().block();
    }

    @PreDestroy
    public void destroy() {
        if (changeFeedProcessor != null) {
            changeFeedProcessor.stop().block();
        }
    }

    private void handleChanges(List<JsonNode> changes) {
        handler.processChanges(changes);
    }
}
