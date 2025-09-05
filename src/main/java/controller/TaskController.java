/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.List;
import model.Task;
import service.TaskService;

/**
 *
 * @author MakiMica
 */
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public List<Task> listTasks() {
        return service.list();
    }
    
    public List<model.Task> sortByDue() {
        service.setSortStrategy(new service.sort.SortByDueDate());
        return service.sortCurrent();
    }

    public List<model.Task> sortByPriority() {
        service.setSortStrategy(new service.sort.SortByPriority());
        return service.sortCurrent();
    }

    public void addTask(String title, String desc, int pr, LocalDate due, String projectName, String categoryName) {
        service.addTask(title, desc, pr, due, projectName, categoryName);
    }

    public void updateStatus(long id, Task.Status newStatus) {
        service.updateStatus(id, newStatus);    }

    public void addComment(long taskId, String author, String content) {
        service.addComment(taskId, author, content);
    }

    public void addAttachment(long taskId, String fileName, String path) {
        service.addAttachment(taskId, fileName, path);

    }
}
