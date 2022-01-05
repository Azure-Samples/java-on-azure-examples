package examples.azure.servicebus.receivemessage;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import java.util.concurrent.TimeUnit;

public class ReceiveMessage {

    private ServiceBusReceivedMessage receivedMessage;
    
    private boolean processed;
    
    public void execute() throws Exception {
        ServiceBusProcessorClient client = new ServiceBusClientBuilder()
                .connectionString(System.getenv("SERVICE_BUS_QUEUE_CONNECTION_STRING"))
                .processor()
                .queueName(System.getenv("SERVICE_BUS_QUEUE"))
                .processMessage((context) -> {
                    receivedMessage = context.getMessage();
                    processed = true;
                })
                .processError((context) -> {
                    System.err.println(context.getException());
                    processed = true;
                })
                .buildProcessorClient();

        client.start();
        while(!processed) {
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Received a " + receivedMessage.getBody().toString());
        client.close();
    }
    
    public static void main(String[] arguments) throws Exception {
        ReceiveMessage receiveMessage = new ReceiveMessage();
        receiveMessage.execute();
    }
}
