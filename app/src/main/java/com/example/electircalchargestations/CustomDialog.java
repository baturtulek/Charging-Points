package com.example.electircalchargestations;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {

    private Activity    activity;
    private TextView    headingTv;
    private TextView    messageTv;
    private Button      buttonOk;
    private String      header;
    private String      message;

    public CustomDialog(Activity activity, String header, String message) {
        super(activity);
        this.activity   = activity;
        this.header     = header;
        this.message    = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        headingTv = findViewById(R.id.heading);
        messageTv = findViewById(R.id.message);
        buttonOk    = findViewById(R.id.button_ok);

        this.headingTv.setText(header);
        this.messageTv.setText(message);

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
