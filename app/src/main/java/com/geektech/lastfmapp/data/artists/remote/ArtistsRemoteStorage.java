package com.geektech.lastfmapp.data.artists.remote;

import com.geektech.core.Logger;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.data.artists.remote.model.ArtistsResponse;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.remote.TracksRemoteStorage;
import com.geektech.lastfmapp.data.tracks.remote.model.TracksResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ArtistsRemoteStorage implements IArtistsRemoteStorage {

    private final static String BASE_URL = "http://ws.audioscrobbler.com";
    private final static String API_KEY = "422b4ae97c17c164218f738cad32dcc4";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ArtistsNetworkClient client = retrofit.create(ArtistsNetworkClient.class);

    @Override
    public void getArtists(IArtistsRepository.ArtistsCallback callback) {
        Call<ArtistsResponse> call = client.getArtists(
                "chart.gettopartists",
                API_KEY,
                "json",
                1,
                100
        );

        call.enqueue(new Callback<ArtistsResponse>() {
            @Override
            public void onResponse(Call<ArtistsResponse> call, Response<ArtistsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getArtists().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArtistsResponse> call, Throwable t) {
                callback.onFailure("Top artists failure: " + t.getMessage());
            }
        });
    }

    private interface ArtistsNetworkClient {

        @GET("/2.0/")
        Call<ArtistsResponse> getArtists(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("format") String format,
                @Query("page") int page,
                @Query("perPage") int limit
        );
    }
}
