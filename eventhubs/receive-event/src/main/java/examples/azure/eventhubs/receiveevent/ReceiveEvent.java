package examples.azure.eventhubs.receiveevent;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import static com.azure.messaging.eventhubs.EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME;
import com.azure.messaging.eventhubs.EventHubConsumerAsyncClient;
import com.azure.messaging.eventhubs.models.PartitionEvent;

public class ReceiveEvent {

    public static void main(String[] arguments) {
        // Checks the environment variables
        String connectionString = System.getenv("EVENTHUBS_EVENTHUB_CONNECTION_STRING");
        if (connectionString == null || connectionString.isEmpty()) {
            System.out.println("You need to set the variable EVENTHUBS_EVENTHUB_CONNECTION_STRING");
            return;
        }
        String eventHub = System.getenv("EVENTHUBS_EVENTHUB");
        if (eventHub == null || eventHub.isEmpty()) {
            System.out.println("You need to set the variable EVENTHUBS_EVENTHUB");
            return;
        }

        // Receives the event
        try (EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHub)
                .consumerGroup(DEFAULT_CONSUMER_GROUP_NAME)
                .buildAsyncConsumerClient()) {

            PartitionEvent event = consumer.receive(true).blockFirst();
            System.out.println("Received: " + event.getData().getBodyAsString());
        }
    }
}
