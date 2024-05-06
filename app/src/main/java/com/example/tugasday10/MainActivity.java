package com.example.tugasday10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup makananRadioGroup, minumanRadioGroup;
    private TextView jmlPorsiEditText;
    private Button pesanButton;

    private final int HARGA_NASI_GORENG = 10000;
    private final int HARGA_MIE_GORENG = 8000;
    private final int HARGA_MIE_REBUS = 8000;
    private final int HARGA_NASI_UDUK = 15000;

    private final int HARGA_TEH_ES = 5000;
    private final int HARGA_ES_JERUK = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makananRadioGroup = findViewById(R.id.radioGroup1);
        minumanRadioGroup = findViewById(R.id.radioGroup2);
        jmlPorsiEditText = findViewById(R.id.text);

        pesanButton = findViewById(R.id.btn);
        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }

    private void pesan() {
        RadioButton selectedMakananRadioButton = findViewById(makananRadioGroup.getCheckedRadioButtonId());
        RadioButton selectedMinumanRadioButton = findViewById(minumanRadioGroup.getCheckedRadioButtonId());

        if (selectedMakananRadioButton == null || selectedMinumanRadioButton == null) {
            Toast.makeText(this, "Pilih makanan dan minuman terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        String makanan = selectedMakananRadioButton.getText().toString();
        String minuman = selectedMinumanRadioButton.getText().toString();
        String jumlahPorsi = jmlPorsiEditText.getText().toString();

        if (jumlahPorsi.isEmpty()) {
            Toast.makeText(this, "Masukkan jumlah porsi terlebih dahulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        int jumlah = Integer.parseInt(jumlahPorsi);

        int hargaMakanan = getHargaMakanan(makanan);
        int hargaMinuman = getHargaMinuman(minuman);

        int totalHarga = (hargaMakanan + hargaMinuman) * jumlah;

        // Mengirim data ke activity hasil
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("makanan", makanan);
        intent.putExtra("minuman", minuman);
        intent.putExtra("jumlahPorsi", jumlahPorsi);
        intent.putExtra("totalHarga", totalHarga);
        startActivity(intent);
    }

    private int getHargaMakanan(String makanan) {
        switch (makanan) {
            case "Nasi Goreng":
                return HARGA_NASI_GORENG;
            case "Mie Goreng":
                return HARGA_MIE_GORENG;
            case "Mie Rebus":
                return HARGA_MIE_REBUS;
            case "Nasi Uduk":
                return HARGA_NASI_UDUK;
            default:
                return 0;
        }
    }

    private int getHargaMinuman(String minuman) {
        switch (minuman) {
            case "Teh Es":
                return HARGA_TEH_ES;
            case "Es Jeruk":
                return HARGA_ES_JERUK;
            default:
                return 0;
        }
    }
}