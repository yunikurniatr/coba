package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import org.yuni.chemicalnote.databinding.ActivityAboutDataBindingBinding;
import org.yuni.chemicalnote.model.DataSaya;

public class AboutDataBindingActivity extends AppCompatActivity {
    Toolbar toolbar;
    // private TextView namasy, nimsy, matkulsy, githubsy;

    private ActivityAboutDataBindingBinding activityAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_data_binding);

        activityAbout = DataBindingUtil.setContentView(this, R.layout.activity_about_data_binding);
        activityAbout.setDatasaya(getCurrentData());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("About");
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutDataBindingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private DataSaya getCurrentData() {
        DataSaya datasaya = new DataSaya();
        datasaya.setNamaSaya("Yuni Kurnia Taramita");
        datasaya.setNimSaya("1941723002");
        datasaya.setMatkulSy("Pemrograman Mobile");
        datasaya.setAkunGithub("github.com/yunikurniatr");
        return datasaya;
    }

    public void insta(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://instagram.com/yunikurniatr/"));
        startActivity(intent);
    }

    public void github(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://github.com/yunikurniatr/"));
        startActivity(intent);
    }
}
