package examples.azure.containers.acr.dropwizard;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }
}
