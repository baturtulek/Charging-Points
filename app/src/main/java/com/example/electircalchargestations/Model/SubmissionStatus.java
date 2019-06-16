package com.example.electircalchargestations.Model;

public class SubmissionStatus {
    private boolean IsLive;
    private float ID;
    private String Title;


    // Getter Methods

    public boolean getIsLive() {
        return IsLive;
    }

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    // Setter Methods

    public void setIsLive(boolean IsLive) {
        this.IsLive = IsLive;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "SubmissionStatus{" +
                "IsLive=" + IsLive +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
