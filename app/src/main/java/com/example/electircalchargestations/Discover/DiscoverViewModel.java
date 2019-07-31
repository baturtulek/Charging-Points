package com.example.electircalchargestations.Discover;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.example.electircalchargestations.APIResult;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.Repository;
import java.util.List;

public class DiscoverViewModel extends AndroidViewModel {

    private final Repository repository;

    public DiscoverViewModel(@NonNull Application application) {
        super(application);
        repository      = Repository.getInstance(application);
    }

    public LiveData<List<Country>> getCountryList() {
        MediatorLiveData<List<Country>> countryList = new MediatorLiveData<>();

        countryList.addSource(repository.getCountryList(), new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> response) {
                countryList.setValue(response);
            }
        });
        return countryList;
    }

    public LiveData<APIResult<ChargeStation>> getChargeStationList(String countryCode) {
        MediatorLiveData<APIResult<ChargeStation>> mApiResponse = new MediatorLiveData<>();

        mApiResponse.addSource(repository.getChargeStationListByCountry(countryCode), new Observer<APIResult<ChargeStation>>() {
            @Override
            public void onChanged(@Nullable APIResult<ChargeStation> apiResponse)            {
                mApiResponse.setValue(apiResponse);
            }
        });
        return mApiResponse;
    }

}
