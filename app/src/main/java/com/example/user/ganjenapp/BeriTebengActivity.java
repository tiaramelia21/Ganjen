package com.example.user.ganjenapp;

import android.content.Intent;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BeriTebengActivity extends AppCompatActivity{
    private Button submitAlamat;
    private Spinner spinnerLokAwal, spinnerLokTujuan;
    TextView teksAwal, teksAkhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beri_tebeng);

        submitAlamat = (Button)findViewById(R.id.submitAlamat);
        teksAwal = (TextView)findViewById(R.id.teksAwal);
        teksAkhir = (TextView)findViewById(R.id.teksAkhir);
        spinnerLokAwal = (Spinner)findViewById(R.id.spinnerLokAwal);
        spinnerLokTujuan = (Spinner)findViewById(R.id.spinnerLokTujuan);

        submitAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BeriTebeng2Activity.class));
            }
        });

        //spinner lokasi tujuan
        spinnerLokTujuan.setOnItemSelectedListener(new SpinnerTujuan());
        List<String> lokasiTujuan = new ArrayList<String>();
        lokasiTujuan.add("--Pilih Lokasi Tujuan");
        lokasiTujuan.add("Jl. Sisingamangaraja");
        lokasiTujuan.add("Jl. Sudirman");
        lokasiTujuan.add("Jl. MH. Thamrin");
        lokasiTujuan.add("Jl. Medan Merdeka Barat");
        lokasiTujuan.add("Jl. Gatot Subroto");
        ArrayAdapter<String> dataAdapterTujuan = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lokasiTujuan);
        dataAdapterTujuan.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerLokTujuan.setAdapter(dataAdapterTujuan);

        //Spinner lokasi Awal
        spinnerLokAwal.setOnItemSelectedListener(new SpinnerAwal());

        List<String> lokasiAwal = new ArrayList<String>();
        lokasiAwal.add("--Pilih Lokasi Awal--");
        lokasiAwal.add("Jakarta Timur");
        lokasiAwal.add("Jakarta Pusat");
        lokasiAwal.add("Jakarta Selatan");
        lokasiAwal.add("Jakarta Barat");
        lokasiAwal.add("Jakarta Utara");

        ArrayAdapter<String> dataAdapterAwal = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lokasiAwal);
        dataAdapterAwal.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerLokAwal.setAdapter(dataAdapterAwal);

    }

    private class SpinnerTujuan implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            String item = adapterView.getItemAtPosition(position).toString();
            Toast.makeText(adapterView.getContext(), "Selected : "+ item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }

    private class SpinnerAwal implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            String item = adapterView.getItemAtPosition(position).toString();
            Toast.makeText(adapterView.getContext(), "Selected : "+ item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }
}
