import controller.TaskController;
import repository.FileTaskRepository; // ili InMemoryTaskRepository
import repository.TaskRepository;
import service.TaskService;
import view.ConsoleView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MakiMica
 */
public class App {
    public static void main(String[] args) {
        TaskRepository repo = new FileTaskRepository(); // trajno čuvanje u tasks.json
        TaskService service = new TaskService(repo);
        TaskController controller = new TaskController(service);
        ConsoleView view = new ConsoleView(controller);
        view.run(); // start konzolnog menija
    }
}
