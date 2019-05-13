package com.geektech.lastfmapp.presentation.toptracks;

import android.util.Log;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.tracks.ITracksRepository;
import com.geektech.lastfmapp.entities.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TopTracksPresenter extends CoreMvpPresenter<ITopTracksContract.View>
        implements ITopTracksContract.Presenter {

    private ITracksRepository repository;
    private ArrayList<TrackEntity> mCache = new ArrayList<>();

    private void setCache(List<TrackEntity> tracks){
        mCache.clear();
        mCache.addAll(tracks);
    }

    public TopTracksPresenter(ITracksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getTracks() {
        repository.getTracks(new ITracksRepository.TracksCallback() {
            @Override
            public void onSuccess(List<TrackEntity> tracks) {
                setCache(tracks);
                Logger.d("Tracks success " + tracks.size());
                if (view != null) {
                    view.showTracks(tracks);
                }
            }

            @Override
            public void onFailure(String message) {
                Logger.d(message);
                if (view != null) {
                    view.showMessage(message);
                }
            }
        });
    }

    @Override
    public void onTrackClick(int position) {
        if (mCache.size() > position && position >= 0) {
            if (view != null) {
                view.openTrackDetails(mCache.get(position));
            }
        }
    }
}
