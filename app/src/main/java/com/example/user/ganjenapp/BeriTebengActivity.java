package com.example.user.ganjenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BeriTebengActivity extends AppCompatActivity {
    private Button submitAlamat;
    private EditText lokasiAwal, lokasiTujuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beri_tebeng);

        submitAlamat = (Button)findViewById(R.id.submitAlamat);
        lokasiAwal = (EditText)findViewById(R.id.lokasiAwal);
        lokasiTujuan = (EditText)findViewById(R.id.lokasiTujuan);

        submitAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BeriTebeng2Activity.class));
            }
        });
    }
}
