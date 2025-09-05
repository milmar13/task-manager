/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.util.List;
import model.Task;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import repository.InMemoryTaskRepository;
import service.sort.SortByDueDate;
import service.sort.SortByPriority;

/**
 *
 * @author MakiMica
 */
public class TaskServiceSortTest {
    
    @Test
    public void sortByPriorityAsc() {
        TaskService s = new TaskService(new InMemoryTaskRepository());
        s.add(new Task("A","",5, LocalDate.now()));
        s.add(new Task("B","",2, LocalDate.now()));
        s.setSortStrategy(new SortByPriority());
        List<Task> out = s.sortCurrent();
        assertEquals("B", out.get(0).getTitle()); 
    }

    @Test
    public void sortByDueDateAsc() {
        TaskService s = new TaskService(new InMemoryTaskRepository());
        s.add(new Task("A","",3, LocalDate.now().plusDays(3)));
        s.add(new Task("B","",3, LocalDate.now().plusDays(1)));
        s.setSortStrategy(new SortByDueDate());
        List<Task> out = s.sortCurrent();
        assertEquals("B", out.get(0).getTitle()); 
    }
}
