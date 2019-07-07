package com.example.electircalchargestations.remote;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.ConnectionType;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.Model.Level;
import com.example.electircalchargestations.RetrofitService;
import com.example.electircalchargestations.ReferenceDataRequestBeans;
import com.example.electircalchargestations.local.AppDatabase;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private AppDatabase       database;
    private static WebService webService;
    private static Repository repository;

    private Repository(Application application){
        webService  = RetrofitService.getRetrofitInstance().create(WebService.class);
        database    = AppDatabase.getInstance(application);
    }

    public synchronized static Repository getInstance(Application application){
        if (repository == null){
            repository = new Repository(application);
        }
        return repository;
    }

    public MediatorLiveData<List<Country>> getCountryList(){
        MediatorLiveData<List<Country>> mediatorList        = new MediatorLiveData<>();
        final LiveData<List<Country>>   countryListFromDb   = database.countryDao().getCountryList();

        mediatorList.addSource(countryListFromDb, new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                Log.d("dbList",countries.toString());
                if(countries == null || countries.isEmpty()){
                    getReferenceDataFromApi();
                }else{
                    mediatorList.removeSource(countryListFromDb);
                    mediatorList.setValue(countries);
                }
            }
        });
        return mediatorList;
    }


    private void getReferenceDataFromApi() {
        Call<ReferenceDataRequestBeans> call = webService.getReferenceData();

        call.enqueue(new Callback<ReferenceDataRequestBeans>(){
            @Override
            public void onResponse(Call<ReferenceDataRequestBeans> call, Response<ReferenceDataRequestBeans> response) {
                if(response.isSuccessful()){
                    Log.d("APICALL",response.body().getCountryList().toString());
                    insertReferenceData(
                            response.body().getCountryList(),
                            response.body().getChargerTypeList(),
                            response.body().getConnectionTypeList());
                }
            }
            @Override
            public void onFailure(Call<ReferenceDataRequestBeans> call, Throwable t) { }
        });
    }


    public MutableLiveData<List<ChargeStation>> getChargeStationListByCountry(String countryCode){

        MutableLiveData<List<ChargeStation>> stationData    = new MutableLiveData<>();
        Call<List<ChargeStation>> call                      = webService.getChargeStationListByCountry(countryCode, Constants.OUTPUT_FORMAT,Constants.MAX_RESULT);

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

    private void insertReferenceData(List<Country> countryList, List<Level> chargerTypeList, List<ConnectionType> connectionTypeList){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.countryDao().insertCountryList(countryList);
                database.chargerTypeDao().insertChargerTypeList(chargerTypeList);
                database.connectionTypeDao().insertConnectionTypeList(connectionTypeList);
                return null;
            }
        }.execute();
    }
}
