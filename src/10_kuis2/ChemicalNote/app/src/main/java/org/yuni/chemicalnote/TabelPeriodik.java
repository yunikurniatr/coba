package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import org.yuni.chemicalnote.adapter.UnsurAdapter;
import org.yuni.chemicalnote.model.DataUnsur;

import java.util.ArrayList;
import java.util.List;

public class TabelPeriodik extends AppCompatActivity implements UnsurAdapter.OnUnsClickListener{

    public static final String Key_TabelActivity="Key_TabelActivity";

    public RecyclerView rv;
    public UnsurAdapter unsurAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<DataUnsur> dataUnsurList = new ArrayList<>();
    public EditText searchView;
    public CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_periodik);
        rv = findViewById(R.id.unsurList);
        dataUnsurList.add(new DataUnsur("Hydrogen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Helium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Lithium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Beryllium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Boron","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Carbon","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Nitrogen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Oxygen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        unsurAdapter = new UnsurAdapter(dataUnsurList);
        unsurAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(unsurAdapter);
        rv.setLayoutManager(layoutManager);
        initial();
    }

    private void initial() {

    }
    public void onClickBack(View view) {
        Intent intent = new Intent(TabelPeriodik.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view, int position) {
        DataUnsur dataunsur = dataUnsurList.get(position);
        Intent i = new Intent(TabelPeriodik.this,DetailUnsur.class);
        i.putExtra(Key_TabelActivity,dataunsur);
        startActivity(i);
    }
}