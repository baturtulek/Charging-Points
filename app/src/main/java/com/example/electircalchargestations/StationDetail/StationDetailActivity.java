package com.example.electircalchargestations.StationDetail;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.R;
import com.google.gson.Gson;

public class StationDetailActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private final   int DETAIL_FRAGMENT                = 0;
    private final   int COMMENT_FRAGMENT               = 1;
    private final   int PHOTO_FRAGMENT                 = 2;
    private final   int DETAIL_ACTIVITY_FRAGMENT_COUNT = 3;
    private static  final String[] pageTitles          = {"DETAILS", "COMMENTS", "PHOTOS"};
    public  static  final String   KEY_DETAIL_ACTIVITY = "com.example.chargingStations.DetailActivity";

    private ViewPager   pager;
    private TabLayout   tabLayout;
    private Toolbar     toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_detail);

        toolbar     = findViewById(R.id.detail_toolbar);
        pager       = findViewById(R.id.view_pager);
        tabLayout   = findViewById(R.id.tab_layout);
        setUpActivity();
        setUpPager();
    }

    private void setUpActivity(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorCreamWhite));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setUpPager(){
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(DETAIL_ACTIVITY_FRAGMENT_COUNT);
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
            Fragment fragment = null;
            switch (position){
                case DETAIL_FRAGMENT    :
                    fragment = createFragmentInstance(position);
                    break;
                case COMMENT_FRAGMENT   :
                    fragment = createFragmentInstance(position);
                    break;
                case PHOTO_FRAGMENT     :
                    fragment = createFragmentInstance(position);
                    break;
            }
            return fragment;
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

        private Fragment createFragmentInstance(int position){
            Fragment fragment   = null;
            Bundle bundle       = new Bundle();
            bundle.putString("params", new Gson().toJson(getChargeStationData()));
            switch (position){
                case DETAIL_FRAGMENT    :
                    fragment = DetailFragment.getInstance(pageTitles[position]);
                    fragment.setArguments(bundle);
                    break;
                case COMMENT_FRAGMENT   :
                    fragment = CommentFragment.getInstance(pageTitles[position]);
                    fragment.setArguments(bundle);
                    break;
                case PHOTO_FRAGMENT     :
                    fragment = PhotoFragment.getInstance(pageTitles[position]);
                    fragment.setArguments(bundle);
                    break;
            }
            return fragment;
        }
    }

}

