package sample.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.dao.BlogDao;
import sample.service.BlogService;

@Configuration
public class SampleConfig {

    @Bean
    public BlogDao blogDao() {
        return new DefaultBlogDao();
    }

    @Bean
    public BlogService blogService() {
        return new DefaultBlogService(blogDao());
    }
}
