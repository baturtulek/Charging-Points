package com.example.electircalchargestations;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electircalchargestations.Main.MainActivity;

public class SplashScreen extends AppCompatActivity {

    private final int THREAD_SLEEP_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        if(isInternetWorking()){
            displaySplashScreen();
        }else{
            showAlertDialog(SplashScreen.this);
        }
    }

    private void displaySplashScreen() {
        Thread timerTread = new Thread() {
            public void run() {
                try {
                    sleep(THREAD_SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startMainActivity();
                }
            }
        };
        timerTread.start();
    }

    private boolean isInternetWorking() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getBaseContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showAlertDialog(Activity activity) {
        CustomDialog cdd = new CustomDialog(activity);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }

}
