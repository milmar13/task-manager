/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
public enum Status { TODO, IN_PROGRESS, DONE }

    private Long id;
    private String title;
    private String description;
    private int priority;              // 1..5
    private LocalDate dueDate;
    private Status status = Status.TODO;

    private User author;               
    private Project project;           
    private Category category;         

    private final List<Comment> comments = new ArrayList<>();
    private final List<Attachment> attachments = new ArrayList<>();

    public Task() {}

    public Task(Long id, String title, String description, int priority,
                LocalDate dueDate, Status status, User author,
                Project project, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        if (status != null) this.status = status;
        this.author = author;
        this.project = project;
        this.category = category;
    }

    public Task(String title, String description, int priority, LocalDate dueDate) {
        this(null, title, description, priority, dueDate, Status.TODO, null, null, null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

       
    public void addComment(Comment c) { if (c != null) comments.add(c); }
    public void addAttachment(Attachment a) { if (a != null) attachments.add(a); }

    public void validate() {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("title je prazan");
        if (priority < 1 || priority > 5)
            throw new IllegalArgumentException("priority mora biti 1..5");
    }

    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", prio=" + priority +
               ", due=" + dueDate +
               ", status=" + status +
               ", project=" + (project != null ? project.getName() : "-") +
               ", category=" + (category != null ? category.getName() : "-") +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Task && Objects.equals(id, ((Task)o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
