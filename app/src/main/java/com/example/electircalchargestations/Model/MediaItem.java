package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class MediaItem implements Serializable {
    private int     ID;
    private int     ChargePointID;
    private String  ItemURL;
    private String  ItemThumbnailURL;
    private String  Comment;
    private boolean IsEnabled;
    private boolean IsVideo;
    private String  DateCreated;
    //private boolean IsFeaturedItem;
    //private boolean IsExternalResource;
    //private Object MetadataValue;
    //private User User;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        this.ID = iD;
    }

    public Integer getChargePointID() {
        return ChargePointID;
    }

    public void setChargePointID(Integer chargePointID) {
        this.ChargePointID = chargePointID;
    }

    public String getItemURL() {
        return ItemURL;
    }

    public void setItemURL(String itemURL) {
        this.ItemURL = itemURL;
    }

    public String getItemThumbnailURL() {
        return ItemThumbnailURL;
    }

    public void setItemThumbnailURL(String itemThumbnailURL) { this.ItemThumbnailURL = itemThumbnailURL; }

    public String getComment() { return Comment; }

    public void setComment(String comment) {
        this.Comment = comment;
    }

    public Boolean getIsEnabled() {
        return IsEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.IsEnabled = isEnabled;
    }

    public Boolean getIsVideo() {
        return IsVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.IsVideo = isVideo;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.DateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "iD=" + ID +
                ", chargePointID=" + ChargePointID +
                ", itemURL='" + ItemURL + '\'' +
                ", itemThumbnailURL='" + ItemThumbnailURL + '\'' +
                ", comment='" + Comment + '\'' +
                ", isEnabled=" + IsEnabled +
                ", isVideo=" + IsVideo +
                //", isFeaturedItem=" + IsFeaturedItem +
                //", isExternalResource=" + IsExternalResource +
                //", metadataValue=" + MetadataValue +
                //", user=" + User.toString() +
                ", dateCreated='" + DateCreated + '\'' +
                '}';
    }
}
