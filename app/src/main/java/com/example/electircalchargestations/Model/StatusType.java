package com.example.electircalchargestations.Model;

public class StatusType {

    private Boolean IsOperational;
    private Boolean IsUserSelectable;
    private int     ID;
    private String  Title;

    public boolean getIsOperational() {
        return IsOperational;
    }

    public boolean getIsUserSelectable() {
        return IsUserSelectable;
    }

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setIsOperational(boolean IsOperational) {
        this.IsOperational = IsOperational;
    }

    public void setIsUserSelectable(boolean IsUserSelectable) { this.IsUserSelectable = IsUserSelectable; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "StatusType{" +
                "IsOperational=" + IsOperational +
                ", IsUserSelectable=" + IsUserSelectable +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
