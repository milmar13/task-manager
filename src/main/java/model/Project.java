/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MakiMica
 */
public class Project {
     private int id;
    private String name;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public Project() {}
    public Project(int id, String name, String description) {
        this.id = id; this.name = name; this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    @Override public String toString(){ return "Project{" + id + ", " + name + "}"; }
    @Override public boolean equals(Object o){ return o instanceof Project && Objects.equals(id, ((Project)o).id); }
    @Override public int hashCode(){ return Objects.hashCode(id); }
}
