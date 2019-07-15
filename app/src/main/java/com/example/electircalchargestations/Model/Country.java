package com.example.electircalchargestations.Model;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "country")
public class Country implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "country_id")
    private int     ID;

    @ColumnInfo(name = "country_code")
    private String  ISOCode;

    @ColumnInfo(name = "continent_code")
    private String  ContinentCode;

    @ColumnInfo(name = "country_title")
    private String  Title;


    public String getISOCode() {
        return ISOCode;
    }

    public String getContinentCode() {
        return ContinentCode;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setISOCode(String ISOCode) {
        this.ISOCode = ISOCode;
    }

    public void setContinentCode(String ContinentCode) {
        this.ContinentCode = ContinentCode;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "Country{" +
                "ISOCode='" + ISOCode + '\'' +
                ", ContinentCode='" + ContinentCode + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}