package com.example.electircalchargestations.Model;

public class Level {

    private String Comments;
    private Boolean IsFastChargeCapable;
    private Integer ID;
    private String Title;

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    public Boolean getIsFastChargeCapable() {
        return IsFastChargeCapable;
    }

    public void setIsFastChargeCapable(Boolean isFastChargeCapable) {
        this.IsFastChargeCapable = isFastChargeCapable;
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
        return "Level{" +
                "Comments='" + Comments + '\'' +
                ", IsFastChargeCapable=" + IsFastChargeCapable +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
