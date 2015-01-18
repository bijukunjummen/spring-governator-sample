package sample.spring;

import com.google.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.dao.BlogDao;
import sample.model.BlogEntry;
import sample.service.BlogService;

@Service
public class DefaultBlogService implements BlogService {

    @Autowired
    private final BlogDao blogDao;

    @Inject
    public DefaultBlogService(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public BlogEntry get(long id) {
        return this.blogDao.findById(id);
    }
}
