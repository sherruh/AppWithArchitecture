package com.geektech.lastfmapp.presentation.main;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.lastfmapp.App;
import com.geektech.lastfmapp.R;
import com.geektech.lastfmapp.presentation.topartists.ITopArtistsContract;
import com.geektech.lastfmapp.presentation.topartists.TopArtistsFragment;
import com.geektech.lastfmapp.presentation.topartists.TopArtistsPresenter;
import com.geektech.lastfmapp.presentation.toptracks.ITopTracksContract;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksFragment;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksPresenter;

public class MainActivity extends AppCompatActivity {

    private ITopTracksContract.Presenter topTracksPresenter;
    private ITopArtistsContract.Presenter topArtistsPresenter;
    private TopArtistsFragment topArtistsFragment;
    private TopTracksFragment topTracksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topArtistsPresenter = new TopArtistsPresenter(App.artistsRepository);
        topTracksPresenter = new TopTracksPresenter(App.tracksRepository);
        topArtistsFragment = TopArtistsFragment.newInstance();
        topTracksFragment = TopTracksFragment.newInstance();
        topArtistsPresenter.attachView(topArtistsFragment);
        topTracksPresenter.attachView(topTracksFragment);

        ViewPager viewPager = findViewById(R.id.viewpager);
        TopChartsFragmentPagerAdapter pagerAdapter = new TopChartsFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this,new Fragment[]{
                        topTracksFragment,topArtistsFragment
        });

        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public class TopChartsFragmentPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[] { "Top tracks","Top artists"};
        private Fragment[] fragments;

        public TopChartsFragmentPagerAdapter(FragmentManager fm, Context context,Fragment[] fragments) {

            super(fm);
            this.fragments=fragments;
        }

        @Override public int getCount() {
            return fragments.length;
        }

        @Override public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
