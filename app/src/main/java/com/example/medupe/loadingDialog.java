package com.example.medupe;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class loadingDialog {
    private final Activity activity;
    private AlertDialog dialog;
    public loadingDialog(Activity activity)
    {
        this.activity=activity;
    }
    void startLoadingDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();


    }
    void dismissDialog()
    {
        dialog.dismiss();
    }
}
