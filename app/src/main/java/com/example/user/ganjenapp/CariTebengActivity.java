package com.example.user.ganjenapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CariTebengActivity extends AppCompatActivity {

    private Spinner spinnerJmlKursi, lokAwalCari, lokTujuanCari;

    EditText date;
    EditText time;
    DatePickerDialog datePickerDialog;
    private Button submitCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_tebeng);

        spinnerJmlKursi = (Spinner) findViewById(R.id.spinnerJmlKursi);
        spinnerJmlKursi.setOnItemSelectedListener(new ItemSelectedListener());

        submitCari = (Button)findViewById(R.id.submitCari);

        submitCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder mas = new android.app.AlertDialog.Builder(CariTebengActivity.this);
                mas.setMessage("Data Anda Sudah Disubmit. Silahkan Tunggu Notifikasi Jika Ada Yang Sesuai");
                mas.setNeutralButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
                mas.show();
            }
        });

        lokAwalCari = (Spinner)findViewById(R.id.lokAwalCari);
        lokTujuanCari = (Spinner)findViewById(R.id.lokTujuanCari);


        //spinner lokasi tujuan
        lokTujuanCari.setOnItemSelectedListener(new SpinnerTujuan());
        List<String> lokasiTujuan = new ArrayList<String>();
        lokasiTujuan.add("--Pilih Lokasi Tujuan");
        lokasiTujuan.add("Jl. Sisingamangaraja");
        lokasiTujuan.add("Jl. Sudirman");
        lokasiTujuan.add("Jl. MH. Thamrin");
        lokasiTujuan.add("Jl. Medan Merdeka Barat");
        lokasiTujuan.add("Jl. Gatot Subroto");
        ArrayAdapter<String> dataAdapterTujuan = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lokasiTujuan);
        dataAdapterTujuan.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        lokTujuanCari.setAdapter(dataAdapterTujuan);

        //Spinner lokasi Awal
        lokTujuanCari.setOnItemSelectedListener(new SpinnerAwal());

        List<String> lokasiAwal = new ArrayList<String>();
        lokasiAwal.add("--Pilih Lokasi Awal--");
        lokasiAwal.add("Jakarta Timur");
        lokasiAwal.add("Jakarta Pusat");
        lokasiAwal.add("Jakarta Selatan");
        lokasiAwal.add("Jakarta Barat");
        lokasiAwal.add("Jakarta Utara");

        ArrayAdapter<String> dataAdapterAwal = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lokasiAwal);
        dataAdapterAwal.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        lokAwalCari.setAdapter(dataAdapterAwal);
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinnerJmlKursi.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinnerJmlKursi.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "Jumlah Kursi : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                // Todo when item is selected by the user
            }

            date = (EditText)findViewById(R.id.date);
            // perform click event on edit text
            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // calender class's instance and get current date , month and year from calender
                    final Calendar c = Calendar.getInstance();
                    int mYear = c.get(Calendar.YEAR); // current year
                    int mMonth = c.get(Calendar.MONTH); // current month
                    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(CariTebengActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    // set day of month , month and year value in the edit text
                                    date.setText(dayOfMonth + "/"
                                            + (monthOfYear + 1) + "/" + year);
                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            });

            time = (EditText)findViewById(R.id.time);
            time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(CariTebengActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            time.setText( selectedHour + ":" + selectedMinute);
                        }
                    }, hour, minute, true);//Yes 24 hour time
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                }
            });

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

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
