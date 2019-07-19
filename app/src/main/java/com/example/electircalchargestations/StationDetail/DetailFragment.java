package com.example.electircalchargestations.StationDetail;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Connection;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;
import java.util.ArrayList;

public class DetailFragment extends Fragment {

    private ChargeStation station;
    private TextView locationInfo;
    private TextView latitudeLongitude;
    private TextView connections;
    private TextView operationalStatus;
    private TextView dataProivderTitle;
    private TextView getDataProivderUrl;
    private TextView license;
    private TextView locationTitle;

    public static DetailFragment getInstance(String pageTitle){
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container,false);

        locationTitle       = view.findViewById(R.id.locationTitle);
        locationInfo        = view.findViewById(R.id.locationInfo);
        latitudeLongitude   = view.findViewById(R.id.latlon);
        connections         = view.findViewById(R.id.connections);
        operationalStatus   = view.findViewById(R.id.operationalstatus);
        dataProivderTitle   = view.findViewById(R.id.dataProviderTitle);
        getDataProivderUrl  = view.findViewById(R.id.dataProviderUrl);
        license             = view.findViewById(R.id.license);

        if (getArguments() != null) {
            String jsonChargeStation    = getArguments().getString("params");
            station                     = new Gson().fromJson(jsonChargeStation, ChargeStation.class);
        }

        fillData();
        return view;
    }

    private void fillData(){

        String address = "";
        String addressLine1 = "";
        String addressLine2 = "";
        String connection   = "";
        String isOperational  = "";
        String usageType  = "";
        String membershipReq =" - ";
        String payAtLocation = "";
        String accessKey = "";

        if(station.getAddressInfo() != null){
            AddressInfo addressInfo = station.getAddressInfo();
            if(addressInfo.getTitle() != null){
                //address = addressInfo.getTitle();
                locationTitle.setText(addressInfo.getTitle());

            }
            if(addressInfo.getCountry() != null){
                addressLine2 = addressInfo.getCountry().getTitle() + "  / ";
                if(addressInfo.getTown() != null){
                    addressLine2 += addressInfo.getTown() + "  ";
                }
                if(addressInfo.getPostcode() != null) {
                    addressLine2 = addressInfo.getPostcode();
                }
                if(addressInfo.getAddressLine1() != null){
                    addressLine1 = addressInfo.getAddressLine1() + " ";
                }
                if(addressInfo.getAddressLine2() != null) {
                    addressLine1 += addressInfo.getAddressLine2();
                }
            }
        }

        if(station.getConnections() != null && !station.getConnections().isEmpty()){
            ArrayList<Connection> connectionList = station.getConnections();

            for(short i = 0; i < connectionList.size(); i++){
                connection += "      " + connectionList.get(i).getConnectionType().getTitle();
                if(connectionList.get(i).getQuantity() != null){
                    connection += "  x" + connectionList.get(i).getQuantity();
                }
                if(i + 1 < connectionList.size()) { connection += "\n"; }
            }
        }

        if(station.getStatusType() != null && station.getStatusType().getIsOperational() != null){
            isOperational = station.getStatusType().getTitle();
        }

        if(station.getUsageType() != null && station.getUsageType().getTitle() != null){
            usageType = station.getUsageType().getTitle();
        }

        if(station.getUsageType() != null && station.getUsageType().getMembershipRequired() != null){
            membershipReq = station.getUsageType().getMembershipRequired().toString();
        }

        if(station.getUsageType() != null && station.getUsageType().getPayAtLocation() != null){
            payAtLocation = station.getUsageType().getPayAtLocation().toString();
        }

        if(station.getUsageType() != null && station.getUsageType().getAccessKeyRequired() != null) {
            accessKey = station.getUsageType().getAccessKeyRequired().toString();
        }

        if(station.getDataProvider() != null && station.getDataProvider().getTitle() != null){
            dataProivderTitle.setText("     " + station.getDataProvider().getTitle());
        }

        if(station.getDataProvider() != null && station.getDataProvider().getWebsiteURL() != null){
            getDataProivderUrl.setText("     " + station.getDataProvider().getWebsiteURL());
        }

        if(station.getDataProvider() != null && station.getDataProvider().getLicense() != null){
            license.setText("     " + station.getDataProvider().getLicense());
        }

        locationInfo.setText("      " + addressLine1 + "\n      " + addressLine2);
        latitudeLongitude.setText("Latitude : " + station.getAddressInfo().getLatitude()
                + "\nLongitude : " + station.getAddressInfo().getLongitude());
        connections.setText(connection);
        operationalStatus.setText(
                "   Operational Status : "  + isOperational
                        + "\n   Usage Type : "          + usageType
                        + "\n   Membership Required : " + membershipReq
                        + "\n   Pay At Location : "     + payAtLocation
                        + "\n   Access Key Required : " + accessKey);
    }

}
