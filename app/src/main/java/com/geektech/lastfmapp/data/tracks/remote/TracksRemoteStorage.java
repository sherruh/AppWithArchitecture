package com.geektech.lastfmapp.data.tracks.remote;

import com.geektech.core.Logger;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.data.tracks.remote.model.TracksResponse;
import com.geektech.lastfmapp.entities.ArtistEntity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public class TracksRemoteStorage implements ITracksRemoteStorage {
    private final static String BASE_URL = "http://ws.audioscrobbler.com";
    private final static String API_KEY = "422b4ae97c17c164218f738cad32dcc4";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static TracksNetworkClient client = retrofit.create(TracksNetworkClient.class);

    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        Call<TracksResponse> call = client.getTracks(
                "chart.getTopTracks",
                API_KEY,
                "json",
                1,
                100,
                 ""
        );

        call.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getTracks().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                callback.onFailure("Top tracks failure: " + t.getMessage());
            }
        });
    }

    @Override
    public void getTopTracksOfArtist(ITracksRepository.TracksCallback callback, ArtistEntity artist) {

        String name = artist.getName();
        if (name.contains(" ")) name.replace(" ","%20");

        Call<TracksResponse> call = client.getTracks(
                "artist.gettoptracks",
                API_KEY,
                "json",
                1,
                100,
                name

        );

        call.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(Call<TracksResponse> call, Response<TracksResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getTopTracksOfArtist().getData());
                    } else {
                        callback.onFailure("Body is empty " + response.code());
                    }
                } else {
                    callback.onFailure("Request failed " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TracksResponse> call, Throwable t) {
                callback.onFailure("Top tracks failure: " + t.getMessage());
            }
        });
    }

    private interface TracksNetworkClient {

        @GET("/2.0/")
        Call<TracksResponse> getTracks(
                @Query("method") String method,
                @Query("api_key") String apiKey,
                @Query("format") String format,
                @Query("page") int page,
                @Query("limit") int limit,
                @Query("artist") String artist
        );
    }
}
