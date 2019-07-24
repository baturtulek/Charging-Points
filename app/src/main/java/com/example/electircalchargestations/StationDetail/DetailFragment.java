package com.example.electircalchargestations.StationDetail;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Connection;
import com.example.electircalchargestations.Model.DataProvider;
import com.example.electircalchargestations.Model.StatusType;
import com.example.electircalchargestations.Model.UsageType;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;
import java.util.ArrayList;

public class DetailFragment extends Fragment {

    private TextView locationTitleTv;
    private TextView locationInfoTv;
    private TextView latitudeLongitudeTv;
    private TextView connectionsTv;
    private TextView operationalStatusTv;
    private TextView membershipTv;
    private TextView accessKeyTv;
    private TextView payAtLocationTv;
    private TextView usageTypeTv;
    private TextView dataProviderTitleTv;
    private TextView dataProviderUrlTv;
    private TextView licenseTv;

    private final String UNDEFINED_DATA = "<i>Undefined</i>";

    public static DetailFragment getInstance(String pageTitle) {
        Bundle args                     = new Bundle();
        DetailFragment detailFragment   = new DetailFragment();
        args.putString(Constants.PAGE_TITLE, pageTitle);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        locationTitleTv     = view.findViewById(R.id.locationTitle);
        locationInfoTv      = view.findViewById(R.id.locationInfo);
        latitudeLongitudeTv = view.findViewById(R.id.latlon);
        connectionsTv       = view.findViewById(R.id.connections);
        operationalStatusTv = view.findViewById(R.id.operationalStatus);
        membershipTv        = view.findViewById(R.id.memberShipReq);
        accessKeyTv         = view.findViewById(R.id.accessKeyReq);
        payAtLocationTv     = view.findViewById(R.id.payAtLocation);
        usageTypeTv         = view.findViewById(R.id.usageType);
        dataProviderTitleTv = view.findViewById(R.id.dataProviderTitleTv);
        dataProviderUrlTv   = view.findViewById(R.id.dataProviderUrlTv);
        licenseTv           = view.findViewById(R.id.licenseTv);

        fillData();
        return view;
    }

    private ChargeStation getChargeStationData() {
        ChargeStation station = null;
        if (getArguments() != null) {
            String jsonChargeStation = getArguments().getString("params");
            station = new Gson().fromJson(jsonChargeStation, ChargeStation.class);
        }
        return station;
    }

    private void fillData() {
        ChargeStation station = getChargeStationData();

        //Location
        if (station.getAddressInfo() != null) {
            AddressInfo addressInfo = station.getAddressInfo();

            if (addressInfo.getTitle() != null) {
                locationTitleTv.setText(addressInfo.getTitle());
            }
            if (addressInfo.getAddressLine1() != null) {
                locationInfoTv.setText(addressInfo.getAddressLine1());
            }
            if (addressInfo.getAddressLine2() != null) {
                locationInfoTv.append(" " + addressInfo.getAddressLine2());
            }
            if (addressInfo.getCountry() != null) {
                if(addressInfo.getAddressLine1() != null || addressInfo.getAddressLine2() != null){
                    locationInfoTv.append("\n");
                }
                locationInfoTv.append(addressInfo.getCountry().getTitle());
            }
            if (addressInfo.getTown() != null) {
                locationInfoTv.append(" / " + addressInfo.getTown());
            }
            if (addressInfo.getPostcode() != null) {
                locationInfoTv.append("  -  " + addressInfo.getPostcode());
            }
            if(addressInfo.getLatitude() != null){
                latitudeLongitudeTv.setText(addressInfo.getLatitude().toString());
            }
            if(addressInfo.getLongitude() != null){
                latitudeLongitudeTv.append("     " + addressInfo.getLongitude());
            }
        }

        //Connection
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
            connectionsTv.setText(Html.fromHtml(connection));
        }else{
            connectionsTv.setText(Html.fromHtml(UNDEFINED_DATA));
        }

        //Status Type
        if(station.getStatusType() != null){
            StatusType statusType = station.getStatusType();

            if (statusType.getTitle() != null) {
                operationalStatusTv.setText(statusType.getTitle());
            }else{
                operationalStatusTv.setText(Html.fromHtml(UNDEFINED_DATA));
            }
        }

        //Usage Type
        if(station.getUsageType() != null){
            UsageType usageType = station.getUsageType();

            if (usageType.getTitle() != null) {
                usageTypeTv.setText(usageType.getTitle());
            }else{
                usageTypeTv.setText(Html.fromHtml(UNDEFINED_DATA));
            }

            if (usageType.getMembershipRequired() != null) {
                membershipTv.setText(usageType.getMembershipRequired().toString());
            }else{
                membershipTv.setText(Html.fromHtml(UNDEFINED_DATA));
            }

            if (usageType.getAccessKeyRequired() != null) {
                accessKeyTv.setText(usageType.getAccessKeyRequired().toString());
            }else{
                accessKeyTv.setText(Html.fromHtml(UNDEFINED_DATA));
            }

            if (usageType.getPayAtLocation() != null) {
                payAtLocationTv.setText(usageType.getPayAtLocation().toString());
            }else{
                payAtLocationTv.setText(Html.fromHtml(UNDEFINED_DATA));
            }
        }

        //Data Provider
        if (station.getDataProvider() != null && station.getDataProvider().getTitle() != null) {
            DataProvider dataProvider = station.getDataProvider();
            if(dataProvider.getTitle() != null){
                dataProviderTitleTv.setText(dataProvider.getTitle());
            }
            if(dataProvider.getWebsiteURL() != null){
                dataProviderUrlTv.setText(dataProvider.getWebsiteURL());
            }
            if(dataProvider.getLicense() != null){
                licenseTv.setText(dataProvider.getLicense());
            }
        }
    }


}
