package com.example.electircalchargestations.Model;

public class ConnectionType {

    private Object FormalName;
    private Boolean IsDiscontinued;
    private Boolean IsObsolete;
    private Integer ID;
    private String Title;

    public Object getFormalName() {
        return FormalName;
    }

    public void setFormalName(Object formalName) {
        this.FormalName = formalName;
    }

    public Boolean getIsDiscontinued() {
        return IsDiscontinued;
    }

    public void setIsDiscontinued(Boolean isDiscontinued) {
        this.IsDiscontinued = isDiscontinued;
    }

    public Boolean getIsObsolete() {
        return IsObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.IsObsolete = isObsolete;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        this.ID = iD;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    @Override
    public String toString() {
        return "ConnectionType{" +
                "formalName=" + FormalName +
                ", isDiscontinued=" + IsDiscontinued +
                ", isObsolete=" + IsObsolete +
                ", iD=" + ID +
                ", title='" + Title + '\'' +
                '}';
    }
}
