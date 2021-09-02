package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Gets a neighbour
     * @param neighbour
     */
    //void getNeighbourProfile(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Add a neighbour to my Favorites
     * @param neighbour
     */
   // void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * Get all my Favorite Neighbours
     * @return {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Remove a neighbour from my Favorites
     * @param neighbour
     */
   // void removeFavoriteNeighbour(Neighbour neighbour);

    /**
     *
     * @param neighbour
     */
    //void changeFavoriteNeighbour(Neighbour neighbour);
    void updateNeighbour(Neighbour neighbour);

}
