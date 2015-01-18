package sample.guice;

import sample.dao.BlogDao;
import sample.model.BlogEntry;

public class DefaultBlogDao implements BlogDao {

    @Override
    public BlogEntry findById(long id) {
        return new BlogEntry(1l, "Test");
    }
}
