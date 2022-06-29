package examples.azure.eventhubs.sendevent;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;

public class SendEvent {

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

        // Sends the event
        try (EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHub)
                .buildProducerClient()) {
            EventDataBatch batch = producer.createBatch();
            EventData event = new EventData("this is an event");
            batch.tryAdd(event);
            producer.send(batch);
            System.out.println("Event was sent successfully");
        }
    }
}
