package sample.guice;

import com.google.inject.AbstractModule;
import sample.dao.BlogDao;
import sample.service.BlogService;

public class ExampleModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(BlogDao.class).to(DefaultBlogDao.class);
        bind(BlogService.class).to(DefaultBlogService.class);
    }
}
