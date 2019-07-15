package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class UsageType implements Serializable {

    private Boolean IsPayAtLocation;
    private Boolean IsMembershipRequired;
    private Boolean IsAccessKeyRequired;
    private Integer ID;
    private String  Title;

    public Boolean getPayAtLocation() {
        return IsPayAtLocation;
    }

    public void setPayAtLocation(Boolean payAtLocation) {
        IsPayAtLocation = payAtLocation;
    }

    public Boolean getMembershipRequired() {
        return IsMembershipRequired;
    }

    public void setMembershipRequired(Boolean membershipRequired) {
        IsMembershipRequired = membershipRequired;
    }

    public Boolean getAccessKeyRequired() {
        return IsAccessKeyRequired;
    }

    public void setAccessKeyRequired(Boolean accessKeyRequired) {
        IsAccessKeyRequired = accessKeyRequired;
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
        Title = title;
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