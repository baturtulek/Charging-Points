package com.example.electircalchargestations.Model;

public class Connection {

    private Integer ID;
    private Integer ConnectionTypeID;
    private ConnectionType ConnectionType;
    private Object Reference;
    private Integer StatusTypeID;
    private StatusType StatusType;
    private Integer LevelID;
    private Level Level;
    private Object Amps;
    private Object Voltage;
    private Double PowerKW;
    private Integer CurrentTypeID;
    private CurrentType CurrentType;
    private Integer Quantity;
    private String Comments;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        this.ID = iD;
    }

    public Integer getConnectionTypeID() {
        return ConnectionTypeID;
    }

    public void setConnectionTypeID(Integer connectionTypeID) {
        this.ConnectionTypeID = connectionTypeID;
    }

    public ConnectionType getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.ConnectionType = connectionType;
    }

    public Object getReference() {
        return Reference;
    }

    public void setReference(Object reference) {
        this.Reference = reference;
    }

    public Integer getStatusTypeID() {
        return StatusTypeID;
    }

    public void setStatusTypeID(Integer statusTypeID) {
        this.StatusTypeID = statusTypeID;
    }

    public StatusType getStatusType() {
        return StatusType;
    }

    public void setStatusType(StatusType statusType) {
        this.StatusType = statusType;
    }

    public Integer getLevelID() {
        return LevelID;
    }

    public void setLevelID(Integer levelID) {
        this.LevelID = levelID;
    }

    public Level getLevel() {
        return Level;
    }

    public void setLevel(Level level) {
        this.Level = level;
    }

    public Object getAmps() {
        return Amps;
    }

    public void setAmps(Object amps) {
        this.Amps = amps;
    }

    public Object getVoltage() {
        return Voltage;
    }

    public void setVoltage(Object voltage) {
        this.Voltage = voltage;
    }

    public Double getPowerKW() {
        return PowerKW;
    }

    public void setPowerKW(Double powerKW) {
        this.PowerKW = powerKW;
    }

    public Integer getCurrentTypeID() {
        return CurrentTypeID;
    }

    public void setCurrentTypeID(Integer currentTypeID) {
        this.CurrentTypeID = currentTypeID;
    }

    public CurrentType getCurrentType() {
        return CurrentType;
    }

    public void setCurrentType(CurrentType currentType) {
        this.CurrentType = currentType;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        this.Quantity = quantity;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "iD=" + ID +
                ", connectionTypeID=" + ConnectionTypeID +
                ", connectionType=" + ConnectionType.toString() +
                ", reference=" + Reference +
                ", statusTypeID=" + StatusTypeID +
                ", statusType=" + StatusType.toString() +
                ", levelID=" + LevelID +
                ", level=" + Level.toString() +
                ", amps=" + Amps +
                ", voltage=" + Voltage +
                ", powerKW=" + PowerKW +
                ", currentTypeID=" + CurrentTypeID +
                ", currentType=" + CurrentType.toString() +
                ", quantity=" + Quantity +
                ", comments=" + Comments +
                '}';
    }
}