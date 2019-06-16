package com.example.electircalchargestations.Model;

public class DataProviderStatusType {
    private boolean IsProviderEnabled;
    private float   ID;
    private String  Title;

    public boolean getIsProviderEnabled() {
        return IsProviderEnabled;
    }

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setIsProviderEnabled(boolean IsProviderEnabled) { this.IsProviderEnabled = IsProviderEnabled; }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "DataProviderStatusType{" +
                "IsProviderEnabled=" + IsProviderEnabled +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
