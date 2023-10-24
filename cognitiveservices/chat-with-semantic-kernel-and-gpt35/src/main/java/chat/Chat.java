package chat;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import com.microsoft.semantickernel.Kernel;
import com.microsoft.semantickernel.SKBuilders;
import com.microsoft.semantickernel.chatcompletion.ChatCompletion;
import com.microsoft.semantickernel.chatcompletion.ChatHistory;
import com.microsoft.semantickernel.connectors.ai.openai.chatcompletion.OpenAIChatHistory;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Chat {
    
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        OpenAIAsyncClient client =  new OpenAIClientBuilder()
            .endpoint(System.getenv("AZURE_OPEN_AI_ENDPOINT"))
            .credential(new AzureKeyCredential(System.getenv("AZURE_OPEN_AI_KEY")))
            .buildAsyncClient();

        Kernel kernel = SKBuilders.kernel()
            .withAIService(
                "gpt-35-turbo",
                SKBuilders.chatCompletion()
                    .withOpenAIClient(client)
                    .withModelId("gpt-35-turbo")
                    .build(),
                true,
                ChatCompletion.class
            )
            .build();

        ChatCompletion<OpenAIChatHistory> chatGPT = kernel.getService(null, ChatCompletion.class);
        OpenAIChatHistory chatHistory = chatGPT.createNewChat("You are a developer that knows Java");

        System.out.print("> ");
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(System.in));
        while(!exit) {
            String input =  reader.readLine();
            if (input.trim().equals(("/exit"))) {
                break;
            }
            chatHistory.addUserMessage(input);
            String reply = chatGPT.generateMessageAsync(chatHistory, null).block();
            chatHistory.addAssistantMessage(reply);
            ChatHistory.Message message = chatHistory.getMessages().get(chatHistory.getMessages().size() - 1);
            System.out.println();
            System.out.println(message.getContent());
            System.out.println();
            System.out.print("> ");
        }
    }
}
