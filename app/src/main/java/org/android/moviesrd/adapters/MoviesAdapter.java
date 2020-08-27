package org.android.moviesrd.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.android.moviesrd.R;
import org.android.moviesrd.models.MovieModel;
import org.android.moviesrd.views.MovieDetailsActivity;

import java.util.List;

/**
 * @author Alex P. Vega
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private Context mContext;
    private List<MovieModel> mData;
    private RequestOptions options;

    public MoviesAdapter(Context mContext, List<MovieModel> mData){
        this.mContext = mContext;
        this.mData = mData;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_rect).error(R.drawable.loading_rect);
    }


    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.movie_item, parent, false);
        MoviesViewHolder mvh = new MoviesViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        MovieModel mm = mData.get(position);
        holder.movieTitle.setText(mm.getTitle());
        holder.movieRate.setText(""+mm.getVoteAverage());
        holder.movieYear.setText("Year: " + mm.getReleaseDate());
        holder.movieLang.setText("Language: " + mm.getLanguage());
        Glide.with(mContext).load(mm.getImageUrl()).apply(options).into(holder.movieImg);
        holder.cvRoot.setOnClickListener(view -> {
            Intent i = new Intent(mContext, MovieDetailsActivity.class);
            i.putExtra("m_title", mm.getTitle());
            i.putExtra("m_rate", ""+mm.getVoteAverage());
            i.putExtra("m_year", ""+mm.getReleaseDate());
            i.putExtra("m_lang", ""+mm.getLanguage());
            i.putExtra("m_img", ""+mm.getImageUrl());
            i.putExtra("m_desc", ""+mm.getDesc());
            mContext.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder{
        private CardView cvRoot;
        private ImageView movieImg;
        private TextView movieTitle;
        private TextView movieYear;
        private TextView movieRate;
        private TextView movieLang;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            cvRoot = itemView.findViewById(R.id.cv_root);
            movieImg = itemView.findViewById(R.id.iv_movie_img);
            movieTitle = itemView.findViewById(R.id.tv_movie_title);
            movieYear = itemView.findViewById(R.id.tv_movie_year);
            movieRate = itemView.findViewById(R.id.tv_movie_rate);
            movieLang = itemView.findViewById(R.id.tv_movie_lang);
        }
    }
}
