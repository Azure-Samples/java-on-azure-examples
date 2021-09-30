package jms2cosmosdb;

import javax.jms.ConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 * The JMS-to-CosmosDB Spring Boot application.
 */
@SpringBootApplication
@EnableJms
public class Jms2CosmosDbApplication {
    
    /**
     * Stores the JMS acknowledge mode.
     */
    @Value("${jms.acknowledgeMode")
    private Integer acknowledgeMode;
    
    /**
     * Stores the JMS concurrency.
     */
    @Value("${jms.concurrency}")
    private String concurrency;

    /**
     * Stores the JMS remote URI.
     */
    @Value("${jms.remoteUri}")
    private String remoteUri;

    /**
     * Stores the JMS password.
     */
    @Value("${jms.password}")
    private String password;

    /**
     * Stores the JMS username.
     */
    @Value("${jms.username}")
    private String username;

    /**
     * Create the JmsConnectionFactory.
     *
     * @return the JmsConnectionFactory.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        JmsConnectionFactory factory = new JmsConnectionFactory();
        factory.setRemoteURI(remoteUri);
        factory.setPassword(password);
        factory.setUsername(username);
        return factory;
    }

    /**
     * Create the JmsListenerContainerFactory.
     *
     * @param connectionFactory the connection factory.
     * @param configurer the configurer.
     * @return the JmsListenerContainerFactory.
     */
    @Bean
    public JmsListenerContainerFactory jmsContainerFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setSessionAcknowledgeMode(acknowledgeMode);
        factory.setConcurrency(concurrency);
        factory.setExceptionListener(exception -> {
            exception.printStackTrace(System.err);
        });
        factory.setErrorHandler(errorHandler -> {
            errorHandler.printStackTrace(System.err);
        });
        return factory;
    }

    /**
     * The main method.
     *
     * @param arguments the arguments.
     */
    public static void main(String[] arguments) {
        SpringApplication.run(Jms2CosmosDbApplication.class, arguments);
    }
}
