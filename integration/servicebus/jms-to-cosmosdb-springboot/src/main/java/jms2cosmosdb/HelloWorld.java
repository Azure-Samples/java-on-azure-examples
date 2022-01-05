package jms2cosmosdb;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

/**
 * The 'Hello World!' POJO.
 */
@Container(containerName = "helloworld")
public class HelloWorld {

    /**
     * Stores the hello.
     */
    private String hello;

    /**
     * Stores the id.
     */
    @Id
    private String id;

    /**
     * Stores the partition key.
     */
    @PartitionKey
    private String partitionKey;
    
    /**
     * Constructor.
     */
    public HelloWorld() {
        id = "" + System.nanoTime();
        partitionKey = id;
        hello = "Hello World!";
    }

    /**
     * Get the hello.
     *
     * @return the hello.
     */
    public String getHello() {
        return hello;
    }

    /**
     * Get the id.
     *
     * @return the id.
     */
    public String getId() {
        return id;
    }

    /**
     * Get the partition key.
     *
     * @return the partition key.
     */
    public String getPartitionKey() {
        return partitionKey;
    }

    /**
     * Set the hello.
     *
     * @param hello the hello.
     */
    public void setHello(String hello) {
        this.hello = hello;
    }

    /**
     * Set the id.
     *
     * @param id the id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the partition key.
     *
     * @param partitionKey the partition key.
     */
    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }
}
