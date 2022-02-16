package com.azure.example.changefeed;

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

/**
 * The ChangeFeed component.
 */
@Component
public class ChangeFeedComponent {

    /**
     * Stores the ChangeHandler.
     */
    @Autowired
    private ChangeFeedHandler handler;

    /**
     * Stores the CosmosDB endpoint.
     */
    @Value("${cosmosDb.endpoint}")
    private String endpointUri;

    /**
     * Stores the CosmosDB primary key.
     */
    @Value("${cosmosDb.primaryKey}")
    private String primaryKey;

    /**
     * Stores the CosmosDB database name.
     */
    @Value("${cosmosDb.databaseName}")
    private String databaseName;

    /**
     * Stores the CosmosDB feed container.
     */
    @Value("${cosmosDb.feedContainer}")
    private String feedContainerName;

    /**
     * Stores the CosmosDB lease container.
     */
    @Value("${cosmosDb.leaseContainer}")
    private String leaseContainerName;

    /**
     * Stores the CosmosDB host name.
     */
    @Value("${cosmosDb.hostName}")
    private String hostName;

    /**
     * Stores the CosmosDB feed poll delay.
     */
    @Value("${cosmosDb.feedPollDelay}")
    private String feedPollDelay;

    /**
     * Stores the CosmosDB max item count.
     */
    @Value("${cosmosDb.maxItemCount}")
    private int maxItemCount;

    /**
     * Stores the one and only ChangeFeedProcessor.
     */
    private ChangeFeedProcessor changeFeedProcessor;

    /**
     * Initialize the component.
     */
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

    /**
     * Destroy the ChangeFeedProcessor.
     */
    @PreDestroy
    public void destroy() {
        if (changeFeedProcessor != null) {
            changeFeedProcessor.stop().block();
        }
    }

    /**
     * Handle the changes.
     *
     * @param changes the changes.
     */
    private void handleChanges(List<JsonNode> changes) {
        handler.processChanges(changes);
    }
}
