package jms2cosmosdb;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * The JMS message receiver.
 */
@Component
public class JmsReceiver {
    
    /**
     * Stores the Cosmos DB URI.
     */
    @Value("${azure.cosmos.uri}")
    private String uri;
    
    /**
     * Stores the Cosmos DB key.
     */
    @Value("${azure.cosmos.key}")
    private String key;

    /**
     * Stores the Cosmos DB database.
     */
    @Value("${azure.cosmos.databse}")
    private String databaseName;

    /**
     * Stores the Cosmos DB container.
     */
    @Value("${azure.cosmos.container}")
    private String containerName;

    /**
     * Stores the Cosmos DB container.
     */
    private CosmosContainer container;
    
    /**
     * Initialize the component.
     */
    @PostConstruct
    public void initialize() {
        CosmosClient client = new CosmosClientBuilder()
                .endpoint(uri)
                .key(key)
                .buildClient();
        CosmosDatabase database = client.getDatabase(databaseName);
        container = database.getContainer(containerName);
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
            CosmosItemRequestOptions options = new CosmosItemRequestOptions();
            container.upsertItem(message.getText(), options);
        } catch (JMSException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
