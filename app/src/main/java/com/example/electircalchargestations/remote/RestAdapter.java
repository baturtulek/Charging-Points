package com.example.electircalchargestations.remote;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.RetrofitClient;
import com.example.electircalchargestations.Search.CountryWrapper;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAdapter {

    private RestAPI restAPI;
    private List<Country> countryList = new ArrayList<>();

    public void getStation() {
        restAPI = RetrofitClient.getRetrofitInstance().create(RestAPI.class);
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
            public void onFailure(Call<List<ChargeStation>> call, Throwable t) {

            }
        });

    }

    public void getCountriesFromApi() {

        restAPI = RetrofitClient.getRetrofitInstance().create(RestAPI.class);
        Call<CountryWrapper> call = restAPI.getCountriesFromApi();

        call.enqueue(new Callback<CountryWrapper>() {
            @Override
            public void onResponse(Call<CountryWrapper> call, Response<CountryWrapper> response) {
                countryList.addAll(response.body().getCountryList());
                Log.d("countryListOnResponse",countryList.toString());
            }

            @Override
            public void onFailure(Call<CountryWrapper> call, Throwable t) {
                Log.d("adapterFailure",t.getMessage());
            }
        });
    }

    //ViewModel Calls
    public List<Country> getCountryList(){
        if(countryList.size() == 0 || countryList == null){
            getCountriesFromApi();
        }
        Log.d("countryListIngetter", countryList.toString());
        return countryList;
    }


}
