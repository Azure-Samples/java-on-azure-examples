package examples.azure.eventhubs.sendevent;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;

public class SendEvent {

    public static void main(String[] arguments) {
        String connectionString = System.getenv("EVENTHUBS_EVENTHUB_CONNECTION_STRING");
        String eventHub = System.getenv("EVENTHUBS_EVENTHUB");
        try (EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHub)
                .buildProducerClient()) {
            EventDataBatch batch = producer.createBatch();
            EventData event = new EventData("this is an event");
            batch.tryAdd(event);
            producer.send(batch);
        }
    }
}
