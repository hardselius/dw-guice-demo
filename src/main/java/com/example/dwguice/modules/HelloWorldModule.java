package com.example.dwguice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.example.dwguice.DwGuiceConfiguration;

public class HelloWorldModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Template
    public String provideTemplate(DwGuiceConfiguration configuration) {
        return configuration.getTemplate();
    }

    @Provides
    @Named("defaultName")
    public String provideDefaultName(DwGuiceConfiguration configuration) {
        return configuration.getDefaultName();
    }
}
