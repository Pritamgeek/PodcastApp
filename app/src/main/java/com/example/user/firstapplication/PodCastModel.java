package com.example.user.firstapplication;

/**
 * Created by User on 13-10-2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PodCastModel {
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("trackName")
    private String trackName;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;

    public PodCastModel(String artistName, String artworkUrl100) {
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getArtistName() {
        return artistName;
    }

    public String setArtistName(String artistName) {
        this.artistName= artistName;
        return artistName;
    }


    public String getTrackName() {
        return trackName;
    }

    public String settrackName(String trackName) {
        this.trackName= trackName;
        return trackName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = "http://is4.mzstatic.com/image/thumb/" + " ";
    }

}
