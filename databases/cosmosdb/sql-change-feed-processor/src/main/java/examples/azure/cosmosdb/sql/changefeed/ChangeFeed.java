package examples.azure.cosmosdb.sql.changefeed;

import com.azure.cosmos.ChangeFeedProcessor;
import com.azure.cosmos.ChangeFeedProcessorBuilder;
import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.ChangeFeedProcessorOptions;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.Duration;
import java.util.List;
import reactor.core.scheduler.Schedulers;

public class ChangeFeed {

    public static void main(String[] arguments) throws Exception {
        StringBuilder result = new StringBuilder();
        try (CosmosAsyncClient client = new CosmosClientBuilder()
                .endpoint(System.getenv("COSMOSDB_ENDPOINT"))
                .key(System.getenv("COSMOSDB_MASTER_KEY"))
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .contentResponseOnWriteEnabled(true)
                .buildAsyncClient()) {

            CosmosAsyncDatabase database = client.getDatabase(System.getenv("COSMOSDB_SQL_DATABASE"));
            CosmosAsyncContainer container = database.getContainer(System.getenv("COSMOSDB_SQL_CONTAINER"));
            CosmosAsyncContainer leaseContainer = database.getContainer(System.getenv("COSMOSDB_SQL_LEASES_CONTAINER"));

            /*
             * Build the async processor.
             */
            ChangeFeedProcessorOptions options = new ChangeFeedProcessorOptions();
            options.setFeedPollDelay(Duration.ofMillis(100));
            options.setStartFromBeginning(true);
            options.setMaxItemCount(1000);
            ChangeFeedProcessor processor = new ChangeFeedProcessorBuilder()
                    .options(options)
                    .hostName("Console-" + System.nanoTime())
                    .feedContainer(container)
                    .leaseContainer(leaseContainer)
                    .handleChanges((List<JsonNode> docs) -> {
                        for (JsonNode document : docs) {
                            if (result.length() == 0) {
                                System.err.println(document.toPrettyString());
                                result.append(document.toPrettyString());
                            }
                        }
                    })
                    .buildChangeFeedProcessor();
            processor.start()
                    .subscribeOn(Schedulers.boundedElastic())
                    .doOnError(error -> { System.err.println(error); })
                    .doOnSuccess(success -> {})
                    .subscribe();

            /*
             * Wait until the async processor reports it has started.
             */
            while(!processor.isStarted()) {
                Thread.sleep(1000);
            }
            
            /*
             * Add an item.
             */
            Item item = new Item();
            container.createItem(item).block();
            System.err.println(item.getId());
            
            /*
             * Wait for the item to be processed.
             */
            while (result.length() == 0) {
                Thread.sleep(250);
            }
            System.out.println("Change feed was processed");
        }
    }
}
