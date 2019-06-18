package com.example.electircalchargestations.remote;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.RetrofitClient;
import com.example.electircalchargestations.Search.CountryWrapper;
import com.example.electircalchargestations.Search.SearchViewModel;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static RestAPI      restAPI;
    private static Repository   repository;

    public Repository(){
        restAPI = RetrofitClient.getRetrofitInstance().create(RestAPI.class);
    }

    public static Repository getInstance(){
        if (repository == null){
            repository = new Repository();
        }
        return repository;
    }

    public MutableLiveData<List<Country>> getCountryListFromApi() {

        MutableLiveData<List<Country>> countryData  = new MutableLiveData<>();
        Call<CountryWrapper> call                   = restAPI.getCountriesFromApi();

        call.enqueue(new Callback<CountryWrapper>() {
            @Override
            public void onResponse(Call<CountryWrapper> call, Response<CountryWrapper> response) {
                if(response.isSuccessful()){
                    countryData.setValue(response.body().getCountryList());
                }
            }

            @Override
            public void onFailure(Call<CountryWrapper> call, Throwable t) {
                countryData.setValue(null);
            }
        });
        return countryData;
    }


    public MutableLiveData<List<ChargeStation>> getChargeStationsByCountry(String countryCode){

        MutableLiveData<List<ChargeStation>> stationData    = new MutableLiveData<>();
        Call<List<ChargeStation>> call                      = restAPI.getChargeStationListByCountry(countryCode);

        call.enqueue(new Callback<List<ChargeStation>>() {
            @Override
            public void onResponse(Call<List<ChargeStation>> call, Response<List<ChargeStation>> response) {
                if(response.isSuccessful()){
                    stationData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<ChargeStation>> call, Throwable t) { }
        });
        return stationData;
    }




    public void getStation() {

        Call<List<ChargeStation>> call = restAPI.getStations();

        call.enqueue(new Callback<List<ChargeStation>>() {
            @Override
            public void onResponse(Call<List<ChargeStation>> call, Response<List<ChargeStation>> response) {
                List<ChargeStation> stations = response.body();

                String stationInfo = "";
                for(ChargeStation station : stations){
                    stationInfo += station.toString();
                }
                Log.d("Stations",stationInfo);
            }
            @Override
            public void onFailure(Call<List<ChargeStation>> call, Throwable t) { }
        });
    }

}
