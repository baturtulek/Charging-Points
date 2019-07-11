package com.example.electircalchargestations.Discover;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.remote.Repository;
import java.util.List;

public class DiscoverViewModel extends AndroidViewModel {

    private Repository repository;

    public DiscoverViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public MediatorLiveData<List<Country>> getCountryList(){
        return repository.getCountryList();
    }

    public MutableLiveData<List<ChargeStation>> getChargeStationList(String countryCode){
        return repository.getChargeStationListByCountry(countryCode);
    }
}
