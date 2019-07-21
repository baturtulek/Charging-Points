package com.example.electircalchargestations.Main;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import com.example.electircalchargestations.Map.MapFragment;
import com.example.electircalchargestations.Options.OptionsFragment;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Discover.DiscoverFragment;
import com.example.electircalchargestations.ViewPagerAdapter;
import android.view.View;

public class  MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private final int DISCOVER_FRAGMENT = 0;
    private final int MAP_FRAGMENT      = 1;
    private final int OPTIONS_FRAGMENT  = 2;
    private final int MAIN_ACTIVITY_FRAGMENT_COUNT = 3;

    private MenuItem                prevMenuItem;
    private ViewPager               viewPager;
    private BottomNavigationView    bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            window.setStatusBarColor(Color.WHITE);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        viewPager               = findViewById(R.id.viewpager);
        bottomNavigationView    = findViewById(R.id.bottom_navigation);

        setUpViewPager();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case  R.id.navigation_discover  :
                viewPager.setCurrentItem(DISCOVER_FRAGMENT);
                break;
            case R.id.navigation_map        :
                viewPager.setCurrentItem(MAP_FRAGMENT);
                break;
            case R.id.navigation_options    :
                viewPager.setCurrentItem(OPTIONS_FRAGMENT);
                break;
        }
        return true;
    }

    private void setUpViewPager(){
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
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.setOffscreenPageLimit(MAIN_ACTIVITY_FRAGMENT_COUNT);
        viewPager.setAdapter(setUpPagerAdapter());
    }

    private ViewPagerAdapter setUpPagerAdapter() {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new DiscoverFragment());
        pagerAdapter.addFragment(new MapFragment());
        pagerAdapter.addFragment(new OptionsFragment());
        return pagerAdapter;
    }

}
