/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Task;

/**
 *
 * @author MakiMica
 */
public class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private final Task[] cache = new Task[100]; 

    @Override public void save(Task task) { tasks.add(task); }
    @Override public List<Task> findAll() { return Collections.unmodifiableList(tasks); }
    @Override public void saveAll(List<Task> list) { tasks.clear(); tasks.addAll(list); }

    
}
