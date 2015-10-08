package com.example.dwguice;

import com.example.dwguice.modules.HelloWorldModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DwGuiceApplication extends Application<DwGuiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new DwGuiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "dw.guice";
    }

    @Override
    public void initialize(Bootstrap<DwGuiceConfiguration> bootstrap) {
        GuiceBundle<DwGuiceConfiguration> guiceBundle = GuiceBundle.<DwGuiceConfiguration>newBuilder()
                .addModule(new HelloWorldModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(DwGuiceConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(DwGuiceConfiguration configuration, Environment environment) {
        // now you don't need to add resources, tasks, health checks or providers
        // you must have your health checks inherit from InjectableHealthCheck in order for them to be injected
    }

}
