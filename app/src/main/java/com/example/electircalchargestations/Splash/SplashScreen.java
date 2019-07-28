package com.example.electircalchargestations.Splash;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electircalchargestations.CustomDialog;
import com.example.electircalchargestations.Main.MainActivity;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Utilities;

public class SplashScreen extends AppCompatActivity {

    private final int THREAD_SLEEP_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        if(Utilities.checkInternetConnection(SplashScreen.this)){
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

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showAlertDialog(Activity activity) {
        CustomDialog dialog = new CustomDialog(activity,"Connection Error", "You are not connected to Internet.");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
    }

}
