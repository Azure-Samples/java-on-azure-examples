package examples.azure.function.cosmosdb.output;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.CosmosDBOutput;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.Optional;

/**
 * A function storing a value in Cosmos DB.
 */
public class CosmosDBOutputFunction {

    /**
     * Run the function.
     *
     * @param request the request.
     * @param outputItem the item to store in Cosmos DB.
     * @param context the execution context.
     * @return the response.
     */
    @FunctionName("/cosmosDBOutput")
    public HttpResponseMessage run(

            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS
            ) HttpRequestMessage<Optional<String>> request,

            @CosmosDBOutput(name = "cosmodDBOutput",
                    databaseName = "cosmosDBOutput",
                    collectionName = "items",
                    connectionStringSetting = "Cosmos_DB_Connection_String",
                    createIfNotExists = true)
            OutputBinding<String> outputItem,
            final ExecutionContext context) {

        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\":\"")
                .append(1)
                .append("\",\"description\":\"This was stored using an Azure function\"}");
        outputItem.setValue(builder.toString());
        
        return request.createResponseBuilder(HttpStatus.OK).
                body("We stored an item in Cosmos DB").
                build();
    }
}
