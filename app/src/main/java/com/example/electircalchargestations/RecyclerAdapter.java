package com.example.electircalchargestations;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Country;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ChargeStation>  stationList;

    public RecyclerAdapter(Context mContext, ArrayList<ChargeStation> mArrayList) {
        this.mContext       = mContext;
        this.stationList    = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater  = LayoutInflater.from(parent.getContext());
        View itemView                   = mLayoutInflater.inflate(R.layout.recycler_item, parent, false);
        ViewHolder mViewHolder          = new ViewHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        ChargeStation station   = stationList.get(position);
        AddressInfo address     = station.getAddressInfo();
        String title            = address.getTitle();
        String address1         = address.getAddressLine1();

        holder.name.setText(title);
        holder.avg.setText("Address : " + address1);
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView    name;
        TextView    avg;

        public ViewHolder(View itemView) {
            super(itemView);
            name    = itemView.findViewById(R.id.tv);
            avg     = itemView.findViewById(R.id.tvAvg);
        }
    }
}
