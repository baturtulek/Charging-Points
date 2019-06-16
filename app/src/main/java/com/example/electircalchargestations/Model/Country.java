package com.example.electircalchargestations.Model;

public class Country {

    private String ISOCode;
    private String ContinentCode;
    private float ID;
    private String Title;

    public String getISOCode() {
        return ISOCode;
    }

    public String getContinentCode() {
        return ContinentCode;
    }

    public float getID() {
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

    public void setID(float ID) {
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