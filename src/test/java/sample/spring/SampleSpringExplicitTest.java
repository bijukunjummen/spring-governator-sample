package sample.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.service.BlogService;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SampleSpringExplicitTest {

    @Test
    public void testSpringInjection() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SampleConfig.class);
        context.refresh();

        BlogService blogService = context.getBean(BlogService.class);
        assertThat(blogService.get(1l), is(notNullValue()));
        context.close();
    }

}
