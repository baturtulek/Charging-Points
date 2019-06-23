package com.example.electircalchargestations.Search;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.RecyclerAdapter;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    SearchViewModel             viewModel;
    Spinner                     sItems;
    RecyclerView                mRecyclerView;
    RecyclerAdapter             adapter;
    RecyclerView.LayoutManager  layoutManager;

    ArrayList<String> spinnerArray =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewModel       = ViewModelProviders.of(this).get(SearchViewModel.class);
        sItems          = findViewById(R.id.countrySpinner);

        mRecyclerView   = findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        Observer<List<Country>> countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                fillSpinner(countries);

            }
        };
        viewModel.getCountryList().observe(this, countryObserver);



        Observer<List<ChargeStation>> stationObserver = new Observer<List<ChargeStation>>() {
            @Override
            public void onChanged(@Nullable List<ChargeStation> stations) {
                adapter = new RecyclerAdapter(SearchActivity.this, (ArrayList)stations);
                mRecyclerView.setAdapter(adapter);
            }
        };


        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = sItems.getSelectedItem().toString();
                String countryCode = selectedItem.substring(0, 2);
                viewModel.getChargeStationList(countryCode).observe(SearchActivity.this, stationObserver);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

    }

    public void fillSpinner(List<Country> countryList){
        if(countryList != null) {
            for (Country c : countryList) {
                spinnerArray.add(c.getISOCode() + " - " + c.getTitle());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItems.setAdapter(adapter);
        }
    }
}
