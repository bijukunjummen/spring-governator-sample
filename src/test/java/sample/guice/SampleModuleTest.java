package sample.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import sample.service.BlogService;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SampleModuleTest {

    @Test
    public void testExampleBeanInjection() {
        Injector injector = Guice.createInjector(new SampleModule());
        BlogService blogService = injector.getInstance(BlogService.class);
        assertThat(blogService.get(1l), is(notNullValue()));
    }

}
