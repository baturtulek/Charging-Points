package com.example.electircalchargestations.Model;

public class OperatorInfo {

    private String  WebsiteURL;
    private String  Comments;
    private boolean IsPrivateIndividual;
    private String  ContactEmail;
    private Integer ID;
    private String  Title;
    //private String PhonePrimaryContact;       //Most of the time Null.
    //private String PhoneSecondaryContact;     //Most of the time Null.
    //private String AddressInfo;               //Most of the time Null.
    //private String BookingURL;                //Most of the time Null.
    //private String FaultReportEmail;          //Most of the time Null.
    //private Boolean IsRestrictedEdit;         // ?

    public String getWebsiteURL() {
        return WebsiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        WebsiteURL = websiteURL;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public boolean isPrivateIndividual() {
        return IsPrivateIndividual;
    }

    public void setPrivateIndividual(boolean privateIndividual) {
        IsPrivateIndividual = privateIndividual;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

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

    @Override
    public String toString() {
        return "OperatorInfo{" +
                "WebsiteURL='" + WebsiteURL + '\'' +
                ", Comments='" + Comments + '\'' +
                //", PhonePrimaryContact='" + PhonePrimaryContact + '\'' +
                //", PhoneSecondaryContact='" + PhoneSecondaryContact + '\'' +
                ", IsPrivateIndividual=" + IsPrivateIndividual +
                //", AddressInfo='" + AddressInfo + '\'' +
                //", BookingURL='" + BookingURL + '\'' +
                ", ContactEmail='" + ContactEmail + '\'' +
                //", FaultReportEmail='" + FaultReportEmail + '\'' +
                //", IsRestrictedEdit=" + IsRestrictedEdit +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
