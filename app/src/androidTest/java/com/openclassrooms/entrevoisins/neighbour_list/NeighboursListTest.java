package com.openclassrooms.entrevoisins.neighbour_list;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static final int ITEMS_COUNT = 14;

    private ListNeighbourActivity mActivity;
    private NeighbourApiService mApiService;
    private List<Neighbour> neighboursList;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class, false, true);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mApiService = DI.getNeighbourApiService();
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * 3. Test vérifiant qu'au clic sur le bouton de suppression, la liste d'utilisateurs compte bien un
     * utilisateur en moins.
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 1
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 13
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT - 1));
    }

    /**
     * 1. Test vérifiant que lorsqu'on clique sur un élément de la liste, l'écran de détails est bien lancé.
     * Quand on clique sur un voisin, cela ouvre son profil
     */
    @Test
    public void myNeighbourList_clickOnNeighbourAction_shouldOpenNeighbourProfileActivity() {
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT - 1))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.neighbour_page_name_txt)).check(matches(isDisplayed()));
    }

    /**
     * 2. Test vérifiant qu'au démarrage de ce nouvel écran le TextView indiquant le nom de l'utilisateur
     * en question est bien rempli.
     * Quand on clique sur un voisin, c'est bien le nom du voisin sélectionné qui est affiché
     */
    @Test
    public void myNeighbourList_toNeighbourProfileActivity_shouldCheckIfSameName() {
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.neighbour_page_name_txt)).check(matches(withText(mApiService.getNeighbours().get(3).getName())));
    }

    /**
     * 4. Test vérifiant que l'onglet Favoris n'affiche que les voisins marqués comme favoris.
     */
    @Test
    public void myNeighbourList_onFavoritesTab_shouldShowOnlyFavoriteNeighbours() {
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(ViewMatchers.withId(R.id.neighbour_page_fav_btn)).perform(click());
        onView(ViewMatchers.withId(R.id.neighbour_page_back_btn)).perform(click());
        onView(ViewMatchers.withId(R.id.main_content)).perform(swipeLeft());
        onView(ViewMatchers.withId(R.id.list_favorites)).check(withItemCount(1));
    }
}