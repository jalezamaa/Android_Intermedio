package com.example.jobs.Interface;

import com.example.jobs.Model.jobs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("positions.json")
    Call<List<jobs>> searchMovie(@Query("description") String description);
}
