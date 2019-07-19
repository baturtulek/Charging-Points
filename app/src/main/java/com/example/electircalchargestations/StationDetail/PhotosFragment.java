package com.example.electircalchargestations.StationDetail;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;

public class PhotosFragment extends Fragment {

    private ChargeStation           station;
    private RecyclerView            mRecyclerView;
    private RecyclerPhotosAdapter   adapter;
    private LinearLayoutManager     layoutManager;

    public static PhotosFragment getInstance(String pageTitle){
        PhotosFragment photosFragment = new PhotosFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        photosFragment.setArguments(args);
        return photosFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container,false);

        mRecyclerView   = view.findViewById(R.id.recyclerView_photos);
        layoutManager   = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        if (getArguments() != null) {
            String jsonChargeStation    = getArguments().getString("params");
            station                     = new Gson().fromJson(jsonChargeStation, ChargeStation.class);
        }

        adapter = new RecyclerPhotosAdapter(station.getMediaItems());
        mRecyclerView.setAdapter(adapter);
        return view;
    }
}
