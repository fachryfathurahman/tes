package com.nyucisini.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText beratBadan, tinggiBadan;
    TextView hasil, hasilAngka;
    double berat = 0.0, tinggi = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beratBadan = findViewById(R.id.berat_badan);
        tinggiBadan = findViewById(R.id.tinggi_badan);
        hasil = findViewById(R.id.hasil);
        hasilAngka = findViewById(R.id.hasil_angka);

        beratBadan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    berat = Double.parseDouble(String.valueOf(charSequence));
                    hitung();
                } catch (Exception e) {
                    hasil.setText("");
                    hasilAngka.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tinggiBadan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    tinggi = Double.parseDouble(String.valueOf(charSequence));
                    hitung();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "tidak bisa", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void hitung() {
        double hasil1 = berat / (((tinggi)/100) * ((tinggi/100)));
        String hasil2;
        if (hasil1 >= 40) {
            hasil2 = "obesity 3";
            hasil.setTextColor(getResources().getColor(R.color.obesity3));
        } else if (hasil1 >= 35) {
            hasil2 = "obesity 2";
            hasil.setTextColor(getResources().getColor(R.color.obesity2));
        } else if (hasil1 > 30) {
            hasil2 = "obesity 1";
            hasil.setTextColor(getResources().getColor(R.color.obesity1));
        } else if (hasil1 >= 25) {
            hasil2 = "overweight";
            hasil.setTextColor(getResources().getColor(R.color.overweight));
        } else if (hasil1 >= 18.5) {
            hasil2 = "Normal weight";
            hasil.setTextColor(getResources().getColor(R.color.Normal));
        } else if (hasil1 >= 0) {
            hasil2 = "underweight";
            hasil.setTextColor(getResources().getColor(R.color.underweight));
        } else {
            hasil2 = "not define";
            hasil.setTextColor(getResources().getColor(R.color.not));
        }
        hasil.setText(hasil2);

        DecimalFormat format =new DecimalFormat("#.##");


        hasilAngka.setText(format.format(hasil1));
    }

}
