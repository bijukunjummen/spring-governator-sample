package sample.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.service.BlogService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SampleSpringAutowiredTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void testSpringInjection() {
        assertThat(blogService.get(1l), is(notNullValue()));
    }

    @Configuration
    @ComponentScan("sample.spring")
    public static class SpringConig {

    }

}
