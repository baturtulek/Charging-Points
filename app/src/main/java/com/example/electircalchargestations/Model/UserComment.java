package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class UserComment implements Serializable {

    private int     ID;
    private int     ChargePointID;
    private int     CommentTypeID;
    private String  UserName;
    private String  Comment;
    private short   Rating;
    private String  RelatedURL;
    private String  DateCreated;
    //private User    User;
    private int     CheckinStatusTypeID;

    public int getID() { return ID; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getChargePointID() {
        return ChargePointID;
    }

    public void setChargePointID(int chargePointID) {
        ChargePointID = chargePointID;
    }

    public int getCommentTypeID() {
        return CommentTypeID;
    }

    public void setCommentTypeID(int commentTypeID) {
        CommentTypeID = commentTypeID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public short getRating() {
        return Rating;
    }

    public void setRating(short rating) {
        Rating = rating;
    }

    public String getRelatedURL() {
        return RelatedURL;
    }

    public void setRelatedURL(String relatedURL) {
        RelatedURL = relatedURL;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public int getCheckinStatusTypeID() {
        return CheckinStatusTypeID;
    }

    public void setCheckinStatusTypeID(int checkinStatusTypeID) { CheckinStatusTypeID = checkinStatusTypeID; }
}
