package com.geektech.lastfmapp.presentation.topartists;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpPresenter;
import com.geektech.lastfmapp.data.artists.IArtistsRepository;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.presentation.artist.IArtistContract;

import java.util.List;

public class TopArtistsPresenter extends CoreMvpPresenter<ITopArtistsContract.View>
        implements ITopArtistsContract.Presenter {

    private IArtistsRepository artistsRepository;

    public TopArtistsPresenter(IArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @Override
    public void getArtists() {
        artistsRepository.getArtists(new IArtistsRepository.ArtistsCallback() {
            @Override
            public void onSuccess(List<ArtistEntity> artists) {
                Logger.d("Artist list size " +artists.size());
                if(view!=null){
                    view.showArtists(artists);
                }
            }

            @Override
            public void onFailure(String message) {
                Logger.d("Failed "+message);
                if (view!=null){
                    view.showMessage(message);
                }
            }
        });
    }

    @Override
    public void onArtistClick(int position) {

    }

}