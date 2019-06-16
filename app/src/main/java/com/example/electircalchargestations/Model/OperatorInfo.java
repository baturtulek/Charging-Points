package com.example.electircalchargestations.Model;

public class OperatorInfo {

    private String WebsiteURL;
    private String Comments = null;
    private String PhonePrimaryContact = null;
    private String PhoneSecondaryContact = null;
    private boolean IsPrivateIndividual;
    private String AddressInfo = null;
    private String BookingURL = null;
    private String ContactEmail = null;
    private String FaultReportEmail = null;
    private boolean IsRestrictedEdit;
    private float ID;
    private String Title;


    // Getter Methods

    public String getWebsiteURL() {
        return WebsiteURL;
    }

    public String getComments() {
        return Comments;
    }

    public String getPhonePrimaryContact() {
        return PhonePrimaryContact;
    }

    public String getPhoneSecondaryContact() {
        return PhoneSecondaryContact;
    }

    public boolean getIsPrivateIndividual() {
        return IsPrivateIndividual;
    }

    public String getAddressInfo() {
        return AddressInfo;
    }

    public String getBookingURL() {
        return BookingURL;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public String getFaultReportEmail() {
        return FaultReportEmail;
    }

    public boolean getIsRestrictedEdit() {
        return IsRestrictedEdit;
    }

    public float getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    // Setter Methods

    public void setWebsiteURL(String WebsiteURL) {
        this.WebsiteURL = WebsiteURL;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public void setPhonePrimaryContact(String PhonePrimaryContact) {
        this.PhonePrimaryContact = PhonePrimaryContact;
    }

    public void setPhoneSecondaryContact(String PhoneSecondaryContact) {
        this.PhoneSecondaryContact = PhoneSecondaryContact;
    }

    public void setIsPrivateIndividual(boolean IsPrivateIndividual) {
        this.IsPrivateIndividual = IsPrivateIndividual;
    }

    public void setAddressInfo(String AddressInfo) {
        this.AddressInfo = AddressInfo;
    }

    public void setBookingURL(String BookingURL) {
        this.BookingURL = BookingURL;
    }

    public void setContactEmail(String ContactEmail) {
        this.ContactEmail = ContactEmail;
    }

    public void setFaultReportEmail(String FaultReportEmail) {
        this.FaultReportEmail = FaultReportEmail;
    }

    public void setIsRestrictedEdit(boolean IsRestrictedEdit) {
        this.IsRestrictedEdit = IsRestrictedEdit;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "OperatorInfo{" +
                "WebsiteURL='" + WebsiteURL + '\'' +
                ", Comments='" + Comments + '\'' +
                ", PhonePrimaryContact='" + PhonePrimaryContact + '\'' +
                ", PhoneSecondaryContact='" + PhoneSecondaryContact + '\'' +
                ", IsPrivateIndividual=" + IsPrivateIndividual +
                ", AddressInfo='" + AddressInfo + '\'' +
                ", BookingURL='" + BookingURL + '\'' +
                ", ContactEmail='" + ContactEmail + '\'' +
                ", FaultReportEmail='" + FaultReportEmail + '\'' +
                ", IsRestrictedEdit=" + IsRestrictedEdit +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
