package com.example.electircalchargestations.remote;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Search.CountryWrapper;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestAPI {

    @GET(Constants.END_POINT)
    Call<List<ChargeStation>> getStations();

    @GET(Constants.END_POINT_COUNTRY)
    Call<CountryWrapper> getCountriesFromApi();

    @GET("/v3/poi/?output=json&maxresults=3")
    Call<List<ChargeStation>> getChargeStationListByCountry(@Query("countrycode") String countryCode);
}
