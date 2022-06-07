package com.newAds2021.MoviesData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlogMoviesModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String Id;
    @SerializedName("blog_category")
    @Expose
    private String Blog_Category;
    @SerializedName("server_title")
    @Expose
    private String Blog_Server_Title;
    @SerializedName("server_btn")
    @Expose
    private String Blog_Server_Btn_Text;
    @SerializedName("blog_link")
    @Expose
    private String Blog_Server_Link;

    public BlogMoviesModel(String blog_Category) {
        Blog_Category = blog_Category;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBlog_Category() {
        return Blog_Category;
    }

    public void setBlog_Category(String blog_Category) {
        Blog_Category = blog_Category;
    }

    public String getBlog_Server_Title() {
        return Blog_Server_Title;
    }

    public void setBlog_Server_Title(String blog_Server_Title) {
        Blog_Server_Title = blog_Server_Title;
    }

    public String getBlog_Server_Btn_Text() {
        return Blog_Server_Btn_Text;
    }

    public void setBlog_Server_Btn_Text(String blog_Server_Btn_Text) {
        Blog_Server_Btn_Text = blog_Server_Btn_Text;
    }

    public String getBlog_Server_Link() {
        return Blog_Server_Link;
    }

    public void setBlog_Server_Link(String blog_Server_Link) {
        Blog_Server_Link = blog_Server_Link;
    }

    protected BlogMoviesModel(Parcel in) {
        Id = in.readString();
        Blog_Category = in.readString();
        Blog_Server_Title = in.readString();
        Blog_Server_Btn_Text = in.readString();
        Blog_Server_Link = in.readString();
    }

    public static final Creator<BlogMoviesModel> CREATOR = new Creator<BlogMoviesModel>() {
        @Override
        public BlogMoviesModel createFromParcel(Parcel in) {
            return new BlogMoviesModel(in);
        }

        @Override
        public BlogMoviesModel[] newArray(int size) {
            return new BlogMoviesModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Id);
        parcel.writeString(Blog_Category);
        parcel.writeString(Blog_Server_Title);
        parcel.writeString(Blog_Server_Btn_Text);
        parcel.writeString(Blog_Server_Link);
    }
}
