package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListNeighbourActivity extends AppCompatActivity {

    private NeighbourApiService mApiService;
    private RecyclerView mRecyclerView;
    private List<Neighbour> mNeighbours;

    // UI Components
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;
   /* @BindView(R.id.tabItem)
    TabItem neighbourTab;
    @BindView(R.id.tabItem2)
    TabItem favoritesTab;*/

    ListNeighbourPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();


        setSupportActionBar(mToolbar);
        mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

       mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if (mTabLayout.getSelectedTabPosition() == 1) {
                    mNeighbours = mApiService.getFavoriteNeighbours();
                    //mApiService.getFavoriteNeighbours();

                    System.out.println("Liste des favoris");
                } else {
                    mNeighbours = mApiService.getNeighbours();
                    //mApiService.getNeighbours();
                    System.out.println("Liste des voisins");
                }
                //mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));
                System.out.println("YEEEES");
                System.out.println(mTabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    @OnClick(R.id.add_neighbour)
    void addNeighbour() {
        AddNeighbourActivity.navigate(this);
    }

   /* @Subscribe
    public void onGetNeighbourProfile(GetNeighbourProfileEvent event) {

        new MyNeighbourRecyclerViewAdapter.GetNeighbourProfile(event);
    }*/
}
