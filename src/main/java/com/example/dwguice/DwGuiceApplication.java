package com.example.dwguice;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.dwguice.modules.HelloWorldModule;
import com.example.dwguice.resources.HelloWorldResource;

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
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
//        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
//        environment.healthChecks().register("template", healthCheck);
    }

}
