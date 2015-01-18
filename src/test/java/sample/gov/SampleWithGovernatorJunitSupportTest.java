package sample.gov;

import com.google.inject.Injector;
import com.netflix.governator.configuration.ArchaiusConfigurationProvider;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.guice.LifecycleTester;
import com.netflix.governator.lifecycle.LifecycleManager;
import org.junit.Rule;
import org.junit.Test;
import sample.service.BlogService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class SampleWithGovernatorJunitSupportTest {

    @Rule
    public LifecycleTester tester = new LifecycleTester();

    @Test
    public void testExampleBeanInjection() throws Exception {
        tester.start();
        Injector injector = tester
                .builder()
                .usingBasePackages("sample.gov")
                .build()
                .createInjector();

        BlogService blogService = injector.getInstance(BlogService.class);
        assertThat(blogService.get(1l), is(notNullValue()));
    }

}
