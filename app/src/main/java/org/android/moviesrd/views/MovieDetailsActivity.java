package org.android.moviesrd.views;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import org.android.moviesrd.R;

/**
 * @author Alex P. Vega
 */
public class MovieDetailsActivity extends AppCompatActivity {
    private TextView title, rate, year, lang, desc;
    private ImageView img;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_rect).error(R.drawable.loading_rect);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().hide();
        title = findViewById(R.id.d_movie_title);
        rate = findViewById(R.id.d_movie_rate);
        year = findViewById(R.id.d_movie_year);
        lang = findViewById(R.id.d_movie_lang);
        desc = findViewById(R.id.d_movie_desc);
        img = findViewById(R.id.d_movie_img);
        collapsingToolbarLayout = findViewById(R.id.d_collapsbar);
        collapsingToolbarLayout.setTitle(getIntent().getExtras().getString("m_title"));
        title.setText(getIntent().getExtras().getString("m_title"));
        rate.setText(getIntent().getExtras().getString("m_rate"));
        year.setText("Year: " + getIntent().getExtras().getString("m_year"));
        lang.setText("Language: " + getIntent().getExtras().getString("m_lang"));
        desc.setText(getIntent().getExtras().getString("m_desc"));
        String imgUrl = getIntent().getExtras().getString("m_img");
        Glide.with(this).load(imgUrl).apply(options).into(img);
    }
}
