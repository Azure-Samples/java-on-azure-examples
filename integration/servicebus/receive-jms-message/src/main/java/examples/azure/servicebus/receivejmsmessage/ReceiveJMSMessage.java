package examples.azure.servicebus.receivejmsmessage;

import com.microsoft.azure.servicebus.jms.ServiceBusJmsConnectionFactory;
import com.microsoft.azure.servicebus.jms.ServiceBusJmsConnectionFactorySettings;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class ReceiveJMSMessage {

    public static void main(String[] arguments) throws Exception {
        ServiceBusJmsConnectionFactorySettings settings
                = new ServiceBusJmsConnectionFactorySettings();
        settings.setConnectionIdleTimeoutMS(20000);
        ConnectionFactory factory = new ServiceBusJmsConnectionFactory(
                System.getenv("SERVICE_BUS_QUEUE_CONNECTION_STRING"), settings);

        TextMessage message;
        try ( JMSContext context = factory.createContext()) {
            Queue queue = context.createQueue(System.getenv("SERVICE_BUS_QUEUE"));
            JMSConsumer consumer = context.createConsumer(queue);
            message = (TextMessage) consumer.receive();
        }
        
        System.out.println("Received " + message.getText());
    }
}
