package examples.azure.servicebus.sendmessage;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

public class SendMessage {

    public static void main(String[] arguments) {
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .connectionString(System.getenv("SERVICE_BUS_QUEUE_CONNECTION_STRING"))
                .sender()
                .queueName(System.getenv("SERVICE_BUS_QUEUE"))
                .buildClient();

        senderClient.sendMessage(new ServiceBusMessage("Hello, World!"));
        System.out.println("Sent a 'Hello, World!' message to " + System.getenv("SERVICE_BUS_QUEUE"));
        
        //
        // This should not be necessary as any underlying threads should be daemon threads.
        //
        
        System.exit(0);
    }
}
