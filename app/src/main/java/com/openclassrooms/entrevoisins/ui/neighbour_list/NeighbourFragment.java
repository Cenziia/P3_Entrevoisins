package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class NeighbourFragment extends Fragment {

    private NeighbourApiService mApiService;
    private List<Neighbour> mNeighbours;
    private RecyclerView mRecyclerView;
    //private List<Neighbour> mFavorites;
   /* @BindView(R.id.tabItem)
    TabItem neighbourTab;
    @BindView(R.id.tabItem2)
    TabItem favoritesTab;
    //TabItem mTabItem = getId()findViewById(R.id.tabItem);
    @BindView(R.id.tabs)
    TabLayout mTabLayout;

    /**
     * Create and return a new instance
     * @return @{@link NeighbourFragment}
     */
    public static NeighbourFragment newInstance() { //String section = variable qui va identifier l'onglet qui a été cliqué
        NeighbourFragment fragment = new NeighbourFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbour_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;


/*
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if (mTabLayout.getSelectedTabPosition() == 1) {
                    //mNeighbours = mApiService.getFavoriteNeighbours();
                    System.out.println("Liste des favoris");
                } else {
                    //mNeighbours = mApiService.getNeighbours();
                    System.out.println("Liste des voisins");
                }
                mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));
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

    }*/
    }



    /**
     * Init the List of neighbours
     */
    private void initList() {

        /*if () {
            //(R.id.tabItem)
            mNeighbours = mApiService.getNeighbours();
        } else if (getView().findViewById(R.id.tabItem2)) {
            mNeighbours = mApiService.getFavoriteNeighbours();
        }*/

        //if () {

       mNeighbours = mApiService.getNeighbours();


        //}
        //else if () {
           //mNeighbours = mApiService.getFavoriteNeighbours();
        //}*/
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));

           /* for (Neighbour i : mNeighbours) {
                if (i.getFavorite()) {
                    System.out.println(i.getFavorite());
                    favoriteNeighbourList.add(i);
                }
            }
            System.out.println(mNeighbours);
            return favoriteNeighbourList;*/
        }


    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        mApiService.deleteNeighbour(event.neighbour);
        initList();
    }

    /*@Subscribe
    public void onGetNeighbourProfile(GetNeighbourProfileEvent event) {
        //mApiService.getNeighbourProfile(event.neighbour);
        new MyNeighbourRecyclerViewAdapter.GetNeighbourProfile(event);
    }*/

    /*@Subscribe
    public void onSetFavoritesList(SetFavoritesList event) {
        mApiService.getFavoriteNeighbours();
        initList();
    }*/

}
