package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GuideBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_book);
        initial();
    }

    private void initial() {

    }
    public void onClickBack(View view) {
        Intent intent = new Intent(GuideBook.this, MainActivity.class);
        startActivity(intent);
    }
}