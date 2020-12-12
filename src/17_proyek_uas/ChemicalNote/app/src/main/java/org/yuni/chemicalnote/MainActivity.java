package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial() {

    }
    public void About(View view) {
        Intent intent = new Intent(MainActivity.this, AboutDataBindingActivity.class);
        startActivity(intent);
    }

    public void GuideBook(View view) {
        Intent intent = new Intent(MainActivity.this, GuideBook.class);
        startActivity(intent);
    }

    public void TabelPeriodik(View view) {
        Intent intent = new Intent(MainActivity.this, TabelPeriodik.class);
        startActivity(intent);
    }

    public void Dataview(View view) {
        Intent intent = new Intent(MainActivity.this, DaftarViewModel.class);
        startActivity(intent);
    }
}