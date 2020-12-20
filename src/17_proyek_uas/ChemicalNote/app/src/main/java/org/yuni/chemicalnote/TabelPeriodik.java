package org.yuni.chemicalnote;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import org.yuni.chemicalnote.adapter.UnsurapiAdapter;
import org.yuni.chemicalnote.api.ApiClient;
import org.yuni.chemicalnote.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import org.yuni.chemicalnote.adapter.UnsurapiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabelPeriodik extends AppCompatActivity implements UnsurapiAdapter.OnUnsClickListener {
    public static final String Key_TabelActivity = "Key_TabelActivity";
    Toolbar toolbar;
    public RecyclerView rv;
    private SearchView searchView;
    private UnsurapiAdapter unsurapiAdapter;
    private List<UnsurwApi> unsurwApiList;
    public RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabel_periodik);
        rv = findViewById(R.id.unsurList);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        unsurapiAdapter = new UnsurapiAdapter();
        unsurapiAdapter.setListener(this);
        rv.setAdapter(unsurapiAdapter);
        EditText search_bar = findViewById(R.id.search_bar);
        rv.setLayoutManager(layoutManager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setTitle("Tabel Periodik");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.menu));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabelPeriodik.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if (!isConnect()) {
            new AlertDialog.Builder(TabelPeriodik.this)
                    .setTitle("Tidak Ada Koneksi Internet")
                    .setMessage("Tidak Dapat Memuat Data, Silahkan Coba Lagi!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            TabelPeriodik.this.finish();
                        }
                    }).show();
        }

        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        unsurwApiList = new ArrayList<>();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<UnsurwApi>> call = apiService.getUnsur();

        call.enqueue(new Callback<List<UnsurwApi>>() {
            @Override
            public void onResponse(Call<List<UnsurwApi>> call, Response<List<UnsurwApi>> response) {
                unsurwApiList = response.body();
                Log.d("TAG", "Response = " + unsurwApiList);
                unsurapiAdapter.setUnsurList(getApplicationContext(), unsurwApiList);
            }

            @Override
            public void onFailure(Call<List<UnsurwApi>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Snackbar.make(findViewById(android.R.id.content), "Tidak Dapat Memuat Data, Pastikan Terhubung Internet, Silahkan Coba Lagi!", Snackbar.LENGTH_LONG)
                        .setAction("OK", null)
                        .setActionTextColor(Color.RED)
                        .show();
            }
        });
    }

    private void filter(String text){
        List<UnsurwApi> filteredList = new ArrayList<>();
        for (UnsurwApi item : unsurwApiList){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        unsurapiAdapter.filterList(filteredList);
    }

    @Override
    public void onClick(View view, int position) {
        UnsurwApi unsurwApi = unsurwApiList.get(position);
        Intent i = new Intent(TabelPeriodik.this, DetailInfo.class);
        i.putExtra(Key_TabelActivity, unsurwApi);
        startActivity(i);
    }

    public boolean isConnect() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
