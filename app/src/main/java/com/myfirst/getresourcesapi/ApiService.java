package com.myfirst.getresourcesapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/unknown/{id}")
    Call<ResponseResources> getPosts(@Path("id") int id);

}
