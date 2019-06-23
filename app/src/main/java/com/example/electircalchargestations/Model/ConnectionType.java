package com.example.electircalchargestations.Model;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "connection_type")
public class ConnectionType {

    @PrimaryKey
    @ColumnInfo(name = "connection_id")
    private int     ID;

    @ColumnInfo(name = "formal_name")
    private String  FormalName;

    @ColumnInfo(name = "is_discontinued")
    private boolean IsDiscontinued;

    @ColumnInfo(name = "is_obsolete")
    private boolean IsObsolete;

    @ColumnInfo(name = "title")
    private String  Title;


    public String getFormalName() {
        return FormalName;
    }

    public void setFormalName(String formalName) {
        this.FormalName = formalName;
    }

    public boolean getIsDiscontinued() {
        return IsDiscontinued;
    }

    public void setIsDiscontinued(Boolean isDiscontinued) {
        this.IsDiscontinued = isDiscontinued;
    }

    public boolean getIsObsolete() {
        return IsObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.IsObsolete = isObsolete;
    }

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
        return "ConnectionType{" +
                "formalName=" + FormalName +
                ", isDiscontinued=" + IsDiscontinued +
                ", isObsolete=" + IsObsolete +
                ", iD=" + ID +
                ", title='" + Title + '\'' +
                '}';
    }
}
