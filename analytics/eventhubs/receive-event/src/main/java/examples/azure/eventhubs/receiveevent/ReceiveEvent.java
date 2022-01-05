package examples.azure.eventhubs.receiveevent;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import static com.azure.messaging.eventhubs.EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME;
import com.azure.messaging.eventhubs.EventHubConsumerAsyncClient;
import com.azure.messaging.eventhubs.models.PartitionEvent;

public class ReceiveEvent {

    public static void main(String[] arguments) {
        String connectionString = System.getenv("EVENTHUBS_EVENTHUB_CONNECTION_STRING");
        String eventHub = System.getenv("EVENTHUBS_EVENTHUB");

        try (EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHub)
                .consumerGroup(DEFAULT_CONSUMER_GROUP_NAME)
                .buildAsyncConsumerClient()) {

            PartitionEvent event = consumer.receive(true).blockFirst();
            System.out.println("Received: " + event.getData().getBodyAsString());
        }
    }
}
