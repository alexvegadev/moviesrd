package org.android.moviesrd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.android.moviesrd.api.MoviesAPI;
import org.android.moviesrd.views.MoviesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.logo_text);
        tv.startAnimation(AnimationUtils.loadAnimation(this, R.anim.up_anim));
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MoviesActivity.class));
            finish();
        }, 1500);

    }
}