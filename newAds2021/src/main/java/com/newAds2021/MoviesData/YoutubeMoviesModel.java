package com.newAds2021.MoviesData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YoutubeMoviesModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String Id;
    @SerializedName("title")
    @Expose
    private String Y_Movies_Title;
    @SerializedName("image_url")
    @Expose
    private String Y_Movies_Image_Url;
    @SerializedName("video_id")
    @Expose
    private String Y_Movies_Video_ID;
    @SerializedName("category")
    @Expose
    private String Y_Movies_Category;
    @SerializedName("category_image")
    @Expose
    private String Y_Movies_Category_Image;

    public YoutubeMoviesModel(String y_Movies_Category, String y_Movies_Category_Image) {
        Y_Movies_Category = y_Movies_Category;
        Y_Movies_Category_Image = y_Movies_Category_Image;
    }

    protected YoutubeMoviesModel(Parcel in) {
        Id = in.readString();
        Y_Movies_Title = in.readString();
        Y_Movies_Image_Url = in.readString();
        Y_Movies_Video_ID = in.readString();
        Y_Movies_Category = in.readString();
        Y_Movies_Category_Image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(Y_Movies_Title);
        dest.writeString(Y_Movies_Image_Url);
        dest.writeString(Y_Movies_Video_ID);
        dest.writeString(Y_Movies_Category);
        dest.writeString(Y_Movies_Category_Image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YoutubeMoviesModel> CREATOR = new Creator<YoutubeMoviesModel>() {
        @Override
        public YoutubeMoviesModel createFromParcel(Parcel in) {
            return new YoutubeMoviesModel(in);
        }

        @Override
        public YoutubeMoviesModel[] newArray(int size) {
            return new YoutubeMoviesModel[size];
        }
    };

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getY_Movies_Title() {
        return Y_Movies_Title;
    }

    public void setY_Movies_Title(String y_Movies_Title) {
        Y_Movies_Title = y_Movies_Title;
    }

    public String getY_Movies_Image_Url() {
        return Y_Movies_Image_Url;
    }

    public void setY_Movies_Image_Url(String y_Movies_Image_Url) {
        Y_Movies_Image_Url = y_Movies_Image_Url;
    }

    public String getY_Movies_Video_ID() {
        return Y_Movies_Video_ID;
    }

    public void setY_Movies_Video_ID(String y_Movies_Video_ID) {
        Y_Movies_Video_ID = y_Movies_Video_ID;
    }

    public String getY_Movies_Category() {
        return Y_Movies_Category;
    }

    public void setY_Movies_Category(String y_Movies_Category) {
        Y_Movies_Category = y_Movies_Category;
    }

    public String getY_Movies_Category_Image() {
        return Y_Movies_Category_Image;
    }

    public void setY_Movies_Category_Image(String y_Movies_Category_Image) {
        Y_Movies_Category_Image = y_Movies_Category_Image;
    }
}
