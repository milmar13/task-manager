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
public class User {
    private int id;
    private String name;
    private String email;
    private List<Project> projects = new ArrayList<>();

    public User() {}
    public User(int id, String name, String email) {
        this.id = id; this.name = name; this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    @Override public String toString() { return "User{" + id + ", " + name + ", " + email + "}"; }
    @Override public boolean equals(Object o){ return o instanceof User && Objects.equals(id, ((User)o).id); }
    @Override public int hashCode(){ return Objects.hashCode(id); }
}
