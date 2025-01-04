package models;

import java.util.UUID;

public final class Comment {

    private final UUID id;
    private final String author;
    private String text;

    public Comment(String author, String text) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Комментарий (%s) от автора '%s': %s", id.toString(), author, text);
    }
}
