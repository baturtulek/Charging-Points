package com.example.electircalchargestations;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Connection;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<ChargeStation>  stationList;
    private OnStationListener mOnStationListener;

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

        AddressInfo addressInfo;
        String addressTitle             = "";
        String addressLine1             = "";
        String addressLine2             = "";
        String connections              = "";
        Boolean isOperational           = false;
        Boolean isMembershipRequired    = false;

        if(!stationList.isEmpty()) {
            ChargeStation station = stationList.get(position);

            if(station.getAddressInfo() != null){
                addressInfo = station.getAddressInfo();
                if(addressInfo.getTitle() != null){
                    addressTitle = addressInfo.getTitle();
                }
                if(addressInfo.getCountry() != null){
                    addressLine1 = addressInfo.getCountry().getTitle() + "  / ";
                    if(addressInfo.getTown() != null){
                        addressLine1 += addressInfo.getTown() + "  ";
                    }
                    if(addressInfo.getPostcode() != null) {
                        addressLine1 = addressInfo.getPostcode();
                    }
                    if(addressInfo.getAddressLine1() != null){
                        addressLine2 = addressInfo.getAddressLine1();
                    }
                    if(addressInfo.getAddressLine2() != null) {
                        addressLine2 += addressInfo.getAddressLine2();
                    }
                }
            }

            if(station.getStatusType() != null && station.getStatusType().getIsOperational() != null){
                isOperational = station.getStatusType().getIsOperational();
            }
            if(station.getUsageType() != null && station.getUsageType().getMembershipRequired() != null){
                isMembershipRequired = station.getUsageType().getMembershipRequired();
            }

            if(station.getConnections() != null && !station.getConnections().isEmpty()){
                ArrayList<Connection> connectionList = station.getConnections();

                for(short i = 0; i < connectionList.size(); i++){
                    connections += "      " + connectionList.get(i).getConnectionType().getTitle();
                    if(connectionList.get(i).getQuantity() != null){
                        connections += "  x" + connectionList.get(i).getQuantity();
                    }
                    if(i + 1 < connectionList.size()) { connections += "\n"; }
                }
            }

            holder.addressTitle.setText(addressTitle);
            holder.addressLine.setText("      " + addressLine1 + "\n      " + addressLine2);
            holder.connections.setText(connections);
            holder.isOperational.setChecked(isOperational);
            holder.isMemberShipRequired.setChecked(isMembershipRequired);
        }
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView addressTitle;
        TextView addressLine;
        TextView connections;
        CheckBox isOperational;
        CheckBox isMemberShipRequired;

        OnStationListener onStationListener;

        public ViewHolder(View itemView, OnStationListener onStationListener) {
            super(itemView);
            addressTitle            = itemView.findViewById(R.id.addressTitle);
            addressLine             = itemView.findViewById(R.id.address);
            connections             = itemView.findViewById(R.id.connections);
            isOperational           = itemView.findViewById(R.id.isOperationalTb);
            isMemberShipRequired    = itemView.findViewById(R.id.isMemberShipTb);

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
