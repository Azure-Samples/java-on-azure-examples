package examples.azure.cosmosdb.sql.changefeed;

public class Item {
    
    private String id;
    
    private String content;
    
    public Item() {
        id = "" + System.nanoTime();
        content = "CONTENT";
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }
}
