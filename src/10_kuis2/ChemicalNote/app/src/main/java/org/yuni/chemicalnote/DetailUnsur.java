package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.yuni.chemicalnote.model.DataUnsur;
import java.security.Key;
public class DetailUnsur extends AppCompatActivity {

    TextView nama_unsur, namauns;
    ImageView gbr_unsur;
    public static final String Key_TabelActivity="Key_TabelActivity";
    DataUnsur dataunsur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_unsur);

        nama_unsur = findViewById(R.id.nama_unsur);
        namauns = findViewById(R.id.namauns);
        gbr_unsur = findViewById(R.id.gbr_unsur);

        dataunsur=getIntent().getParcelableExtra(Key_TabelActivity);

        nama_unsur.setText(dataunsur.getNamaUnsur());
        namauns.setText(dataunsur.getNamaUnsur());
        gbr_unsur.setImageResource(dataunsur.getImage());
        initial();

    }

    private void initial() {

    }

    public void onClickBack(View view) {
        Intent intent = new Intent(DetailUnsur.this, MainActivity.class);
        startActivity(intent);
    }
}