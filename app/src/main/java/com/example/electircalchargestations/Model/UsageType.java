package com.example.electircalchargestations.Model;

public class UsageType {

    private boolean IsPayAtLocation;
    private boolean IsMembershipRequired;
    private boolean IsAccessKeyRequired;
    private float ID;
    private String Title;


    // Getter Methods

    public boolean getIsPayAtLocation() {
        return IsPayAtLocation;
    }

    public boolean getIsMembershipRequired() {
        return IsMembershipRequired;
    }

    public boolean getIsAccessKeyRequired() {
        return IsAccessKeyRequired;
    }

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    // Setter Methods

    public void setIsPayAtLocation(boolean IsPayAtLocation) {
        this.IsPayAtLocation = IsPayAtLocation;
    }

    public void setIsMembershipRequired(boolean IsMembershipRequired) {
        this.IsMembershipRequired = IsMembershipRequired;
    }

    public void setIsAccessKeyRequired(boolean IsAccessKeyRequired) {
        this.IsAccessKeyRequired = IsAccessKeyRequired;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "UsageType{" +
                "IsPayAtLocation=" + IsPayAtLocation +
                ", IsMembershipRequired=" + IsMembershipRequired +
                ", IsAccessKeyRequired=" + IsAccessKeyRequired +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}