package com.yogeshaswar.moviesmvvmretrofit.vm;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.yogeshaswar.moviesmvvmretrofit.models.Movie;
import com.yogeshaswar.moviesmvvmretrofit.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MAViewModel extends AndroidViewModel {
    MovieRepository movieRepository;
    List<Movie> movieData = new ArrayList<>();
    public MAViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }
    public List<Movie> getMovies(){

        movieData = movieRepository.getMovieData();
        Toast.makeText(getApplication(), "" + movieData.size() , Toast.LENGTH_SHORT).show();
        return movieData;

    }
}
