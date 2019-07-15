package com.example.electircalchargestations.Model;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "charger_type")
public class Level implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "charger_id")
    private int     ID;

    @ColumnInfo(name = "comments")
    private String  Comments;

    @ColumnInfo(name = "is_fast_charge_capable")
    private boolean IsFastChargeCapable;

    @ColumnInfo(name = "title")
    private String  Title;

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    public boolean getIsFastChargeCapable() {
        return IsFastChargeCapable;
    }

    public void setIsFastChargeCapable(Boolean isFastChargeCapable) { this.IsFastChargeCapable = isFastChargeCapable; }

    public int getID() {
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
