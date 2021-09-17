package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    /**
     * Lister les voisins
     */
    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    /**
     * Ajouter/Créer un voisin
     */
    @Test
    public void createNeighbourWithSuccess() {
        Neighbour neighbourToCreate = new Neighbour(15, "New", "https://drive.google.com/uc?id=1Kp7mPlgC_skR18CovwvJmTkxEPv7iOnw", "Pokéville ; 1km",
                "+00 0 00 00 00 00 00 00", "Blabla blablabla, bla, blablabl blabla");
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }

    /**
     * Supprimer un voisin
     */
    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     * Lister les voisins favoris
     */
    @Test
    public void getFavoriteNeighboursWithSuccess() {
        Neighbour neighbour = service.getNeighbours().get(3);
        neighbour.setFavorite(true);
        assertFalse(service.getFavoriteNeighbours().isEmpty());
    }

    /**
     * Ajouter un voisin aux favoris
     */
    @Test
    public void addFavoriteNeighbourWithSuccess() {
        Neighbour favoriteNeighbourToAdd = service.getNeighbours().get(2);
        favoriteNeighbourToAdd.setFavorite(true);
        assertTrue(service.getFavoriteNeighbours().contains(favoriteNeighbourToAdd));
    }

    /**
     * Supprimer un voisin des favoris
     */
    @Test
    public void removeFavoriteNeighbourWithSuccess() {
        Neighbour favoriteNeighbourtoRemove = service.getNeighbours().get(2);
        favoriteNeighbourtoRemove.setFavorite(false);
        assertFalse(service.getFavoriteNeighbours().contains(favoriteNeighbourtoRemove));
    }
}
