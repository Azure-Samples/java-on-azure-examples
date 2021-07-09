package examples.azure.eventhubs.receiveevent;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import static com.azure.messaging.eventhubs.EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME;
import com.azure.messaging.eventhubs.EventHubConsumerClient;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;

public class ReceiveEvent {

    public static void main(String[] arguments) {
        String connectionString = System.getenv("EVENTHUBS_EVENTHUB_CONNECTION_STRING");
        String eventHub = System.getenv("EVENTHUBS_EVENTHUB");

        try (EventHubConsumerClient consumer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHub)
                .consumerGroup(DEFAULT_CONSUMER_GROUP_NAME)
                .buildConsumerClient()) {

            String partitionId = consumer.getPartitionIds().stream().findFirst().orElseThrow();
            PartitionEvent event = consumer.receiveFromPartition(partitionId, 1, EventPosition.earliest()).iterator().next();
            System.out.println("Received: " + event.getData().getBodyAsString());
        }
        
        System.exit(0);
    }
}
