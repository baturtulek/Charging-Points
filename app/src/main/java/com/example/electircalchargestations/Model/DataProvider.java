package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class DataProvider implements Serializable {

    private String          WebsiteURL;
    private String          Comments;
    //DataProviderStatusType  DataProviderStatusType;
    //private boolean         IsRestrictedEdit;         // ?
    //private boolean         IsOpenDataLicensed;       // ?
    //private boolean         IsApprovedImport;         // ?
    private String          License;
    //private String          DateLastImported;
    private Integer           ID;
    private String          Title;

    public String getWebsiteURL() { return WebsiteURL; }

    public String getComments() { return Comments; }

    //public DataProviderStatusType getDataProviderStatusType() { return DataProviderStatusType; }

    public String getLicense() { return License; }

    public float getID() { return ID; }

    public String getTitle() { return Title; }

    public void setWebsiteURL(String WebsiteURL) { this.WebsiteURL = WebsiteURL; }

    public void setComments(String Comments) { this.Comments = Comments; }

    //public void setDataProviderStatusType(DataProviderStatusType DataProviderStatusTypeObject) { this.DataProviderStatusType = DataProviderStatusTypeObject; }

    public void setLicense(String License) { this.License = License; }

    public void setID(Integer ID) { this.ID = ID; }

    public void setTitle(String Title) { this.Title = Title; }

    @Override
    public String toString() {
        return "DataProvider{" +
                "WebsiteURL='" + WebsiteURL + '\'' +
                ", Comments='" + Comments + '\'' +
                //", DataProviderStatusType=" + DataProviderStatusType.toString() +
                //", IsRestrictedEdit=" + IsRestrictedEdit +
                //", IsOpenDataLicensed=" + IsOpenDataLicensed +
                //", IsApprovedImport=" + IsApprovedImport +
                ", License='" + License + '\'' +
                //", DateLastImported='" + DateLastImported + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                '}';
    }
}
