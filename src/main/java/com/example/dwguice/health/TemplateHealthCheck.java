package com.example.dwguice.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.hubspot.dropwizard.guice.InjectableHealthCheck;

public class TemplateHealthCheck extends InjectableHealthCheck {
    private final String template;

    @Inject
    TemplateHealthCheck(@Named("template") String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return HealthCheck.Result.healthy();
    }

    @Override
    public String getName() {
        return "template";
    }
}
