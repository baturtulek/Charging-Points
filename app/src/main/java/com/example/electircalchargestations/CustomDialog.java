package com.example.electircalchargestations;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {

    private Activity activity;
    private Button   buttonOk;

    public CustomDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        buttonOk = findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                activity.finish();
                break;
            default:
                activity.finish();
                break;
        }
    }

}
