package com.example.electircalchargestations.Model;

public class AddressInfo {

    private Integer ID;
    private String  Title;
    private String  AddressLine1;
    private String  AddressLine2;
    private String  Town;
    private String  StateOrProvince;
    private String  Postcode;
    private Integer CountryID;
    private Country Country;
    private Float   Latitude;
    private Float   Longitude;
    private String  ContactTelephone1;
    private String  ContactTelephone2;
    private String  ContactEmail;
    private String  AccessComments;
    private String  RelatedURL;
    //private String Distance;
    //private Integer DistanceUnit;

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

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getStateOrProvince() {
        return StateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        StateOrProvince = stateOrProvince;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public Integer getCountryID() {
        return CountryID;
    }

    public void setCountryID(Integer countryID) {
        CountryID = countryID;
    }

    public com.example.electircalchargestations.Model.Country getCountry() {
        return Country;
    }

    public void setCountry(com.example.electircalchargestations.Model.Country country) {
        Country = country;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    public String getContactTelephone1() {
        return ContactTelephone1;
    }

    public void setContactTelephone1(String contactTelephone1) {
        ContactTelephone1 = contactTelephone1;
    }

    public String getContactTelephone2() {
        return ContactTelephone2;
    }

    public void setContactTelephone2(String contactTelephone2) {
        ContactTelephone2 = contactTelephone2;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public String getAccessComments() {
        return AccessComments;
    }

    public void setAccessComments(String accessComments) {
        AccessComments = accessComments;
    }

    public String getRelatedURL() {
        return RelatedURL;
    }

    public void setRelatedURL(String relatedURL) {
        RelatedURL = relatedURL;
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
                //", Distance='" + Distance + '\'' +
                //", DistanceUnit=" + DistanceUnit +
                '}';
    }
}