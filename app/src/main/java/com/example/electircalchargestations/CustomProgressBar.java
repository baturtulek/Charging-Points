package com.example.electircalchargestations;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class CustomProgressBar extends Dialog {

    private static CustomProgressBar mCustomProgressbar;
    private static TextView          status;

    private CustomProgressBar(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_progressbar);
        status = findViewById(R.id.statusTv);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public static void showProgressBar(Context context, boolean cancelable) {
        showProgressBar(context, cancelable, null);
    }

    public static void showProgressBar(Context context, boolean cancelable, String message) {
        if (mCustomProgressbar != null && mCustomProgressbar.isShowing()) {
            mCustomProgressbar.cancel();
        }
        mCustomProgressbar = new CustomProgressBar(context);
        mCustomProgressbar.setCancelable(cancelable);
        status.setText(message);
        mCustomProgressbar.show();
    }

    public static void hideProgressBar() {
        if (mCustomProgressbar != null) {
            mCustomProgressbar.dismiss();
        }
    }

}
