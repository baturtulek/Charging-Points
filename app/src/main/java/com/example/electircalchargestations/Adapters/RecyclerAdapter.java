package com.example.electircalchargestations.Adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Connection;
import com.example.electircalchargestations.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<ChargeStation>    stationList;
    private OnStationListener           mOnStationListener;

    public RecyclerAdapter(ArrayList<ChargeStation> mArrayList, OnStationListener onStationListener ) {
        this.stationList        = mArrayList;
        this.mOnStationListener = onStationListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater  = LayoutInflater.from(parent.getContext());
        View itemView                   = mLayoutInflater.inflate(R.layout.recycler_item_discover, parent, false);
        ViewHolder mViewHolder          = new ViewHolder(itemView, mOnStationListener );
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        if(!stationList.isEmpty()) {
            ChargeStation station = stationList.get(position);

            if(station.getAddressInfo() != null){
                AddressInfo addressInfo = station.getAddressInfo();

                if(addressInfo.getTitle() != null){
                    holder.addressTitle.setText(addressInfo.getTitle());
                }

                if(addressInfo.getAddressLine1() != null){
                    holder.address1.setText(addressInfo.getAddressLine1());
                }
                if(addressInfo.getAddressLine2() != null) {
                    holder.address1.append(addressInfo.getAddressLine2());
                }

                if(addressInfo.getCountry() != null) {
                    holder.address2.setText(addressInfo.getCountry().getTitle());
                }
                if(addressInfo.getTown() != null){
                    holder.address2.append(" / " + addressInfo.getTown());
                }
                if(addressInfo.getPostcode() != null) {
                    holder.address2.append(" - " + addressInfo.getPostcode());
                }
            }

            if (station.getConnections() != null && !station.getConnections().isEmpty()) {
                String connection                       = "";
                ArrayList<Connection> connectionList    = station.getConnections();

                for (short i = 0; i < connectionList.size(); i++) {
                    if(connectionList.get(i).getConnectionType() != null){
                        if(connectionList.get(i).getConnectionType().getTitle() != null){
                            connection += connectionList.get(i).getConnectionType().getTitle();
                        }
                    }
                    if (connectionList.get(i).getQuantity() != null) {
                        connection += "<b>  X" + connectionList.get(i).getQuantity() + "</b>";
                    }
                    if (i + 1 < connectionList.size()) {
                        connection += "<br>";
                    }
                }
                holder.connections.setText(Html.fromHtml(connection));
            }
        }

    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView addressTitle;
        TextView address1;
        TextView address2;
        TextView connections;

        OnStationListener onStationListener;

        public ViewHolder(View itemView, OnStationListener onStationListener) {
            super(itemView);
            addressTitle            = itemView.findViewById(R.id.addressTitle);
            address1                = itemView.findViewById(R.id.address1);
            address2                = itemView.findViewById(R.id.address2);
            connections             = itemView.findViewById(R.id.connections);

            this.onStationListener  = onStationListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onStationListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnStationListener {
        void onItemClick(int position);

    }

}
