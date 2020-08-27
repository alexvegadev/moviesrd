package org.android.moviesrd.views;


import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.android.moviesrd.R;
import org.android.moviesrd.adapters.MoviesAdapter;
import org.android.moviesrd.api.MoviesAPI;
import org.android.moviesrd.models.MovieModel;

import java.util.List;

/**
 * @author Alex P. Vega
 */
public class MoviesActivity extends AppCompatActivity {
    private RecyclerView movieView;
    private List<MovieModel> movies;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        movieView = findViewById(R.id.rv_movies);
        new Handler().post(() -> {
            setUpData();
        });
    }

    void setUpData(){
        movies =  MoviesAPI.getMoviesToDiscover();
        MoviesAdapter moviesAdapter = new MoviesAdapter(this, movies);
        movieView.setLayoutManager(new LinearLayoutManager(this));
        movieView.setAdapter(moviesAdapter);
    }
}
