package org.yuni.chemicalnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.yuni.chemicalnote.databinding.ActivityAboutDataBindingBinding;
import org.yuni.chemicalnote.model.DataSaya;

public class AboutDataBindingActivity extends AppCompatActivity {

   // private TextView namasy, nimsy, matkulsy, githubsy;

    private ActivityAboutDataBindingBinding activityAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_data_binding);

        activityAbout= DataBindingUtil.setContentView(this, R.layout.activity_about_data_binding);
        activityAbout.setDatasaya(getCurrentData());
        initial();
    }

    private DataSaya getCurrentData(){
        DataSaya datasaya = new DataSaya();
        datasaya.setNamaSaya("Yuni Kurnia Taramita");
        datasaya.setNimSaya("1941723002");
        datasaya.setMatkulSy("Pemrograman Mobile");
        datasaya.setAkunGithub("github.com/yunikurniatr");
        return datasaya;
    }

    private void initial() {

    }
    public void onClickBack(View view) {
        Intent intent = new Intent(AboutDataBindingActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
