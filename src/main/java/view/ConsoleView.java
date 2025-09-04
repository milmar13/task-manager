/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TaskController;
import java.time.LocalDate;
import java.util.Scanner;
import model.Task;

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
        Scanner sc = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.println();
            System.out.println("=== Task Manager ===");
            System.out.println("1) Dodaj");
            System.out.println("2) Prikaži sve");
            System.out.println("3) Sort by due");
            System.out.println("4) Sort by priority");
            System.out.println("5) Promeni status zadatka");
            System.out.println("0) Kraj");
            System.out.print("Izbor: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": {
                    System.out.print("Naslov: ");
                    String title = sc.nextLine().trim();

                    System.out.print("Opis: ");
                    String desc = sc.nextLine().trim();

                    System.out.print("Prioritet (1-5): ");
                    int pr = parseIntSafe(sc.nextLine(), 3);

                    System.out.print("Rok (YYYY-MM-DD): ");
                    LocalDate due = parseDateSafe(sc.nextLine(), LocalDate.now().plusDays(7));

                    System.out.print("Naziv projekta: ");
                    String projectName = sc.nextLine().trim();

                    System.out.print("Naziv kategorije: ");
                    String categoryName = sc.nextLine().trim();

                    controller.addTask(title, desc, pr, due, projectName, categoryName);
                    System.out.println("Zadatak dodat.");
                    break;
                }
                case "2": {
                    for (Task t : controller.listTasks()) {
                        System.out.println(t);
                    }
                    break;
                }
                case "3": {
                    for (Task t : controller.sortByDue()) {
                        System.out.println(t);
                    }
                    break;
                }
                case "4": {
                    for (Task t : controller.sortByPriority()) {
                        System.out.println(t);
                    }
                    break;
                }
                case "5": {
                    System.out.print("Unesi ID zadatka: ");
                    long id = parseLongSafe(sc.nextLine(), -1L);
                    if (id < 0) {
                        System.out.println("Neispravan ID.");
                        break;
                    }
                    System.out.println("Novi status: 1) TODO  2) IN_PROGRESS  3) DONE");
                    System.out.print("Izbor: ");
                    int s = parseIntSafe(sc.nextLine(), 1);
                    Task.Status newStatus = toStatus(s);
                    controller.updateStatus(id, newStatus);
                    System.out.println("Status izmenjen na: " + newStatus);
                    break;
                }
                case "0":
                    System.out.println("Dovidjenja!");
                    return;
                default:
                    System.out.println("Nepoznata opcija");
            }
        }
    }

    private static int parseIntSafe(String s, int def) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return def; }
    }

    private static long parseLongSafe(String s, long def) {
        try { return Long.parseLong(s.trim()); } catch (Exception e) { return def; }
    }

    private static LocalDate parseDateSafe(String s, LocalDate def) {
        try { return LocalDate.parse(s.trim()); } catch (Exception e) { return def; }
    }

    private static Task.Status toStatus(int choice) {
        switch (choice) {
            case 1:  return Task.Status.TODO;
            case 2:  return Task.Status.IN_PROGRESS;
            case 3:  return Task.Status.DONE;
            default: return Task.Status.TODO;
        }
    }
}

