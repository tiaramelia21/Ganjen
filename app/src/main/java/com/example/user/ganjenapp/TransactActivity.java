package com.example.user.ganjenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransactActivity extends AppCompatActivity {
    private Button cariTebeng, beriTebeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transact);

        cariTebeng = (Button)findViewById(R.id.cariTebeng);
        beriTebeng = (Button)findViewById(R.id.beriTebeng);

        cariTebeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        beriTebeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BeriTebengActivity.class));
            }
        });
    }
}
