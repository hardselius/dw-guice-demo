package com.example.dwguice.health;

import com.codahale.metrics.health.HealthCheck;
import com.example.dwguice.modules.Template;
import com.google.inject.Inject;
import com.hubspot.dropwizard.guice.InjectableHealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    @Inject
    public TemplateHealthCheck(@Template String template) {
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
}
