package com.example.electircalchargestations.Search;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.remote.Repository;
import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<List<Country>>          countryList;
    private MutableLiveData<List<ChargeStation>>    stationList;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository  = Repository.getInstance();
    }

    public MutableLiveData<List<Country>> getCountryList() {

        countryList = repository.getCountryListFromApi();
        return countryList;
    }


    public MutableLiveData<List<ChargeStation>> getChargeStationList(String countryCode){
        stationList = repository.getChargeStationsByCountry(countryCode);
        return stationList;
    }
}
