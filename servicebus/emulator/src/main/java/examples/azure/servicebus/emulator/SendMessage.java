package examples.azure.servicebus.emulator;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

import java.time.LocalDateTime;

public class SendMessage {

    private static final String SERVICE_BUS_QUEUE_CONNECTION_STRING = System.getenv("SERVICE_BUS_QUEUE_CONNECTION_STRING");
    private static final String SERVICE_BUS_QUEUE = System.getenv("SERVICE_BUS_QUEUE");

    public static void main(String[] arguments) {
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
            .connectionString(SERVICE_BUS_QUEUE_CONNECTION_STRING)
            .sender()
            .queueName(SERVICE_BUS_QUEUE)
            .buildClient();

        System.out.println("Sending....");
        senderClient.sendMessage(new ServiceBusMessage("Hello, World! at " + LocalDateTime.now()));
        System.out.println("Sent a 'Hello, World!' message to " + SERVICE_BUS_QUEUE);

        System.exit(0);
    }
}
