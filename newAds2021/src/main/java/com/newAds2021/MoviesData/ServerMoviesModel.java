package com.newAds2021.MoviesData;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerMoviesModel implements Parcelable {
    String id, movietitle,duration,category,releasedate,posterimage,description,urllinkone,urllinktwo,urllinkthree,urllinkfour,urllinkfive,mailserverlink,movies_view;



    public ServerMoviesModel(String category) {
        this.category = category;
    }

    protected ServerMoviesModel(Parcel in) {
        id = in.readString();
        movietitle = in.readString();
        duration = in.readString();
        category = in.readString();
        releasedate = in.readString();
        posterimage = in.readString();
        description = in.readString();
        urllinkone = in.readString();
        urllinktwo = in.readString();
        urllinkthree = in.readString();
        urllinkfour = in.readString();
        urllinkfive = in.readString();
        mailserverlink = in.readString();
        movies_view = in.readString();
    }

    public static final Creator<ServerMoviesModel> CREATOR = new Creator<ServerMoviesModel>() {
        @Override
        public ServerMoviesModel createFromParcel(Parcel in) {
            return new ServerMoviesModel(in);
        }

        @Override
        public ServerMoviesModel[] newArray(int size) {
            return new ServerMoviesModel[size];
        }
    };

    public String getMovies_view() {
        return movies_view;
    }

    public void setMovies_view(String movies_view) {
        this.movies_view = movies_view;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getPosterimage() {
        return posterimage;
    }

    public void setPosterimage(String posterimage) {
        this.posterimage = posterimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrllinkone() {
        return urllinkone;
    }

    public void setUrllinkone(String urllinkone) {
        this.urllinkone = urllinkone;
    }

    public String getUrllinktwo() {
        return urllinktwo;
    }

    public void setUrllinktwo(String urllinktwo) {
        this.urllinktwo = urllinktwo;
    }

    public String getUrllinkthree() {
        return urllinkthree;
    }

    public void setUrllinkthree(String urllinkthree) {
        this.urllinkthree = urllinkthree;
    }

    public String getUrllinkfour() {
        return urllinkfour;
    }

    public void setUrllinkfour(String urllinkfour) {
        this.urllinkfour = urllinkfour;
    }

    public String getUrllinkfive() {
        return urllinkfive;
    }

    public void setUrllinkfive(String urllinkfive) {
        this.urllinkfive = urllinkfive;
    }

    public String getMailserverlink() {
        return mailserverlink;
    }

    public void setMailserverlink(String mailserverlink) {
        this.mailserverlink = mailserverlink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(movietitle);
        parcel.writeString(duration);
        parcel.writeString(category);
        parcel.writeString(releasedate);
        parcel.writeString(posterimage);
        parcel.writeString(description);
        parcel.writeString(urllinkone);
        parcel.writeString(urllinktwo);
        parcel.writeString(urllinkthree);
        parcel.writeString(urllinkfour);
        parcel.writeString(urllinkfive);
        parcel.writeString(mailserverlink);
        parcel.writeString(movies_view);
    }
}
