package jms2springdata;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The 'Hello World!' POJO.
 */
@Entity
public class HelloWorld implements Serializable {

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
     * Constructor.
     */
    public HelloWorld() {
        id = "" + System.nanoTime();
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
}
