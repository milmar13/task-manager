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

/**
 *
 * @author MakiMica
 */
public class TaskServiceTest {

    @Test
    public void testAddAndList() {
        TaskService service = new TaskService(new InMemoryTaskRepository());

        Task t = new Task("Ispit", "Učiti za ispit", 3, LocalDate.now().plusDays(2));
        service.add(t);

        List<Task> all = service.list();

        assertEquals(1, all.size());
        assertEquals("Ispit", all.get(0).getTitle());
        assertEquals(3, all.get(0).getPriority());
        assertEquals(Task.Status.TODO, all.get(0).getStatus());
    }
}
