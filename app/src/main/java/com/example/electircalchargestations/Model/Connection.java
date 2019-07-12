package com.example.electircalchargestations.Model;

public class Connection {

    private Integer         ID;
    private Integer         ConnectionTypeID;
    private ConnectionType  ConnectionType;
    //private Object          Reference;        //Most of the time Null.
    private Integer         StatusTypeID;
    private StatusType      StatusType;
    private Integer         LevelID;
    private Level           Level;
    private String          Amps;
    private String          Voltage;
    private String          PowerKW;
    private Integer         CurrentTypeID;
    private CurrentType     CurrentType;
    private Integer         Quantity;
    private String          Comments;

    public Integer getID() { return ID; }

    public void setID(Integer ID) { this.ID = ID; }

    public Integer getConnectionTypeID() {
        return ConnectionTypeID;
    }

    public void setConnectionTypeID(Integer connectionTypeID) {
        ConnectionTypeID = connectionTypeID;
    }

    public com.example.electircalchargestations.Model.ConnectionType getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(com.example.electircalchargestations.Model.ConnectionType connectionType) {
        ConnectionType = connectionType;
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

    public Integer getLevelID() {
        return LevelID;
    }

    public void setLevelID(Integer levelID) {
        LevelID = levelID;
    }

    public com.example.electircalchargestations.Model.Level getLevel() {
        return Level;
    }

    public void setLevel(com.example.electircalchargestations.Model.Level level) {
        Level = level;
    }

    public String getAmps() {
        return Amps;
    }

    public void setAmps(String amps) {
        Amps = amps;
    }

    public String getVoltage() {
        return Voltage;
    }

    public void setVoltage(String voltage) {
        Voltage = voltage;
    }

    public String getPowerKW() {
        return PowerKW;
    }

    public void setPowerKW(String powerKW) {
        PowerKW = powerKW;
    }

    public Integer getCurrentTypeID() {
        return CurrentTypeID;
    }

    public void setCurrentTypeID(Integer currentTypeID) {
        CurrentTypeID = currentTypeID;
    }

    public com.example.electircalchargestations.Model.CurrentType getCurrentType() {
        return CurrentType;
    }

    public void setCurrentType(com.example.electircalchargestations.Model.CurrentType currentType) {
        CurrentType = currentType;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }


}