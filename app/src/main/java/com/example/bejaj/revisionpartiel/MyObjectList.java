package com.example.bejaj.revisionpartiel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyObjectList {
    @SerializedName("results")
    private List<MyObject> shows;

    public MyObjectList(List<MyObject> musics) {
        this.shows = musics;
    }

    public List<MyObject> getShows() {
        return shows;
    }

    public void setMusics(List<MyObject> musics) {
        this.shows = musics;
    }

    public void insertObj(MyObject obj) {
        this.shows.add(obj);
    }
}
