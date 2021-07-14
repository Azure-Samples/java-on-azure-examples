package examples.azure.cosmosdb.insertitemsqlcontainer;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosItemResponse;

public class InsertItemSQLContainer {

    public static void main(String[] arguments) {
        try (CosmosClient client = new CosmosClientBuilder()
                .endpoint(System.getenv("COSMOSDB_ENDPOINT"))
                .key(System.getenv("COSMOSDB_MASTER_KEY"))
                .buildClient()) {

            CosmosDatabase database = client.getDatabase(System.getenv("COSMOSDB_SQL_DATABASE"));
            CosmosContainer container = database.getContainer(System.getenv("COSMOSDB_SQL_CONTAINER"));
            CosmosItemResponse response = container.createItem(new Item());
            if (response.getStatusCode() < 400) {
                System.out.println("Item was added");
            } else {
                System.out.println("Failed to add item - reason: " + response.getStatusCode());
                System.exit(1);
            }
        }
    }
}
