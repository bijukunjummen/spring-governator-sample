package sample.model;

public class BlogEntry {
    private final Long id;
    private final String content;

    public BlogEntry(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
