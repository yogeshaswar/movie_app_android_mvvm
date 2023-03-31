package com.yogeshaswar.moviesmvvmretrofit.api;

import com.yogeshaswar.moviesmvvmretrofit.models.Movie;
import com.yogeshaswar.moviesmvvmretrofit.models.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("movie/top_rated")
    Call<MovieResponse>getTMDBResponse(@Query("api_key") String api_key);
}
