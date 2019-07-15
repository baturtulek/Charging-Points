package com.example.electircalchargestations.Model;
import java.io.Serializable;
import java.util.ArrayList;

public class ChargeStation implements Serializable {
    private float                   ID;
    private String                  UUID;
    private Integer                 ParentChargePointID;
    private int                     DataProviderID;
    private DataProvider            DataProvider;
    private String                  DataProvidersReference;
    private Integer                 OperatorID;
    private OperatorInfo            OperatorInfo;
    //private Integer                  OperatorsReference;
    private Integer                   UsageTypeID;
    private UsageType               UsageType;
    private String                  UsageCost;
    private AddressInfo             AddressInfo;
    private Integer                 NumberOfPoints;
    private String                  GeneralComments;
    //private String                  DatePlanned;
    //private String                  DateLastConfirmed;
    private Integer                 StatusTypeID;
    private StatusType              StatusType;
    private String                  DateLastStatusUpdate;
    private Integer                 DataQualityLevel;
    private String                  DateCreated;
    private ArrayList<UserComment>  UserComments    = new ArrayList<>();
    //private String                  PercentageSimilarity;
    private ArrayList<Connection>   Connections     = new ArrayList();
    private ArrayList<MediaItem>    MediaItems      = new ArrayList();
    //private String                  MetadataValues
    private boolean                 IsRecentlyVerified;
    //private String                  DateLastVerified;


    public float getID() {
        return ID;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Integer getParentChargePointID() {
        return ParentChargePointID;
    }

    public void setParentChargePointID(Integer parentChargePointID) {
        ParentChargePointID = parentChargePointID;
    }

    public int getDataProviderID() {
        return DataProviderID;
    }

    public void setDataProviderID(int dataProviderID) {
        DataProviderID = dataProviderID;
    }

    public com.example.electircalchargestations.Model.DataProvider getDataProvider() {
        return DataProvider;
    }

    public void setDataProvider(com.example.electircalchargestations.Model.DataProvider dataProvider) {
        DataProvider = dataProvider;
    }

    public String getDataProvidersReference() {
        return DataProvidersReference;
    }

    public void setDataProvidersReference(String dataProvidersReference) {
        DataProvidersReference = dataProvidersReference;
    }

    public Integer getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(Integer operatorID) {
        OperatorID = operatorID;
    }

    public com.example.electircalchargestations.Model.OperatorInfo getOperatorInfo() {
        return OperatorInfo;
    }

    public void setOperatorInfo(com.example.electircalchargestations.Model.OperatorInfo operatorInfo) {
        OperatorInfo = operatorInfo;
    }

    public Integer getUsageTypeID() {
        return UsageTypeID;
    }

    public void setUsageTypeID(Integer usageTypeID) {
        UsageTypeID = usageTypeID;
    }

    public com.example.electircalchargestations.Model.UsageType getUsageType() {
        return UsageType;
    }

    public void setUsageType(com.example.electircalchargestations.Model.UsageType usageType) {
        UsageType = usageType;
    }

    public String getUsageCost() {
        return UsageCost;
    }

    public void setUsageCost(String usageCost) {
        UsageCost = usageCost;
    }

    public com.example.electircalchargestations.Model.AddressInfo getAddressInfo() {
        return AddressInfo;
    }

    public void setAddressInfo(com.example.electircalchargestations.Model.AddressInfo addressInfo) {
        AddressInfo = addressInfo;
    }

    public Integer getNumberOfPoints() {
        return NumberOfPoints;
    }

    public void setNumberOfPoints(Integer numberOfPoints) {
        NumberOfPoints = numberOfPoints;
    }

    public String getGeneralComments() {
        return GeneralComments;
    }

    public void setGeneralComments(String generalComments) {
        GeneralComments = generalComments;
    }

    public Integer getStatusTypeID() {
        return StatusTypeID;
    }

    public void setStatusTypeID(Integer statusTypeID) {
        StatusTypeID = statusTypeID;
    }

    public com.example.electircalchargestations.Model.StatusType getStatusType() {
        return StatusType;
    }

    public void setStatusType(com.example.electircalchargestations.Model.StatusType statusType) {
        StatusType = statusType;
    }

    public String getDateLastStatusUpdate() {
        return DateLastStatusUpdate;
    }

    public void setDateLastStatusUpdate(String dateLastStatusUpdate) {
        DateLastStatusUpdate = dateLastStatusUpdate;
    }

    public Integer getDataQualityLevel() {
        return DataQualityLevel;
    }

    public void setDataQualityLevel(Integer dataQualityLevel) {
        DataQualityLevel = dataQualityLevel;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public ArrayList<Connection> getConnections() {
        return Connections;
    }

    public void setConnections(ArrayList<Connection> connections) {
        Connections = connections;
    }

    public ArrayList<MediaItem> getMediaItems() {
        return MediaItems;
    }

    public void setMediaItems(ArrayList<MediaItem> mediaItems) {
        MediaItems = mediaItems;
    }

    public boolean isRecentlyVerified() {
        return IsRecentlyVerified;
    }

    public void setRecentlyVerified(boolean recentlyVerified) {
        IsRecentlyVerified = recentlyVerified;
    }

    public ArrayList<UserComment> getUserComments() {
        return UserComments;
    }

    public void setUserComments(ArrayList<UserComment> userComments) {
        UserComments = userComments;
    }

    @Override
    public String toString() {
        return "ChargeStation{" +
                "ID=" + ID +
                ", UUID='" + UUID + '\'' +
                ", ParentChargePointID='" + ParentChargePointID + '\'' +
                ", DataProviderID=" + DataProviderID +
                ", DataProvider=" + DataProvider +
                ", DataProvidersReference='" + DataProvidersReference + '\'' +
                ", OperatorID=" + OperatorID +
                ", OperatorInfo=" + OperatorInfo +
                ", UsageTypeID=" + UsageTypeID +
                ", UsageType=" + UsageType +
                ", UsageCost='" + UsageCost + '\'' +
                ", AddressInfo=" + AddressInfo +
                ", NumberOfPoints=" + NumberOfPoints +
                ", GeneralComments='" + GeneralComments + '\'' +
                ", StatusTypeID=" + StatusTypeID +
                ", StatusType=" + StatusType +
                ", DateLastStatusUpdate='" + DateLastStatusUpdate + '\'' +
                ", DataQualityLevel=" + DataQualityLevel +
                ", DateCreated='" + DateCreated + '\'' +
                //", SubmissionStatus=" + SubmissionStatus +
                ", UserComment='" + UserComments + '\'' +
                ", Connections=" + Connections +
                ", MediaItems=" + MediaItems +
                ", IsRecentlyVerified=" + IsRecentlyVerified;
    }
}
