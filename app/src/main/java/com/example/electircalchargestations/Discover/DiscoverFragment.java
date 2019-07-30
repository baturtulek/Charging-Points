package com.example.electircalchargestations.Discover;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.electircalchargestations.APIResult;
import com.example.electircalchargestations.CustomProgressBar;
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

    private DiscoverViewModel       viewModel;
    private Spinner                 sItems;
    private RecyclerView            mRecyclerView;
    private RecyclerAdapter         adapter;
    private LinearLayoutManager     layoutManager;
    private CardView                errorCardView;
    private ArrayList<ChargeStation>stationsList;
    private TextView                errorMessage;

    private final String FAILED         = "Something went wrong!";
    private final String UNABLE_TO_FIND = "Unable to find any Stations!";
    private final String LOAD_COUNTRIES = "Loading Countries...";
    private final String LOAD_STATIONS  = "Loading Stations...";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_discover,null);

        viewModel       = ViewModelProviders.of(this).get(DiscoverViewModel.class);
        sItems          = view.findViewById(R.id.countrySpinner);
        errorCardView   = view.findViewById(R.id.noStationFound);
        mRecyclerView   = view.findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(getActivity());
        errorMessage    = view.findViewById(R.id.error_tv);
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        CustomProgressBar.showProgressBar(getActivity(),false,LOAD_COUNTRIES);
        countryObserver();
        stationObserver();
        return view;
    }

    private void countryObserver(){
        Observer<List<Country>> countryObserver = new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable final List<Country> countries) {
                fillSpinner(countries);
                CustomProgressBar.hideProgressBar();
            }
        };
        viewModel.getCountryList().observe(this, countryObserver);
    }

    private void stationObserver(){
        Observer<APIResult<ChargeStation>> stationObserver = new Observer<APIResult<ChargeStation>>() {
            @Override
            public void onChanged(@Nullable APIResult<ChargeStation> stationDataWrapper) {
                if(!stationDataWrapper.HasError()){
                    stationsList = (ArrayList<ChargeStation>) stationDataWrapper.getListResult();
                    if(!stationsList.isEmpty()) {
                        adapter = new RecyclerAdapter(stationsList, DiscoverFragment.this);
                        mRecyclerView.setAdapter(adapter);
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }else{
                        mRecyclerView.setVisibility(View.GONE);
                        errorMessage.setText(UNABLE_TO_FIND);
                        errorCardView.setVisibility(View.VISIBLE);
                    }
                }else{
                    Log.d("onFailure", stationDataWrapper.getThrowable().getMessage());
                    mRecyclerView.setVisibility(View.GONE);
                    errorMessage.setText(FAILED);
                    errorCardView.setVisibility(View.VISIBLE);
                }
                CustomProgressBar.hideProgressBar();
            }
        };

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mRecyclerView.setVisibility(View.GONE);
                errorCardView.setVisibility(View.GONE);
                String selectedItem = sItems.getSelectedItem().toString();
                String countryCode  = selectedItem.substring(0, 2);

                CustomProgressBar.showProgressBar(getActivity(), false, LOAD_STATIONS);
                viewModel.getChargeStationList(countryCode).observe(DiscoverFragment.this, stationObserver);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void fillSpinner(List<Country> countryList){
        ArrayList<String> spinnerArray =  new ArrayList<>();
        if(countryList != null) {
            for (Country c : countryList) {
                spinnerArray.add(c.getISOCode() + " - " + c.getTitle());
            }

            SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this.getContext(), R.layout.spinner_country_layout,  spinnerArray);
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
