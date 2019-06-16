package com.example.electircalchargestations.Model;
import java.util.ArrayList;


public class ChargeStation {

    private float                   ID;
    private String                  UUID;
    private String                  ParentChargePointID = null;
    private int                     DataProviderID;
    private DataProvider            DataProvider;
    private String                  DataProvidersReference = null;
    private float                   OperatorID;
    private OperatorInfo            OperatorInfo;
    private String                  OperatorsReference = null;
    private float                   UsageTypeID;
    private UsageType               UsageType;
    private String                  UsageCost = null;
    private AddressInfo             AddressInfo;
    private float                   NumberOfPoints;
    private String                  GeneralComments;
    private String                  DatePlanned = null;
    private String                  DateLastConfirmed = null;
    private float                   StatusTypeID;
    private StatusType              StatusType;
    private String                  DateLastStatusUpdate;
    private float                   DataQualityLevel;
    private String                  DateCreated;
    private float                   SubmissionStatusTypeID;
    private SubmissionStatus        SubmissionStatus;
    private String                  UserComments = null;
    private String                  PercentageSimilarity = null;
    private ArrayList<Connection>   Connections = new ArrayList();
    private ArrayList<MediaItem>    MediaItems  = new ArrayList();
    private String                  MetadataValues = null;
    private boolean                 IsRecentlyVerified;
    private String                  DateLastVerified;

    public float getID() {
        return ID;
    }

    public String getUUID() {
        return UUID;
    }

    public String getParentChargePointID() {
        return ParentChargePointID;
    }

    public float getDataProviderID() {
        return DataProviderID;
    }

    public DataProvider getDataProvider() {
        return DataProvider;
    }

    public String getDataProvidersReference() {
        return DataProvidersReference;
    }

    public float getOperatorID() {
        return OperatorID;
    }

    public OperatorInfo getOperatorInfo() {
        return OperatorInfo;
    }

    public String getOperatorsReference() {
        return OperatorsReference;
    }

    public float getUsageTypeID() {
        return UsageTypeID;
    }

    public UsageType getUsageType() {
        return UsageType;
    }

    public String getUsageCost() {
        return UsageCost;
    }

    public AddressInfo getAddressInfo() {
        return AddressInfo;
    }

    public float getNumberOfPoints() {
        return NumberOfPoints;
    }

    public String getGeneralComments() {
        return GeneralComments;
    }

    public String getDatePlanned() {
        return DatePlanned;
    }

    public String getDateLastConfirmed() {
        return DateLastConfirmed;
    }

    public float getStatusTypeID() {
        return StatusTypeID;
    }

    public StatusType getStatusType() {
        return StatusType;
    }

    public String getDateLastStatusUpdate() {
        return DateLastStatusUpdate;
    }

    public float getDataQualityLevel() {
        return DataQualityLevel;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public float getSubmissionStatusTypeID() {
        return SubmissionStatusTypeID;
    }

    public SubmissionStatus getSubmissionStatus() {
        return SubmissionStatus;
    }

    public String getUserComments() {
        return UserComments;
    }

    public String getPercentageSimilarity() {
        return PercentageSimilarity;
    }

    public String getMetadataValues() {
        return MetadataValues;
    }

    public boolean getIsRecentlyVerified() {
        return IsRecentlyVerified;
    }

    public String getDateLastVerified() {
        return DateLastVerified;
    }

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setParentChargePointID(String ParentChargePointID) { this.ParentChargePointID = ParentChargePointID; }

    public void setDataProviderID(int DataProviderID) {
        this.DataProviderID = DataProviderID;
    }

    public void setDataProvider(DataProvider DataProviderObject) { this.DataProvider = DataProviderObject; }

    public void setDataProvidersReference(String DataProvidersReference) { this.DataProvidersReference = DataProvidersReference; }

    public void setOperatorID(float OperatorID) {
        this.OperatorID = OperatorID;
    }

    public void setOperatorInfo(OperatorInfo OperatorInfoObject) { this.OperatorInfo = OperatorInfoObject; }

    public void setOperatorsReference(String OperatorsReference) { this.OperatorsReference = OperatorsReference; }

    public void setUsageTypeID(float UsageTypeID) {
        this.UsageTypeID = UsageTypeID;
    }

    public void setUsageType(UsageType UsageTypeObject) {
        this.UsageType = UsageTypeObject;
    }

    public void setUsageCost(String UsageCost) {
        this.UsageCost = UsageCost;
    }

    public void setAddressInfo(AddressInfo AddressInfoObject) { this.AddressInfo = AddressInfoObject; }

    public void setNumberOfPoints(float NumberOfPoints) {
        this.NumberOfPoints = NumberOfPoints;
    }

    public void setGeneralComments(String GeneralComments) { this.GeneralComments = GeneralComments; }

    public void setDatePlanned(String DatePlanned) {
        this.DatePlanned = DatePlanned;
    }

    public void setDateLastConfirmed(String DateLastConfirmed) { this.DateLastConfirmed = DateLastConfirmed; }

    public void setStatusTypeID(float StatusTypeID) {
        this.StatusTypeID = StatusTypeID;
    }

    public void setStatusType(StatusType StatusTypeObject) { this.StatusType = StatusTypeObject; }

    public void setDateLastStatusUpdate(String DateLastStatusUpdate) { this.DateLastStatusUpdate = DateLastStatusUpdate; }

    public void setDataQualityLevel(float DataQualityLevel) { this.DataQualityLevel = DataQualityLevel; }

    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    public void setSubmissionStatusTypeID(float SubmissionStatusTypeID) { this.SubmissionStatusTypeID = SubmissionStatusTypeID; }

    public void setSubmissionStatus(SubmissionStatus SubmissionStatusObject) { this.SubmissionStatus = SubmissionStatusObject; }

    public void setUserComments(String UserComments) {
        this.UserComments = UserComments;
    }

    public void setPercentageSimilarity(String PercentageSimilarity) { this.PercentageSimilarity = PercentageSimilarity; }

    public void setMetadataValues(String MetadataValues) {
        this.MetadataValues = MetadataValues;
    }

    public void setIsRecentlyVerified(boolean IsRecentlyVerified) { this.IsRecentlyVerified = IsRecentlyVerified; }

    public void setDateLastVerified(String DateLastVerified) { this.DateLastVerified = DateLastVerified; }

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
                ", OperatorsReference='" + OperatorsReference + '\'' +
                ", UsageTypeID=" + UsageTypeID +
                ", UsageType=" + UsageType +
                ", UsageCost='" + UsageCost + '\'' +
                ", AddressInfo=" + AddressInfo +
                ", NumberOfPoints=" + NumberOfPoints +
                ", GeneralComments='" + GeneralComments + '\'' +
                ", DatePlanned='" + DatePlanned + '\'' +
                ", DateLastConfirmed='" + DateLastConfirmed + '\'' +
                ", StatusTypeID=" + StatusTypeID +
                ", StatusType=" + StatusType +
                ", DateLastStatusUpdate='" + DateLastStatusUpdate + '\'' +
                ", DataQualityLevel=" + DataQualityLevel +
                ", DateCreated='" + DateCreated + '\'' +
                ", SubmissionStatusTypeID=" + SubmissionStatusTypeID +
                ", SubmissionStatus=" + SubmissionStatus +
                ", UserComments='" + UserComments + '\'' +
                ", PercentageSimilarity='" + PercentageSimilarity + '\'' +
                ", Connections=" + Connections +
                ", MediaItems=" + MediaItems +
                ", MetadataValues='" + MetadataValues + '\'' +
                ", IsRecentlyVerified=" + IsRecentlyVerified +
                ", DateLastVerified='" + DateLastVerified + '\'' +
                '}';
    }
}
