package com.example.user.firstapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by User on 13-10-2017.
 */

public interface ApiInterface {

   // @GET("podcasts/top-podcasts/")
    //Call<PodCastResponse> getPodcastContentRss(@Path("all/") String path);

    @GET("search")
    Call<PodCastResponse> getPodcastContent(@Query("term") String path, @Query("country") String country);
}

