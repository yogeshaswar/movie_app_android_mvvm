package com.yogeshaswar.moviesmvvmretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.yogeshaswar.moviesmvvmretrofit.api.MovieServiceInstance;
import com.yogeshaswar.moviesmvvmretrofit.models.Movie;
import com.yogeshaswar.moviesmvvmretrofit.vm.MAViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MAViewModel maViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // without data binding
        maViewModel = new ViewModelProvider(this).get(MAViewModel.class);
        List<Movie> movies = maViewModel.getMovies();
//        Toast.makeText(this, "" + !(movies == null), Toast.LENGTH_SHORT).show();

//        getApiData();
    }


//    private void getApiData() {
//        List<Movie> movies = maViewModel.getMovies();
//        for (int i = 0; i <movies.size() ; i++) {
//            Toast.makeText(this, ""+ movies.get(i).title, Toast.LENGTH_SHORT).show();
//        }
//    }
}