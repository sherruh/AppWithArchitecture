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
import com.geektech.lastfmapp.presentation.toptracks.ITopTracksContract;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksFragment;
import com.geektech.lastfmapp.presentation.toptracks.TopTracksPresenter;

public class MainActivity extends AppCompatActivity {

    private ITopTracksContract.Presenter mPresenter;
    private ITopTracksContract.Presenter mPresenter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        SampleFragmentPagerAdapter pagerAdapter=new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView((ITopTracksContract.View)pagerAdapter.getItem(0));
        mPresenter.getTracks();
        mPresenter2 = new TopTracksPresenter(App.tracksRepository);
        mPresenter2.attachView((ITopTracksContract.View)pagerAdapter.getItem(1));
        mPresenter2.getTracks();
    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        private String tabTitles[] = new String[] { "Top tracks","Top artists"};
        private Fragment[] fragments=new Fragment[]{
                TopTracksFragment.newInstance(),
                TopTracksFragment.newInstance()
        };


        public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
        }

        @Override public int getCount() {
            return PAGE_COUNT;
        }

        @Override public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
