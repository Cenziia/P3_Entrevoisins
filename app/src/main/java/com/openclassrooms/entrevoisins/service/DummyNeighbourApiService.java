package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
   /* @Override
    public void getNeighbourProfile(Neighbour neighbour) {
        neighbours.get(neighbours.indexOf(neighbour));
    }*/

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


/*
    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
   /* @Override
    public void changeFavoriteNeighbour(Neighbour neighbour) {
        neighbour.setFavorite(!neighbour.getFavorite());
    }*/

    /**
     * {@inheritDoc}
     *
     */
    /*@Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteNeighboursList = new ArrayList<>();
        for (Neighbour i : neighbours) {
            if (i.getFavorite() == true) {
                favoriteNeighboursList.add(i);
            }
        }

        System.out.println(favoriteNeighboursList);
        return favoriteNeighboursList;
    }*/
/*
    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    /*@Override
    public void removeFavoriteNeighbour(Neighbour neighbour) {
        neighbour.setFavorite(false);
    }*/

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteNeighbourList = new ArrayList<>();
        //List<Neighbour>neighbours = getNeighbours();
        for (Neighbour i : neighbours) {
            if  (i.getFavorite()) {
                System.out.println(i);
                favoriteNeighbourList.add(i);
            }
        }
        System.out.println(favoriteNeighbourList);
        return favoriteNeighbourList;
    }
    @Override
    public void updateNeighbour(Neighbour neighbour) {
        int index = neighbours.indexOf(neighbour);
        neighbours.set(index,neighbour);
    }
}
