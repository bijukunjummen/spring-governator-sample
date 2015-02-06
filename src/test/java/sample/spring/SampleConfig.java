package sample.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import sample.dao.BlogDao;
import sample.service.BlogService;

@Configuration
@PropertySource("classpath:/sample.properties")
public class SampleConfig {

    @Bean
    public BlogDao blogDao() {
        return new DefaultBlogDao();
    }

    @Bean
    public BlogService blogService() {
        return new DefaultBlogService(blogDao());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
