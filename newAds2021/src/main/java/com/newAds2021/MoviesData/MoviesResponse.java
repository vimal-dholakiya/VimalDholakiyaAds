package com.newAds2021.MoviesData;



import java.util.ArrayList;

public class MoviesResponse {

    String success;
    ArrayList<YoutubeMoviesModel> Youtube_Movies;
    ArrayList<BlogMoviesModel> Blog_Movies;
    ArrayList<WatchTVModel> watch_tv;
    ArrayList<ServerMoviesModel> Server_Movies;

    public ArrayList<ServerMoviesModel> getServer_Movies() {
        return Server_Movies;
    }

    public void setServer_Movies(ArrayList<ServerMoviesModel> server_Movies) {
        Server_Movies = server_Movies;
    }

    public ArrayList<WatchTVModel> getWatch_tv() {
        return watch_tv;
    }

    public void setWatch_tv(ArrayList<WatchTVModel> watch_tv) {
        this.watch_tv = watch_tv;
    }

    public ArrayList<BlogMoviesModel> getBlog_Movies() {
        return Blog_Movies;
    }

    public void setBlog_Movies(ArrayList<BlogMoviesModel> blog_Movies) {
        Blog_Movies = blog_Movies;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ArrayList<YoutubeMoviesModel> getYoutube_Movies() {
        return Youtube_Movies;
    }

    public void setYoutube_Movies(ArrayList<YoutubeMoviesModel> youtube_Movies) {
        Youtube_Movies = youtube_Movies;
    }
}
