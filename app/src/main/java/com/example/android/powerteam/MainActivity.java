package com.example.android.powerteam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String url = "https://ig2.appsep.com/empower";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onBackPressed() {

        myAlert(MainActivity.this);
    }

    public void myAlert(Context mContext) {

        new AlertDialog.Builder(mContext)
                .setIcon(R.drawable.alert)
                .setMessage("Do you really want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("Cancel", (dialog, which) -> {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                })
                .show();
    }

    public void goBack(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}