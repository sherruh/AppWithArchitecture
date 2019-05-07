package com.geektech.lastfmapp.presentation.topartists;

import android.view.View;

import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksFragment;

import java.util.List;

public class TopArtistsFragment extends CoreMvpFragment<ITopArtistsContract.Presenter>
    implements ITopArtistsContract.View{

    public static TopTracksFragment newInstance(){
        return new TopTracksFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_artists;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {

    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {

    }
}
