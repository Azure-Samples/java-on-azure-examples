package examples.azure.acr.graalvm;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class GraalVMApplication {

    public void run() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Exiting ...");
                System.exit(0);
            }
        });
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/hello", new GraalVMHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException ioe) {
        }
    }

    public static void main(String[] args) throws Exception {
        GraalVMApplication application = new GraalVMApplication();
        application.run();
    }

}
