package com.example.electircalchargestations.Discover;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.RecyclerAdapter;
import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private DiscoverViewModel viewModel;
    private ProgressBar                 progressBar;
    private TextView                    noDataTextView;
    private Spinner                     sItems;
    private RecyclerView                mRecyclerView;
    private RecyclerAdapter             adapter;
    private RecyclerView.LayoutManager  layoutManager;

    ArrayList<String> spinnerArray =  new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_discover,null);

        //getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                //WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewModel       = ViewModelProviders.of(this).get(DiscoverViewModel.class);
        sItems          = view.findViewById(R.id.countrySpinner);
        progressBar     = view.findViewById(R.id.progressBar);
        noDataTextView  = view.findViewById(R.id.textView2);
        mRecyclerView   = view.findViewById(R.id.recyclerView);

        layoutManager   = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);


        Observer<List<Country>> countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                fillSpinner(countries);
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        viewModel.getCountryList().observe(this, countryObserver);


        Observer<List<ChargeStation>> stationObserver = new Observer<List<ChargeStation>>() {
            @Override
            public void onChanged(@Nullable List<ChargeStation> stations) {
                adapter = new RecyclerAdapter(getContext(), (ArrayList) stations);
                mRecyclerView.setAdapter(adapter);
                if(stations.isEmpty()) {
                    noDataTextView.setVisibility(View.VISIBLE);
                }
                progressBar.setVisibility(View.INVISIBLE);
            }
        };

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noDataTextView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                String selectedItem = sItems.getSelectedItem().toString();
                String countryCode = selectedItem.substring(0, 2);
                viewModel.getChargeStationList(countryCode).observe(DiscoverFragment.this, stationObserver);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        return view;
    }

    private void fillSpinner(List<Country> countryList){
        if(countryList != null) {
            for (Country c : countryList) {
                spinnerArray.add(c.getISOCode() + " - " + c.getTitle());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sItems.setAdapter(adapter);
        }
    }
}
