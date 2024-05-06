package com.example.tugasday10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView makanTextView, minumanTextView, jmlTextView, totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        makanTextView = findViewById(R.id.makan);
        minumanTextView = findViewById(R.id.minum);
        jmlTextView = findViewById(R.id.jumlahporsi);
        totalTextView = findViewById(R.id.totalharga);

        // Mendapatkan data dari intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String makanan = extras.getString("makanan");
            String minuman = extras.getString("minuman");
            String jumlahPorsi = extras.getString("jumlahPorsi");
            int totalHarga = extras.getInt("totalHarga");

            // Menampilkan data pada TextView
            makanTextView.setText("Makanan : " + makanan);
            minumanTextView.setText("Minuman : " + minuman);
            jmlTextView.setText("Jumlah Porsi : " + jumlahPorsi);
            totalTextView.setText("Total : "+"Rp. " + totalHarga );
        }
    }
}