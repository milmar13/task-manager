/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author MakiMica
 */
public class Attachment {
    private int id;
    private String fileName;
    private String path;
    private LocalDateTime addedAt;

    public Attachment() {}
    public Attachment(int id, String fileName, String path, LocalDateTime addedAt) {
        this.id = id; this.fileName = fileName; this.path = path; this.addedAt = addedAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }

    @Override public String toString(){ return fileName + " (" + path + ")"; }
    @Override public boolean equals(Object o){ return o instanceof Attachment && Objects.equals(id, ((Attachment)o).id); }
    @Override public int hashCode(){ return Objects.hashCode(id); }
}
