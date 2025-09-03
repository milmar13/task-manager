/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Task;
import model.Task.Status;
import repository.TaskRepository;
import service.sort.SortStrategy;

/**
 *
 * @author MakiMica
 */
public class TaskService {
    private final TaskRepository repo;
    private SortStrategy sortStrategy;

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
    
    public java.util.List<model.Task> sortCurrent() {
        List<model.Task> all = repo.findAll();
        return (sortStrategy == null) ? all : sortStrategy.sort(all);
}
}
