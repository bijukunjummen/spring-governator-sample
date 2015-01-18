package sample.gov;

import com.netflix.governator.annotations.AutoBindSingleton;
import sample.dao.BlogDao;
import sample.model.BlogEntry;

@AutoBindSingleton(baseClass = BlogDao.class)
public class DefaultBlogDao implements BlogDao {

    @Override
    public BlogEntry findById(long id) {
        return new BlogEntry(1l, "Test");
    }
}
