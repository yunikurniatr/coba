package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailUnsur extends AppCompatActivity {

    TextView namaUnsur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_unsur);

        namaUnsur = findViewById(R.id.namaUnsur);

        String s=getIntent().getStringExtra("nmunsur");
        String unsurdescription=getIntent().getStringExtra("nmunsur");

        namaUnsur.setText(s + unsurdescription);

    }
}