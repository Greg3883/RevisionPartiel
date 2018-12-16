package com.example.bejaj.revisionpartiel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity
public class MyObject {
    @SerializedName("original_name")
    @NonNull
    @PrimaryKey
    private String text;
    @SerializedName("poster_path")
    private String imageUrl;
    @SerializedName("first_air_date")
    private String dateDiffusion;


    public MyObject(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return "http://image.tmdb.org/t/p/w185"+imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = "http://image.tmdb.org/t/p/w185"+imageUrl;
    }

    public String getDateDiffusion() {
        return dateDiffusion;
    }

    public void setDateDiffusion(String dateDiffusion) {
        this.dateDiffusion = dateDiffusion;
    }

}
