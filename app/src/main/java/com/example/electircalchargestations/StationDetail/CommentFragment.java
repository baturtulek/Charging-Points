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

public class CommentFragment extends Fragment {

    private RecyclerView            mRecyclerView;
    private LinearLayoutManager     layoutManager;
    private CardView                noCommentFound;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container,false);

        mRecyclerView   = view.findViewById(R.id.recyclerView_comments);
        noCommentFound  = view.findViewById(R.id.noCommentsFound_cv);
        layoutManager   = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        setUpAdapter();

        return view;
    }

    public static CommentFragment getInstance(String pageTitle){
        CommentFragment commentFragment = new CommentFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        commentFragment.setArguments(args);
        return commentFragment;
    }

    private void setUpAdapter(){
        ChargeStation station = getChargeStationData();
        if(!station.getUserComments().isEmpty()){
            RecyclerCommentsAdapter adapter = new RecyclerCommentsAdapter(getChargeStationData().getUserComments());
            mRecyclerView.setAdapter(adapter);
            noCommentFound.setVisibility(View.GONE);
        }else{
            noCommentFound.setVisibility(View.VISIBLE);
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
