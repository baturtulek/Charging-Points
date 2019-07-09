package com.example.electircalchargestations.Map;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.electircalchargestations.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    GoogleMap gMap;
    MapView mapview;
    private FusedLocationProviderClient fusedLocationClient;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, null);

        mapview = view.findViewById(R.id.mapView);
        if(mapview !=null){
            mapview.onCreate(null);
            mapview.onResume();
            mapview.getMapAsync(this);
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.getActivity());

        return view;
        }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());

        gMap = googleMap;
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        fetchUserLocation();


    }

    private void fetchUserLocation(){
        if (ContextCompat.checkSelfPermission(this.getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
               new AlertDialog.Builder(this.getActivity())
                       .setTitle("Required Location")
                       .setMessage("You should give permission")
                       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               ActivityCompat.requestPermissions(getActivity(),
                                       new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                       MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                           }
                       })
                       .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                           }
                       })
                       .create()
                       .show();
            } else {
                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this.getActivity(), new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitudeA= location.getLatitude();
                                double langitudeA = location.getLatitude();

                                Log.d("Location",location.toString());
                                Log.d("UserLocation",latitudeA + " " + langitudeA);

                                gMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude())).title("Sttaus").snippet("bla bla"));
                                CameraPosition userLocation = CameraPosition.builder().target(new LatLng(location.getLatitude(),location.getLongitude())).zoom(16).bearing(0).tilt(45).build();
                                gMap.moveCamera(CameraUpdateFactory.newCameraPosition(userLocation));

                            }
                        }
                    });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_PERMISSIONS_REQUEST_READ_CONTACTS) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }else{

            }
        }
    }
}
