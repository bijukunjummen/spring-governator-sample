package sample.spring;

import org.springframework.stereotype.Repository;
import sample.dao.BlogDao;
import sample.model.BlogEntry;

@Repository
public class DefaultBlogDao implements BlogDao {

    @Override
    public BlogEntry findById(long id) {
        return new BlogEntry(1l, "Test");
    }
}
