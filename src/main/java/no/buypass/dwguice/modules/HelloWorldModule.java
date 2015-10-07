package no.buypass.dwguice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import no.buypass.dwguice.DwGuiceConfiguration;

public class HelloWorldModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Named("template")
    public String provideTemplate(DwGuiceConfiguration configuration) {
        return configuration.getTemplate();
    }

    @Provides
    @Named("defaultName")
    public String provideDefaultName(DwGuiceConfiguration configuration) {
        return configuration.getDefaultName();
    }
}
