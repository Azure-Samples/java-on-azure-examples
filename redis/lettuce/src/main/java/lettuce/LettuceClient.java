package lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceClient {

    private String command;
    
    private String key;
    
    private String host;
    
    private String password;
    
    private String value;
    
    public void parse(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i].equals("--command")) {
                command = arguments[i + 1];
            }
            if (arguments[i].equals("--host")) {
                host = arguments[i + 1];
            }
            if (arguments[i].equals("--key")) {
                key = arguments[i + 1];
            }
            if (arguments[i].equals("--password")) {
                password = arguments[i + 1];
            }
            if (arguments[i].equals("--value")) {
                value = arguments[i + 1];
            }
        }
    }

    public void execute() {
        RedisURI uri = RedisURI.Builder
                .redis(host)
                .withSsl(true)
                .withPassword(password.toCharArray())
                .withPort(6380)
                .build();
        RedisClient redisClient = RedisClient.create(uri);
        try ( StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();
            switch(command) {
                case "set" : syncCommands.set(key, value); break;
                case "get" : System.out.println(syncCommands.get(key)); break;
            }
        }
        redisClient.shutdown();
    }

    public static void main(String[] arguments) {
        LettuceClient client = new LettuceClient();
        client.parse(arguments);
        client.execute();
    }
}
