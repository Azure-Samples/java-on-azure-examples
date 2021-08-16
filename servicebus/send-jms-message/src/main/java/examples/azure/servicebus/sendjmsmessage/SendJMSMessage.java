package examples.azure.servicebus.sendjmsmessage;

import com.microsoft.azure.servicebus.jms.ServiceBusJmsConnectionFactory;
import com.microsoft.azure.servicebus.jms.ServiceBusJmsConnectionFactorySettings;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class SendJMSMessage {

    public static void main(String[] arguments) throws Exception {

        ServiceBusJmsConnectionFactorySettings settings
                = new ServiceBusJmsConnectionFactorySettings();
        settings.setConnectionIdleTimeoutMS(20000);
        ConnectionFactory factory = new ServiceBusJmsConnectionFactory(
                System.getenv("SERVICE_BUS_QUEUE_CONNECTION_STRING"), settings);

        try (JMSContext context = factory.createContext()) {
            Queue queue = context.createQueue(System.getenv("SERVICE_BUS_QUEUE"));
            TextMessage message = context.createTextMessage(
                    "{'id': '" + System.nanoTime() + "', 'hello': 'Hello World!'}");
            JMSProducer producer = context.createProducer();
            producer.send(queue, message);
        }
        
        System.out.println("Sent a 'Hello World!' message to " + System.getenv("SERVICE_BUS_QUEUE"));
    }
}
