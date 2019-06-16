package com.example.electircalchargestations.Search;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.remote.RestAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    SearchViewModel viewModel;
    Spinner sItems;

    List<String> spinnerArray =  new ArrayList<String>();
    List<String> cList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        sItems = findViewById(R.id.countrySpinner);


         Observer<List<Country>> dataObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {

                for(Country c : countries){
                    spinnerArray.add(c.getContinentCode());
                }

                Log.d("countryListInActivity", spinnerArray.toString());
            }
        };

        viewModel.getCountryList().observe(this, dataObserver);


    }

}
