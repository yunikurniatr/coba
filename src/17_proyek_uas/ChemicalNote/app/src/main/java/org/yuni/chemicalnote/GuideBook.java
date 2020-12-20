package org.yuni.chemicalnote;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import org.yuni.chemicalnote.R;

public class GuideBook extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_book);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Guide Book");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.menu));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideBook.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}