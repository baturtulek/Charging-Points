package com.example.electircalchargestations.Model;
import java.io.Serializable;

public class User implements Serializable {

    private int ID;
    private String Username;
    private int ReputationPoints;
    private String ProfileImageURL;
    //private Object IdentityProvider;
    //private Object Identifier;
    //private Object CurrentSessionToken;
    //private Object Profile;
    //private Object Location;
    //private Object WebsiteURL;
    //private Object Permissions;
    //private Object PermissionsRequested;
    //private Object DateCreated;
    //private Object DateLastLogin;
    //private Object IsProfilePublic;
    //private Object IsEmergencyChargingProvider;
    //private Object IsPublicChargingProvider;
    //private Object Latitude;
    //private Object Longitude;
    //private Object EmailAddress;
    //private Object EmailHash;
    //private Object IsCurrentSessionTokenValid;
    //private Object APIKey;
    //private Object SyncedSettings;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getReputationPoints() {
        return ReputationPoints;
    }

    public void setReputationPoints(int reputationPoints) {
        ReputationPoints = reputationPoints;
    }

    public String getProfileImageURL() {
        return ProfileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        ProfileImageURL = profileImageURL;
    }

}
