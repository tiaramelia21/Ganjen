package com.example.user.ganjenapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarMobileActivity extends AppCompatActivity {
    private Button simpanMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_mobile);

        simpanMobil = (Button)findViewById(R.id.simpanMobil);

        simpanMobil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder mas = new android.app.AlertDialog.Builder(CarMobileActivity.this);
                mas.setMessage("Data Anda Sudah Disubmit.");
                mas.setNeutralButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
                mas.show();
            }
        });
    }
}
