package org.aplas.recyclerviewrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.aplas.recyclerviewrecipe.DataResep;
import java.security.Key;

public class ResepActivity extends AppCompatActivity {
    TextView nama_unsur, namauns, desc;
    ImageView gbr_unsur;
    public static final String Key_TabelActivity = "Key_TabelActivity";
    DataResep dataunsur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);

        nama_unsur = findViewById(R.id.nama_unsur);
        namauns = findViewById(R.id.namauns);
        desc = findViewById(R.id.desc);
        gbr_unsur = findViewById(R.id.gbr_unsur);

        dataunsur = getIntent().getParcelableExtra(Key_TabelActivity);

        nama_unsur.setText(dataunsur.getNamaUnsur());
        namauns.setText(dataunsur.getNamaUnsur());
        gbr_unsur.setImageResource(dataunsur.getImage());
        desc.setText(dataunsur.getDescp());
        initial();

    }

    private void initial() {

    }

    public void onClickBack(View view) {
        Intent intent = new Intent(ResepActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
