/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.sort;

import java.util.List;
import model.Task;

/**
 *
 * @author MakiMica
 */
public interface SortStrategy {
     List<Task> sort(List<Task> in);
}
