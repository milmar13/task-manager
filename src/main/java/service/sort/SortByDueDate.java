/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import model.Task;

/**
 *
 * @author MakiMica
 */
public class SortByDueDate implements SortStrategy{

    @Override
    public List<Task> sort(List<Task> in) {
        return in.stream()
                 .sorted(Comparator.comparing(Task::getDueDate))
                 .collect(Collectors.toList());
    }
    
}
