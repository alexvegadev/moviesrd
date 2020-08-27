package org.android.moviesrd.api;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.android.moviesrd.models.MovieModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MoviesAPI {
    private static final String API_URL = "https://api.themoviedb.org/3/discover/movie?api_key=2ec9563a6bfdc6a824de1e2e478eef6e";

    public static List<MovieModel> getMoviesToDiscover(){
        List<MovieModel> movies = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL)
                .build();
        try(Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            JsonObject obj = JsonParser.parseString(body).getAsJsonObject();
            JsonArray results = obj.getAsJsonArray("results");
            for(JsonElement elm : results){
                MovieModel mm = new MovieModel();
                JsonObject movie = elm.getAsJsonObject();
                mm.setTitle(movie.get("original_title").getAsString());
                mm.setImageUrl("https://image.tmdb.org/t/p/w500"+movie.get("poster_path").getAsString());
                mm.setLanguage(movie.get("original_language").getAsString());
                mm.setVoteAverage(movie.get("vote_average").getAsDouble());
                mm.setReleaseDate(movie.get("release_date").getAsString());
                mm.setDesc(movie.get("overview").getAsString());
                movies.add(mm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
