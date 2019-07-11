package com.example.electircalchargestations;
import com.example.electircalchargestations.Model.ConnectionType;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.Model.Level;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ReferenceDataRequestBeans {

    @SerializedName("Countries")
    private List<Country>           countryList         = null;
    @SerializedName("ChargerTypes")
    private List<Level>             chargerTypeList     = null;
    @SerializedName("ConnectionTypes")
    private List<ConnectionType>    connectionTypeList  = null;

    public List<Country> getCountryList() {
        return countryList;
    }

    public List<Level> getChargerTypeList() {
        return chargerTypeList;
    }

    public List<ConnectionType> getConnectionTypeList() {
        return connectionTypeList;
    }

    @Override
    public String toString() {
        return "ReferenceDataRequestBeans{" +
                "countryList=" + countryList.toString() +
                '}';
    }
}
