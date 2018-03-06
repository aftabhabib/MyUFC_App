package com.example.tae.myufc_app.data.network.service;

import com.example.tae.myflavoursapp.BuildConfig;
import com.example.tae.myflavoursapp.data.network.model.CharactersModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by TAE on 08-Feb-18.
 */

public interface IRequestInterface {

  //  @GET(ApiList.TOP_RATED_MOVIES)
  //  Observable<TopRatedMovies> getTopRatedMovies(@Query("api_key") String apiKey);

  //  @GET("movie/{id}")
  //  Observable<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET(BuildConfig.DATA)
    Observable<CharactersModel> getCharacters();

    //@GET(ApiList.GameOT_URL)
   // Observable<>
}
