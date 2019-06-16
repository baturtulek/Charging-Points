package com.example.electircalchargestations.Model;

public class User {

    private int ID;
    private Object IdentityProvider;
    private Object Identifier;
    private Object CurrentSessionToken;
    private String Username;
    private Object Profile;
    private Object Location;
    private Object WebsiteURL;
    private int ReputationPoints;
    private Object Permissions;
    private Object PermissionsRequested;
    private Object DateCreated;
    private Object DateLastLogin;
    private Object IsProfilePublic;
    private Object IsEmergencyChargingProvider;
    private Object IsPublicChargingProvider;
    private Object Latitude;
    private Object Longitude;
    private Object EmailAddress;
    private Object EmailHash;
    private String ProfileImageURL;
    private Object IsCurrentSessionTokenValid;
    private Object APIKey;
    private Object SyncedSettings;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Object getIdentityProvider() {
        return IdentityProvider;
    }

    public void setIdentityProvider(Object identityProvider) {
        IdentityProvider = identityProvider;
    }

    public Object getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Object identifier) {
        Identifier = identifier;
    }

    public Object getCurrentSessionToken() {
        return CurrentSessionToken;
    }

    public void setCurrentSessionToken(Object currentSessionToken) {
        CurrentSessionToken = currentSessionToken;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Object getProfile() {
        return Profile;
    }

    public void setProfile(Object profile) {
        Profile = profile;
    }

    public Object getLocation() {
        return Location;
    }

    public void setLocation(Object location) {
        Location = location;
    }

    public Object getWebsiteURL() {
        return WebsiteURL;
    }

    public void setWebsiteURL(Object websiteURL) {
        WebsiteURL = websiteURL;
    }

    public Integer getReputationPoints() {
        return ReputationPoints;
    }

    public void setReputationPoints(Integer reputationPoints) {
        ReputationPoints = reputationPoints;
    }

    public Object getPermissions() {
        return Permissions;
    }

    public void setPermissions(Object permissions) {
        Permissions = permissions;
    }

    public Object getPermissionsRequested() {
        return PermissionsRequested;
    }

    public void setPermissionsRequested(Object permissionsRequested) {
        PermissionsRequested = permissionsRequested;
    }

    public Object getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Object dateCreated) {
        DateCreated = dateCreated;
    }

    public Object getDateLastLogin() {
        return DateLastLogin;
    }

    public void setDateLastLogin(Object dateLastLogin) {
        DateLastLogin = dateLastLogin;
    }

    public Object getIsProfilePublic() {
        return IsProfilePublic;
    }

    public void setIsProfilePublic(Object isProfilePublic) {
        IsProfilePublic = isProfilePublic;
    }

    public Object getIsEmergencyChargingProvider() {
        return IsEmergencyChargingProvider;
    }

    public void setIsEmergencyChargingProvider(Object isEmergencyChargingProvider) {
        IsEmergencyChargingProvider = isEmergencyChargingProvider;
    }

    public Object getIsPublicChargingProvider() {
        return IsPublicChargingProvider;
    }

    public void setIsPublicChargingProvider(Object isPublicChargingProvider) {
        IsPublicChargingProvider = isPublicChargingProvider;
    }

    public Object getLatitude() {
        return Latitude;
    }

    public void setLatitude(Object latitude) {
        Latitude = latitude;
    }

    public Object getLongitude() {
        return Longitude;
    }

    public void setLongitude(Object longitude) {
        Longitude = longitude;
    }

    public Object getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(Object emailAddress) {
        EmailAddress = emailAddress;
    }

    public Object getEmailHash() {
        return EmailHash;
    }

    public void setEmailHash(Object emailHash) {
        EmailHash = emailHash;
    }

    public String getProfileImageURL() {
        return ProfileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        ProfileImageURL = profileImageURL;
    }

    public Object getIsCurrentSessionTokenValid() {
        return IsCurrentSessionTokenValid;
    }

    public void setIsCurrentSessionTokenValid(Object isCurrentSessionTokenValid) {
        IsCurrentSessionTokenValid = isCurrentSessionTokenValid;
    }

    public Object getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(Object APIKey) {
        this.APIKey = APIKey;
    }

    public Object getSyncedSettings() {
        return SyncedSettings;
    }

    public void setSyncedSettings(Object syncedSettings) {
        SyncedSettings = syncedSettings;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", IdentityProvider=" + IdentityProvider +
                ", Identifier=" + Identifier +
                ", CurrentSessionToken=" + CurrentSessionToken +
                ", Username='" + Username + '\'' +
                ", Profile=" + Profile +
                ", Location=" + Location +
                ", WebsiteURL=" + WebsiteURL +
                ", ReputationPoints=" + ReputationPoints +
                ", Permissions=" + Permissions +
                ", PermissionsRequested=" + PermissionsRequested +
                ", DateCreated=" + DateCreated +
                ", DateLastLogin=" + DateLastLogin +
                ", IsProfilePublic=" + IsProfilePublic +
                ", IsEmergencyChargingProvider=" + IsEmergencyChargingProvider +
                ", IsPublicChargingProvider=" + IsPublicChargingProvider +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", EmailAddress=" + EmailAddress +
                ", EmailHash=" + EmailHash +
                ", ProfileImageURL='" + ProfileImageURL + '\'' +
                ", IsCurrentSessionTokenValid=" + IsCurrentSessionTokenValid +
                ", APIKey=" + APIKey +
                ", SyncedSettings=" + SyncedSettings +
                '}';
    }
}
