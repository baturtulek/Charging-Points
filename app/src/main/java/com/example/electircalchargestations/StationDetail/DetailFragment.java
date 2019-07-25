package com.example.electircalchargestations.StationDetail;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Main.MainActivity;
import com.example.electircalchargestations.Map.MapFragment;
import com.example.electircalchargestations.Model.AddressInfo;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.Model.Connection;
import com.example.electircalchargestations.Model.DataProvider;
import com.example.electircalchargestations.Model.UsageType;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;
import java.util.ArrayList;

public class DetailFragment extends Fragment {

    private ChargeStation station;
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
    private CheckBox membershipCb;
    private CheckBox accessKeyCb;
    private CheckBox payAtLocationCb;
    private TextView telNo1;
    private TextView mailAddress;
    private TextView usageCost;
    private FloatingActionButton actionButton;

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
        membershipCb        = view.findViewById(R.id.membershipCb);
        accessKeyCb         = view.findViewById(R.id.accessKeyCb);
        payAtLocationCb     = view.findViewById(R.id.payAtLocationCb);
        telNo1              = view.findViewById(R.id.telNo1);
        mailAddress         = view.findViewById(R.id.mailAddress);
        usageCost           = view.findViewById(R.id.usageCost);
        actionButton        = view.findViewById(R.id.floatingActionButton);

        station = getChargeStationData();

        fillData();

        actionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String addressInfo = "";
                if(station.getAddressInfo().getAddressLine1() != null){
                    addressInfo += station.getAddressInfo().getAddressLine1();
                }
                if(station.getAddressInfo().getAddressLine2() != null){
                    addressInfo += " " +station.getAddressInfo().getAddressLine2();
                }

                getActivity().onBackPressed();
                MainActivity.loadMapFragment();
                MapFragment.LoadPosition(station.getAddressInfo().getLatitude(),
                        station.getAddressInfo().getLatitude(),
                        station.getAddressInfo().getTitle(),
                        addressInfo);
            }
        });

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
                latitudeLongitudeTv.append("   " + addressInfo.getLongitude());
            }

            if(addressInfo.getContactTelephone1() != null && !addressInfo.getContactTelephone1().isEmpty()){
                telNo1.setText(addressInfo.getContactTelephone1());
            }
            if(addressInfo.getContactEmail() != null && !addressInfo.getContactEmail().isEmpty()){
                mailAddress.setText(addressInfo.getContactEmail());
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
        }

        //Status Type
        if(station.getStatusType() != null && station.getStatusType().getTitle() != null){
            operationalStatusTv.setText(station.getStatusType().getTitle());
        }

        //Usage Type
        if(station.getUsageType() != null){
            UsageType usageType = station.getUsageType();

            if (usageType.getTitle() != null) {
                usageTypeTv.setText(usageType.getTitle());
            }

            if (usageType.getMembershipRequired() != null) {
                membershipCb.setChecked(usageType.getMembershipRequired());
                if(usageType.getMembershipRequired()){
                    membershipCb.setText("Required");
                }else{
                    membershipCb.setText("Not Required");
                }
                membershipTv.setVisibility(View.GONE);
            }else{
                membershipCb.setVisibility(View.GONE);
            }


            if (usageType.getAccessKeyRequired() != null) {
                accessKeyCb.setChecked(usageType.getAccessKeyRequired());
                if(usageType.getAccessKeyRequired()){
                    accessKeyCb.setText("Required");
                }else{
                    accessKeyCb.setText("Not Required");
                }
                accessKeyTv.setVisibility(View.GONE);
            }else{
                accessKeyCb.setVisibility(View.GONE);
            }

            if (usageType.getPayAtLocation() != null) {
                payAtLocationCb.setChecked(usageType.getPayAtLocation());
                if(usageType.getPayAtLocation()){
                    payAtLocationCb.setText("Available");
                }else{
                    payAtLocationCb.setText("Not Available");
                }
                payAtLocationTv.setVisibility(View.GONE);
            }else{
                payAtLocationCb.setVisibility(View.GONE);
            }
        }else{
            membershipCb.setVisibility(View.GONE);
            accessKeyCb.setVisibility(View.GONE);
            payAtLocationCb.setVisibility(View.GONE);
        }

        if(station.getUsageCost() != null){
            usageCost.setText(station.getUsageCost());
        }

        //Data Provider
        if (station.getDataProvider() != null) {
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
