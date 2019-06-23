package com.example.electircalchargestations.Model;

public class DataProvider {

    private String          WebsiteURL;
    private String          Comments                = null;
    //DataProviderStatusType  DataProviderStatusType;
    private boolean         IsRestrictedEdit;
    private boolean         IsOpenDataLicensed;
    private boolean         IsApprovedImport;
    private String          License;
    private String          DateLastImported        = null;
    private float           ID;
    private String          Title;

    public String getWebsiteURL() { return WebsiteURL; }

    public String getComments() { return Comments; }

    //public DataProviderStatusType getDataProviderStatusType() { return DataProviderStatusType; }

    public boolean getIsRestrictedEdit() { return IsRestrictedEdit; }

    public boolean getIsOpenDataLicensed() { return IsOpenDataLicensed; }

    public boolean getIsApprovedImport() { return IsApprovedImport; }

    public String getLicense() { return License; }

    public String getDateLastImported() { return DateLastImported; }

    public float getID() { return ID; }

    public String getTitle() { return Title; }

    public void setWebsiteURL(String WebsiteURL) { this.WebsiteURL = WebsiteURL; }

    public void setComments(String Comments) { this.Comments = Comments; }

    //public void setDataProviderStatusType(DataProviderStatusType DataProviderStatusTypeObject) { this.DataProviderStatusType = DataProviderStatusTypeObject; }

    public void setIsRestrictedEdit(boolean IsRestrictedEdit) { this.IsRestrictedEdit = IsRestrictedEdit; }

    public void setIsOpenDataLicensed(boolean IsOpenDataLicensed) { this.IsOpenDataLicensed = IsOpenDataLicensed; }

    public void setIsApprovedImport(boolean IsApprovedImport) { this.IsApprovedImport = IsApprovedImport; }

    public void setLicense(String License) { this.License = License; }

    public void setDateLastImported(String DateLastImported) { this.DateLastImported = DateLastImported; }

    public void setID(float ID) { this.ID = ID; }

    public void setTitle(String Title) { this.Title = Title; }

    @Override
    public String toString() {
        return "DataProvider{" +
                "WebsiteURL='" + WebsiteURL + '\'' +
                ", Comments='" + Comments + '\'' +
                //", DataProviderStatusType=" + DataProviderStatusType.toString() +
                ", IsRestrictedEdit=" + IsRestrictedEdit +
                ", IsOpenDataLicensed=" + IsOpenDataLicensed +
                ", IsApprovedImport=" + IsApprovedImport +
                ", License='" + License + '\'' +
                ", DateLastImported='" + DateLastImported + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
