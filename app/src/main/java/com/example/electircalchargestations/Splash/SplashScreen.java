package com.example.electircalchargestations.Splash;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.Handler;
import com.example.electircalchargestations.CustomDialog;
import com.example.electircalchargestations.Main.MainActivity;
import com.example.electircalchargestations.R;
import com.example.electircalchargestations.Utilities;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar  progressBar;
    private int          progressStatus                 = 0;
    private final int    PROGRESS_BAR_MAX               = 100;
    private final int    PROGRESS_BAR_INCREMENT         = 1;
    private final int    THREAD_SLEEP_SPLASH_SCREEN     = 3000;
    private final int    THREAD_SLEEP_PROGRESSBAR       = 20;
    private final String ERROR_HEADING                  = "Connection Error";
    private final String ERROR_MESSAGE                  = "You are not connected to Internet.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.spalshprogressBar);

        if(Utilities.checkInternetConnection(SplashScreen.this)){
            displaySplashScreen();
            displayProgressBar();
        }else{
            displayAlertDialog(SplashScreen.this);
        }
    }
    
    private void displayProgressBar(){
        Handler handler     = new Handler();

        if (progressStatus == PROGRESS_BAR_MAX) {
            progressStatus = 0;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < PROGRESS_BAR_MAX) {
                    progressStatus += PROGRESS_BAR_INCREMENT;
                    try {
                        Thread.sleep(THREAD_SLEEP_PROGRESSBAR);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                }
            }
        }).start();
    }

    private void displaySplashScreen() {
        Thread timerTread = new Thread() {
            public void run() {
                try {
                    sleep(THREAD_SLEEP_SPLASH_SCREEN);
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

    private void displayAlertDialog(Activity activity) {
        CustomDialog dialog = new CustomDialog(activity,ERROR_HEADING, ERROR_MESSAGE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
    }

}
