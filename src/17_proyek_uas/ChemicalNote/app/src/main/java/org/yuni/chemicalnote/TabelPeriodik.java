package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import org.yuni.chemicalnote.adapter.RecyclerviewAdapter;
import org.yuni.chemicalnote.model.DataUnsur;

import java.util.ArrayList;
import java.util.List;

public class TabelPeriodik extends AppCompatActivity {

    RecyclerView unsurRecycler;
    RecyclerviewAdapter recyclerviewAdapter;
    EditText searchView;
    CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_periodik);
        searchView = findViewById(R.id.search_bar);

        List<DataUnsur> dataUnsurList = new ArrayList<>();
        dataUnsurList.add(new DataUnsur("Hydrogen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Helium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Lithium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Beryllium","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Boron","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Carbon","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Nitrogen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));
        dataUnsurList.add(new DataUnsur("Oxygen","Hidrogen adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1.", R.drawable.hidro));



        setUnsurRecycler(dataUnsurList );


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                recyclerviewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private  void  setUnsurRecycler(List<DataUnsur> dataUnsurList){
        unsurRecycler = findViewById(R.id.unsurList);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        unsurRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(this, dataUnsurList);
        unsurRecycler.setAdapter(recyclerviewAdapter);
    }

}
