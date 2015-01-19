package sample.gov;

import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;
import org.junit.Test;
import sample.service.BlogService;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SampleWithGovernatorTest {

    @Test
    public void testExampleBeanInjection() throws Exception {
        Injector injector  = LifecycleInjector
                .builder()
                .withModuleClass(SampleModule.class)
                .usingBasePackages("sample.gov")
                .build()
                .createInjector();

        LifecycleManager manager = injector.getInstance(LifecycleManager.class);

        manager.start();

        BlogService blogService = injector.getInstance(BlogService.class);
        assertThat(blogService.get(1l), is(notNullValue()));
    }

}
