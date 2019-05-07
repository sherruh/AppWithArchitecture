package com.geektech.lastfmapp.presentation.topartists;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geektech.core.Logger;
import com.geektech.core.mvp.CoreMvpFragment;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.entities.ArtistEntity;
import com.geektech.lastfmapp.presentation.topartists.recycler.TopArtistViewHolder;
import com.geektech.lastfmapp.presentation.topartists.recycler.TopArtistsAdapter;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksFragment;

import java.util.ArrayList;
import java.util.List;

public class TopArtistsFragment extends CoreMvpFragment<ITopArtistsContract.Presenter>
    implements ITopArtistsContract.View, TopArtistViewHolder.TopArtistClickListener {

    public static TopArtistsFragment newInstance(){
        return new TopArtistsFragment();
    }

    TopArtistsAdapter mAdapter;
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_top_artists;
    }

    @Override
    protected void initView(View view) {
        recyclerView=getActivity().findViewById(R.id.recycler_top_artists);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new TopArtistsAdapter(this,new ArrayList<>());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {
        mAdapter.setArtists(artists);
    }

    @Override
    public void openArtistDetails(ArtistEntity artist) {

    }

    @Override
    public void onArtistClick(int position) {
        Logger.d("Clicked on " +position);
    }
}
