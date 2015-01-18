package sample.gov;

import com.google.inject.Inject;
import com.netflix.governator.annotations.AutoBindSingleton;
import sample.dao.BlogDao;
import sample.model.BlogEntry;
import sample.service.BlogService;

@AutoBindSingleton(baseClass = BlogService.class)
public class DefaultBlogService implements BlogService {
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
