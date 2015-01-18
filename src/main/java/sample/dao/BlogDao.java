package sample.dao;

import sample.model.BlogEntry;

public interface BlogDao {
    BlogEntry findById(long id);
}
