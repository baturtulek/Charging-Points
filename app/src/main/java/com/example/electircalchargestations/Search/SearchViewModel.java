package com.example.electircalchargestations.Search;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.remote.RestAdapter;
import java.util.List;

public class SearchViewModel extends AndroidViewModel {

    private RestAdapter adapter;
    private MutableLiveData<List<Country>> countryList = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
        adapter = new RestAdapter();
    }

    //Activity Call
    public MutableLiveData<List<Country>> getCountryList() {
        if(countryList.getValue().isEmpty() || countryList.getValue() == null){
            loadListFromAdapter();
        }
        //Log.d("CountryListInViewModel",countryList.getValue().toString());
        return countryList;
    }

    private void loadListFromAdapter() {
        Log.d("viewModelC",adapter.getCountryList().toString());
        countryList.setValue(adapter.getCountryList());
    }
}
