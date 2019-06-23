package com.example.electircalchargestations.Search;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.remote.Repository;
import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    private Repository repository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public MediatorLiveData<List<Country>> getCountryList(){
        return repository.getCountryList();
    }

    public MutableLiveData<List<ChargeStation>> getChargeStationList(String countryCode){
        return repository.getChargeStationsByCountry(countryCode);
    }
}
