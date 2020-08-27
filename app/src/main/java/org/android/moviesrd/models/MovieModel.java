package org.android.moviesrd.models;

/**
 * @author Alex P. Vega
 * this class is an POJO about Movie information.
 */
public class MovieModel {
    private String title;
    private double voteAverage;
    private String releaseDate;
    private String imageUrl;
    private String desc;
    private String language;

    public MovieModel(String title, double voteAverage, String releaseDate, String imageUrl, String desc, String language) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.desc = desc;
        this.language = language;
    }

    public MovieModel(){

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
