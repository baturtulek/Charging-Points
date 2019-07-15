package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class CurrentType implements Serializable {

    private String  Description;
    private Integer ID;
    private String  Title;

    public String getDescription() { return Description; }

    public void setDescription(String description) {
        this.Description = description;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    @Override
    public String toString() {
        return "CurrentType{" +
                "Description='" + Description + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}