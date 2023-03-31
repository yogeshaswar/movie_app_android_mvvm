package com.yogeshaswar.moviesmvvmretrofit.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.yogeshaswar.moviesmvvmretrofit.api.MovieService;
import com.yogeshaswar.moviesmvvmretrofit.api.MovieServiceInstance;
import com.yogeshaswar.moviesmvvmretrofit.models.Movie;
import com.yogeshaswar.moviesmvvmretrofit.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    Application application;
    List<Movie> movies = new ArrayList<Movie>();
    MovieService movieService;
    private final String apiKey = "33ceb7f67849050b2d366d7b76bb68f6";
    // constructor
    public MovieRepository(Application application) {
        this.application = application;
    }
    // method api data
    public List<Movie> getMovieData(){

        MovieService movieService = MovieServiceInstance.getMovieService();
        Call<MovieResponse> call = movieService.getTMDBResponse(apiKey);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                if(movieResponse != null && movieResponse.getResults() != null) {
                    List<Movie> movies = (ArrayList<Movie>) movieResponse.getResults();
                    Toast.makeText(application, "" + !(movies == null) + "\n" + movies.size() , Toast.LENGTH_SHORT).show(); // 20
                    // here movies size is 20 means getting and storing movie api data into movies
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            // code
            }
        });
        Toast.makeText(application, "" + !(movies == null) + "\n" + movies.size(), Toast.LENGTH_SHORT).show(); // 0

        return movies; // PROBLEM -> here movies.size() == 0; so returning empty array



    }

}
