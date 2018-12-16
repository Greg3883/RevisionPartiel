package com.example.bejaj.revisionpartiel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetTvShow {

    @GET("3/tv/popular")
    Call<MyObjectList> getPopularTVList(@Query("api_key") String apiKey,
                                      @Query("page") Integer page,
                                      @Query("language") String langage);
}
