package com.geektech.lastfmapp.presentation.toptracks;

import com.geektech.lastfmapp.model.TrackEntity;

import java.util.List;

public interface TopTracksContract {
    interface View {
        void showTracks(List<TrackEntity> tracks);

        void openTrack(TrackEntity track);

        void showMessage(String message);

        void finishView();

        void attachPresenter(Presenter presenter);
    }

    interface Presenter {
        void getTracks();

        void onTrackClick(int position);

        void attachView(View view);

        void detachView();
    }
}
