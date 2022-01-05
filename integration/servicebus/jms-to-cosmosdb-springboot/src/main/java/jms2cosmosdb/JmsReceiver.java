package jms2cosmosdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * The JMS message receiver.
 */
@Component
public class JmsReceiver {
    
    /**
     * Stores the Cosmos DB repository.
     */
    @Autowired
    private HelloWorldRepository repository;
    
    /**
     * Stores the object mapper.
     */
    private ObjectMapper mapper;
    
    /**
     * Initialize the component.
     */
    @PostConstruct
    public void initialize() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * Receive the message.
     * 
     * @param message the JMS text message.
     */
    @JmsListener(destination = "${jms.queue}", containerFactory = "jmsContainerFactory")
    public void receiveMessage(TextMessage message) {
        try {
            System.out.println(message.getText());
            HelloWorld helloWorld = mapper.readValue(message.getText(), HelloWorld.class);
            helloWorld.setPartitionKey(helloWorld.getId());
            repository.save(helloWorld);
        } catch (JMSException | JsonProcessingException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
