package sample.gov;

import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleTester;
import org.junit.Rule;
import org.junit.Test;
import sample.service.BlogService;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SampleWithGovernatorJunitSupportTest {

    @Rule
    public LifecycleTester tester = new LifecycleTester();

    @Test
    public void testExampleBeanInjection() throws Exception {
        tester.start();
        Injector injector = tester
                .builder()
                .withBootstrapModule(new SampleBootstrapModule())
                .withModuleClass(SampleModule.class)
                .usingBasePackages("sample.gov")
                .build()
                .createInjector();

        BlogService blogService = injector.getInstance(BlogService.class);
        assertThat(blogService.get(1l), is(notNullValue()));
        assertThat(blogService.getBlogServiceName(), equalTo("Test Blog Service"));
    }

}
