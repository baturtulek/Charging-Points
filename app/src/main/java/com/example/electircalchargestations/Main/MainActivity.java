package com.example.electircalchargestations.Main;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import com.example.electircalchargestations.Map.MapFragment;
import com.example.electircalchargestations.Options.OptionsFragment;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Discover.DiscoverFragment;

public class  MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        loadFragment(new DiscoverFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case  R.id.navigation_discover:
                fragment = new DiscoverFragment();
                break;
            case R.id.navigation_map:
                fragment = new MapFragment();
                break;
            case R.id.navigation_options:
                fragment = new OptionsFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
