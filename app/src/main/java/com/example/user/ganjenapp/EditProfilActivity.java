package com.example.user.ganjenapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfilActivity extends AppCompatActivity {
    private Button submitProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        submitProfil = (Button)findViewById(R.id.submitProfil);

        submitProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder mas = new android.app.AlertDialog.Builder(EditProfilActivity.this);
                mas.setMessage("Data Anda Sudah Disubmit. Silahkan Tunggu Notifikasi Jika Ada Yang Ingin Menebeng");
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
