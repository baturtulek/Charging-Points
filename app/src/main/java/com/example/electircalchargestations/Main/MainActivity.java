package com.example.electircalchargestations.Main;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import com.example.electircalchargestations.Map.MapFragment;
import com.example.electircalchargestations.Options.OptionsFragment;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Discover.DiscoverFragment;
import com.example.electircalchargestations.ViewPagerAdapter;

public class  MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Fragment    discoverFragment,
                        mapFragment,
                        optionsFragment;
    private ViewPager   viewPager;
    private MenuItem    prevMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); //hide the title bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //      WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case  R.id.navigation_discover  :
                viewPager.setCurrentItem(0);
                break;
            case R.id.navigation_map        :
                viewPager.setCurrentItem(1);
                break;
            case R.id.navigation_options    :
                viewPager.setCurrentItem(2);
                break;
        }
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter    = new ViewPagerAdapter(getSupportFragmentManager());
        discoverFragment            = new DiscoverFragment();
        mapFragment                 = new MapFragment();
        optionsFragment             = new OptionsFragment();
        adapter.addFragment(discoverFragment);
        adapter.addFragment(mapFragment);
        adapter.addFragment(optionsFragment);
        viewPager.setAdapter(adapter);
    }

}
