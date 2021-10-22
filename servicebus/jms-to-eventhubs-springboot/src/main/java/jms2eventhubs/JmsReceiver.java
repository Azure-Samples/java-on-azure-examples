package jms2eventhubs;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * The JMS message receiver.
 */
@Component
public class JmsReceiver {

    /**
     * Receive the message.
     * 
     * @param message the JMS text message.
     */
    @JmsListener(destination = "${jms.queue}", containerFactory = "jmsContainerFactory")
    public void receiveMessage(TextMessage message) {
        try {
            System.out.println(message.getText());
        } catch (JMSException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
