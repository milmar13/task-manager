/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TaskController;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author MakiMica
 */
public class ConsoleView {
    private final TaskController controller;

    public ConsoleView(TaskController controller) {
        this.controller = controller;
    }

   public void run() {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    while (true) {
        System.out.println("1) Dodaj  2) Prikaži sve  3) Sort by due  4) Sort by priority  0) Kraj");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                System.out.print("Naslov: ");
                String title = sc.nextLine();
                System.out.print("Opis: ");
                String desc = sc.nextLine();
                System.out.print("Prioritet (1-5): ");
                int pr = Integer.parseInt(sc.nextLine());
                System.out.print("Rok (YYYY-MM-DD): ");
                java.time.LocalDate due = java.time.LocalDate.parse(sc.nextLine());
                controller.addTask(title, desc, pr, due);
                break;

            case "2":
                for (model.Task t : controller.listTasks()) {
                    System.out.println(t);
                }
                break;
            case "3":
                for (model.Task t : controller.sortByDue()) System.out.println(t);
                break;
            case "4":
                for (model.Task t : controller.sortByPriority()) System.out.println(t);
                break;

            case "0":
                return;

            default:
                System.out.println("Nepoznata opcija");
        }
    }
}

}
