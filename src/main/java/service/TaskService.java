/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Attachment;
import model.Category;
import model.Comment;
import model.Project;
import model.Task;
import model.Task.Status;
import model.User;
import repository.TaskRepository;
import service.sort.SortStrategy;

/**
 *
 * @author MakiMica
 */
public class TaskService {
    private final TaskRepository repo;
    private SortStrategy sortStrategy;
    private long idCount = 1;

    public TaskService(TaskRepository repo) {   
        this.repo = repo;
    }

    public void add(Task t) {
        validate(t);            
        repo.save(t);
    }

    public List<Task> list() {
        return new ArrayList<Task>(repo.findAll());
    }

    public List<Task> filterByStatus(Status s) {
        List<Task> out = new ArrayList<Task>();
        for (Task t : repo.findAll()) {
            if (t.getStatus() == s) out.add(t);
        }
        return out;
    }

    
    private void validate(Task t) {
        if (t == null) throw new IllegalArgumentException("Task je null");
        if (t.getTitle() == null || t.getTitle().trim().isEmpty())
            throw new IllegalArgumentException("Title je prazan");
        if (t.getPriority() < 1 || t.getPriority() > 5)
            throw new IllegalArgumentException("Priority 1..5");
    }
    
    public void setSortStrategy(service.sort.SortStrategy s) { 
        this.sortStrategy = s; 
    }
    
    public List<model.Task> sortCurrent() {
        List<model.Task> all = repo.findAll();
        return (sortStrategy == null) ? all : sortStrategy.sort(all);
}

    public void addTask(String title, String desc, int priority, LocalDate due, String projectName, String categoryName) {
        Project project = new Project();
        project.setName(projectName);

        Category category = new Category();
        category.setName(categoryName);

        Task t;
            t = new Task();
            t.setId(idCount++);
            t.setTitle(title);
            t.setDescription(desc);
            t.setPriority(priority);
            t.setDueDate(due);
            t.setStatus(Task.Status.TODO);
            t.setProject(project);
            t.setCategory(category);
        repo.save(t);    }

    public void updateStatus(long id, Status newStatus) {
        Optional<Task> opt = findById(id);
        if (!opt.isPresent()) return;

        Task t = opt.get();
        t.setStatus(newStatus);

        List<Task> all = list();
        for (int i = 0; i < all.size(); i++) {
            if (equalsId(all.get(i).getId(), id)) {
                all.set(i, t);
                break;
            }
        }
        repo.saveAll(all);
    }
    
     public Optional<Task> findById(long id) {
        for (Task t : list()) {
            if (equalsId(t.getId(), id)) return Optional.of(t);
        }
        return Optional.empty();
    }

    private boolean equalsId(Long a, long b) {
        return a != null && a == b;
    }

    public void addComment(long taskId, String author, String content) {
        Optional<Task> opt = findById(taskId);
        if (!opt.isPresent()) return;

            Task t = opt.get();

            Comment c = new Comment();
            c.setId((int) System.currentTimeMillis());
            c.setContent(content);
            c.setCreatedAt(LocalDateTime.now());

    
            t.getComments().add(c);

            updateStatus(taskId, t.getStatus());
    }

    public void addAttachment(long taskId, String fileName, String path) {
        Optional<Task> opt = findById(taskId);
    if (!opt.isPresent()) return;

    Task t = opt.get();

    Attachment a = new Attachment();
    a.setId((int) System.currentTimeMillis());
    a.setFileName(fileName);
    a.setPath(path);

    if (t.getAttachments() == null) {
        t.setAttachments(new ArrayList<>());
    }
    t.getAttachments().add(a);

    updateStatus(taskId, t.getStatus());
    }
    
    
    
}
