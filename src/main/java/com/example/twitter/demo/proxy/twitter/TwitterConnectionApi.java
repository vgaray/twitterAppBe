package com.example.twitter.demo.proxy.twitter;

import com.example.twitter.demo.data.TwitterData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import java.io.IOException;

public interface TwitterConnectionApi {

    @GET("users/{id}/tweets?tweet.fields=created_at,public_metrics&expansions=author_id&user.fields=created_at&max_results=5")
    Call<TwitterData> getTimeLineByTwitterId(@Path("id") String id,@Header("Authorization") String token) throws IOException;

}
