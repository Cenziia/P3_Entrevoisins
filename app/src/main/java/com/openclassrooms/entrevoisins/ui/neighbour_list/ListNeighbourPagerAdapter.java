package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {
    int tabsCount;

    public ListNeighbourPagerAdapter(FragmentManager fm, int TabsCount) {
        super(fm);
        this.tabsCount = TabsCount;
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NeighbourFragment.newInstance();
            case 1:
                return FavoriteFragment.newInstance();
            default:
                return null;
        }
    }

    /**
     * get the number of pages
     *
     * @return
     */
    @Override
    public int getCount() {
        return tabsCount;
    }
}