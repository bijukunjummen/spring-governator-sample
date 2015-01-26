package sample.spring;

import com.google.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.dao.BlogDao;
import sample.model.BlogEntry;
import sample.service.BlogService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class DefaultBlogService implements BlogService {

    private final BlogDao blogDao;

    @Autowired
    public DefaultBlogService(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public BlogEntry get(long id) {
        return this.blogDao.findById(id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct called!!");
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre-destroy called!!");
    }
}
