package com.example.user.firstapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 13-10-2017.
 */

public class PodCastResponse {
    @SerializedName("results")
    private List<PodCastModel> results;

    public List<PodCastModel> getResults() {
        return results;
    }

    public void setResults(List<PodCastModel> results) {
        this.results = results;
    }

}
