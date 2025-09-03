/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author MakiMica
 */
public class Comment {
    private int id;
    private User author;
    private String content;
    private LocalDateTime createdAt;

    public Comment() {}
    public Comment(int id, User author, String content, LocalDateTime createdAt) {
        this.id = id; this.author = author; this.content = content; this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override public String toString(){ return author + ": " + content; }
    @Override public boolean equals(Object o){ return o instanceof Comment && Objects.equals(id, ((Comment)o).id); }
    @Override public int hashCode(){ return Objects.hashCode(id); }
}
