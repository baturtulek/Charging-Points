package com.example.electircalchargestations.Discover;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.RecyclerAdapter;
import com.example.electircalchargestations.SpinnerAdapter;
import com.example.electircalchargestations.StationDetail.StationDetailActivity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment implements RecyclerAdapter.OnStationListener {

    private DiscoverViewModel    viewModel;
    private ProgressBar          progressBar;
    private TextView             noDataTextView;
    private Spinner              sItems;
    private RecyclerView         mRecyclerView;
    private RecyclerAdapter      adapter;
    private LinearLayoutManager  layoutManager;
    private ArrayList<ChargeStation> stationsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_discover,null);

        viewModel       = ViewModelProviders.of(this).get(DiscoverViewModel.class);
        sItems          = view.findViewById(R.id.countrySpinner);
        progressBar     = view.findViewById(R.id.progressBar);
        noDataTextView  = view.findViewById(R.id.textView2);
        mRecyclerView   = view.findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        Observer<List<Country>> countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                fillSpinner(countries);
                progressBar.setVisibility(View.GONE);
            }
        };
        viewModel.getCountryList().observe(this, countryObserver);


        Observer<List<ChargeStation>> stationObserver = new Observer<List<ChargeStation>>() {
            @Override
            public void onChanged(@Nullable List<ChargeStation> stations) {
                stationsList = (ArrayList<ChargeStation>) stations;
                adapter = new RecyclerAdapter((ArrayList) stations, DiscoverFragment.this);
                mRecyclerView.setAdapter(adapter);

                if(stations.isEmpty()) {
                    noDataTextView.setVisibility(View.VISIBLE);
                }
                progressBar.setVisibility(View.GONE);
            }
        };


        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter = new RecyclerAdapter(new ArrayList<>(), DiscoverFragment.this);
                mRecyclerView.setAdapter(adapter);

                noDataTextView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                String selectedItem = sItems.getSelectedItem().toString();
                String countryCode  = selectedItem.substring(0, 2);
                viewModel.getChargeStationList(countryCode).observe(DiscoverFragment.this, stationObserver);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        return view;
    }

    private void fillSpinner(List<Country> countryList){
        ArrayList<String> spinnerArray =  new ArrayList<>();
        if(countryList != null) {
            for (Country c : countryList) {
                spinnerArray.add(c.getISOCode() + " - " + c.getTitle());
            }

            SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this.getContext(), R.layout.country_spinner_layout,  spinnerArray);
            sItems.setAdapter(spinnerAdapter);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent =  new Intent(this.getActivity(), StationDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(StationDetailActivity.KEY_DETAIL_ACTIVITY, new Gson().toJson(stationsList.get(position)));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
