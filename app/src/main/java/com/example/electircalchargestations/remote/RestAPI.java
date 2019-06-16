package com.example.electircalchargestations.remote;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Search.CountryWrapper;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {

    @GET(Constants.END_POINT)
    Call<List<ChargeStation>> getStations();

    @GET(Constants.END_POINT_COUNTRY)
    Call<CountryWrapper> getCountriesFromApi();

}
