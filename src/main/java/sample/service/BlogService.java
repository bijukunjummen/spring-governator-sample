package sample.service;

import sample.model.BlogEntry;

public interface BlogService {
    public BlogEntry get(long id);
    String getBlogServiceName();
}
