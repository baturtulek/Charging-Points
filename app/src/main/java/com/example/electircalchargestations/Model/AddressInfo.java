package com.example.electircalchargestations.Model;

public class AddressInfo {

    private float ID;
    private String Title;
    private String AddressLine1;
    private String AddressLine2 = null;
    private String Town;
    private String StateOrProvince = null;
    private String Postcode = null;
    private float CountryID;
    private Country Country;
    private float Latitude;
    private float Longitude;
    private String ContactTelephone1 = null;
    private String ContactTelephone2 = null;
    private String ContactEmail = null;
    private String AccessComments;
    private String RelatedURL = null;
    private String Distance = null;
    private float DistanceUnit;

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public String getTown() {
        return Town;
    }

    public String getStateOrProvince() {
        return StateOrProvince;
    }

    public String getPostcode() {
        return Postcode;
    }

    public float getCountryID() {
        return CountryID;
    }

    public Country getCountry() {
        return Country;
    }

    public float getLatitude() {
        return Latitude;
    }

    public float getLongitude() {
        return Longitude;
    }

    public String getContactTelephone1() {
        return ContactTelephone1;
    }

    public String getContactTelephone2() {
        return ContactTelephone2;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public String getAccessComments() {
        return AccessComments;
    }

    public String getRelatedURL() {
        return RelatedURL;
    }

    public String getDistance() {
        return Distance;
    }

    public float getDistanceUnit() {
        return DistanceUnit;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public void setStateOrProvince(String StateOrProvince) { this.StateOrProvince = StateOrProvince; }

    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public void setCountryID(float CountryID) {
        this.CountryID = CountryID;
    }

    public void setCountry(Country CountryObject) {
        this.Country = CountryObject;
    }

    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public void setContactTelephone1(String ContactTelephone1) {
        this.ContactTelephone1 = ContactTelephone1;
    }

    public void setContactTelephone2(String ContactTelephone2) {
        this.ContactTelephone2 = ContactTelephone2;
    }

    public void setContactEmail(String ContactEmail) {
        this.ContactEmail = ContactEmail;
    }

    public void setAccessComments(String AccessComments) {
        this.AccessComments = AccessComments;
    }

    public void setRelatedURL(String RelatedURL) {
        this.RelatedURL = RelatedURL;
    }

    public void setDistance(String Distance) {
        this.Distance = Distance;
    }

    public void setDistanceUnit(float DistanceUnit) {
        this.DistanceUnit = DistanceUnit;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", AddressLine1='" + AddressLine1 + '\'' +
                ", AddressLine2='" + AddressLine2 + '\'' +
                ", Town='" + Town + '\'' +
                ", StateOrProvince='" + StateOrProvince + '\'' +
                ", Postcode='" + Postcode + '\'' +
                ", CountryID=" + CountryID +
                ", CountryObject=" + Country.toString() +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", ContactTelephone1='" + ContactTelephone1 + '\'' +
                ", ContactTelephone2='" + ContactTelephone2 + '\'' +
                ", ContactEmail='" + ContactEmail + '\'' +
                ", AccessComments='" + AccessComments + '\'' +
                ", RelatedURL='" + RelatedURL + '\'' +
                ", Distance='" + Distance + '\'' +
                ", DistanceUnit=" + DistanceUnit +
                '}';
    }
}