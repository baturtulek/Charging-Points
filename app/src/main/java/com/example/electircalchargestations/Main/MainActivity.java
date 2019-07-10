package com.example.electircalchargestations.Main;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import com.example.electircalchargestations.Map.MapFragment;
import com.example.electircalchargestations.Options.OptionsFragment;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Discover.DiscoverFragment;

public class  MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private FragmentManager mFragmentManager = null;
    private Fragment  activeFragment      = null;
    private Fragment  discoverFragment    = new DiscoverFragment();
    private Fragment  mapFragment         = new MapFragment();
    private Fragment  optionsFragment     = new OptionsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        initializeFragments();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case  R.id.navigation_discover  :
                if (!(activeFragment instanceof DiscoverFragment)) {
                    changeFragment(discoverFragment);
                }
                break;
            case R.id.navigation_map        :
                if (!(activeFragment instanceof MapFragment)) {
                    changeFragment(mapFragment);
                }
                break;
            case R.id.navigation_options    :
                if (!(activeFragment instanceof OptionsFragment)) {
                    changeFragment(optionsFragment);
                }
                break;
        }
        return true;
    }

    private void initializeFragments(){
        if (mFragmentManager == null && activeFragment == null) {
            mFragmentManager    = getSupportFragmentManager();
            activeFragment      = discoverFragment;

            mFragmentManager.beginTransaction().add(R.id.fragment_container, discoverFragment, "1").commit();
            mFragmentManager.beginTransaction().add(R.id.fragment_container, mapFragment, "2").hide(mapFragment).commit();
            mFragmentManager.beginTransaction().add(R.id.fragment_container, optionsFragment, "3").hide(optionsFragment).commit();
        }
    }

    private void changeFragment(Fragment toShow) {
        mFragmentManager.beginTransaction().hide(activeFragment).show(toShow).commit();
        activeFragment = toShow;
    }
}
