package com.example.dwguice;

import com.example.dwguice.health.TemplateHealthCheck;
import com.example.dwguice.resources.HelloWorldResource;
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
    }

    @Override
    public void run(DwGuiceConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
