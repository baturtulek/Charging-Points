package com.example.electircalchargestations.Search;
import com.example.electircalchargestations.Model.Country;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CountryWrapper {

    @SerializedName("Countries")
    private List<Country> countryList = null;

    public List<Country> getCountryList() { return countryList; }

    public void setCountryList(List<Country> countryList) { this.countryList = countryList; }

    @Override
    public String toString() {
        return "CountryWrapper{" +
                "countryList=" + countryList.toString() +
                '}';
    }
}
