package com.example.electircalchargestations.StationDetail;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;

public class StationDetailActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    public  static final String     KEY_DETAIL_ACTIVITY = "com.example.chargingStations.DetailActivity";
    private static final String[]   pageTitles          = {"Details", "Comments", "Photos"};

    private TabLayout tabLayout;
    private ViewPager pager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);

        getSupportActionBar().setElevation(0f);

        pager       = findViewById(R.id.view_pager);
        tabLayout   = findViewById(R.id.tab_layout);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#007EE0"));

        setUpPager();
    }


    private void setUpPager(){
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.addOnTabSelectedListener(this);
    }

    private ChargeStation getChargeStationData(){
        String jsonChargeStation    = "";
        Intent intent               = getIntent();
        Bundle chargeStationData    = intent.getExtras();

        if (chargeStationData != null) {
            jsonChargeStation = chargeStationData.getString(KEY_DETAIL_ACTIVITY);
        }
        return new Gson().fromJson(jsonChargeStation, ChargeStation.class);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) { pager.setCurrentItem(tab.getPosition()); }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }

    @Override
    public void onTabReselected(TabLayout.Tab tab) { }



    public class CustomAdapter extends FragmentPagerAdapter{

        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Bundle bundle = new Bundle();
                    bundle.putString("params", new Gson().toJson(getChargeStationData()));
                    DetailFragment detailFragment = DetailFragment.getInstance(pageTitles[position]);
                    detailFragment.setArguments(bundle);
                    return detailFragment;
                case 1:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("params", new Gson().toJson(getChargeStationData()));
                    CommentsFragment commentsFragment = CommentsFragment.getInstance(pageTitles[position]);
                    commentsFragment.setArguments(bundle1);
                    return commentsFragment;
                case 2:
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("params", new Gson().toJson(getChargeStationData()));
                    PhotosFragment photosFragment = PhotosFragment.getInstance(pageTitles[position]);
                    photosFragment.setArguments(bundle2);
                    return photosFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return pageTitles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position];
        }
    }


}

