package no.buypass.dwguice.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.inject.name.Named;
import no.buypass.dwguice.api.Saying;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world-guice")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class HelloWorldGuiceResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    @Inject
    HelloWorldGuiceResource(@Named("template") String template,
                            @Named("defaultName") String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
