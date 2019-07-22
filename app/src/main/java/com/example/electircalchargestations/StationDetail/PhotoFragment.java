package com.example.electircalchargestations.StationDetail;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;

public class PhotoFragment extends Fragment {

    private RecyclerView            mRecyclerView;
    private LinearLayoutManager     layoutManager;
    private CardView                noPhotoFound;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container,false);

        mRecyclerView   = view.findViewById(R.id.recyclerView_photos);
        noPhotoFound    = view.findViewById(R.id.noPhotoFound_cv);
        layoutManager   = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        setUpAdapter();
        return view;
    }

    public static PhotoFragment getInstance(String pageTitle){
        PhotoFragment photoFragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        photoFragment.setArguments(args);
        return photoFragment;
    }

    private void setUpAdapter(){
        ChargeStation station = getChargeStationData();
        if(!station.getMediaItems().isEmpty()){
            RecyclerPhotosAdapter   adapter = new RecyclerPhotosAdapter(getChargeStationData().getMediaItems());
            mRecyclerView.setAdapter(adapter);
            noPhotoFound.setVisibility(View.GONE);
        }else{
            noPhotoFound.setVisibility(View.VISIBLE);
        }
    }

    private ChargeStation getChargeStationData(){
        ChargeStation station = null;
        if (getArguments() != null) {
            String jsonChargeStation    = getArguments().getString("params");
            station                     = new Gson().fromJson(jsonChargeStation, ChargeStation.class);
        }
        return station;
    }

}
