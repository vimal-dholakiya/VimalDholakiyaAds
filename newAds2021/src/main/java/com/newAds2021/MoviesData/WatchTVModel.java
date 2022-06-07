package com.newAds2021.MoviesData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatchTVModel implements Parcelable{

    @SerializedName("id")
    @Expose
    private String Id;
    @SerializedName("channel_name")
    @Expose
    private String ChannelName;
    @SerializedName("channel_url")
    @Expose
    private String ChannelUrl;
    @SerializedName("category")
    @Expose
    private String Category;
    @SerializedName("category_image")
    @Expose
    private String CategoryImage;
    @SerializedName("channel_logo")
    @Expose
    private String ChannelLogo;



    public WatchTVModel(String category, String categoryImage) {
        Category = category;
        CategoryImage = categoryImage;
    }


    protected WatchTVModel(Parcel in) {
        Id = in.readString();
        ChannelName = in.readString();
        ChannelUrl = in.readString();
        Category = in.readString();
        CategoryImage = in.readString();
        ChannelLogo = in.readString();
    }

    public static final Creator<WatchTVModel> CREATOR = new Creator<WatchTVModel>() {
        @Override
        public WatchTVModel createFromParcel(Parcel in) {
            return new WatchTVModel(in);
        }

        @Override
        public WatchTVModel[] newArray(int size) {
            return new WatchTVModel[size];
        }
    };



    public String getChannelLogo() {
        return ChannelLogo;
    }

    public void setChannelLogo(String channelLogo) {
        ChannelLogo = channelLogo;
    }



    public String getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        CategoryImage = categoryImage;
    }



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getChannelUrl() {
        return ChannelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        ChannelUrl = channelUrl;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Id);
        dest.writeString(ChannelName);
        dest.writeString(ChannelUrl);
        dest.writeString(Category);
        dest.writeString(CategoryImage);
        dest.writeString(ChannelLogo);
    }
}