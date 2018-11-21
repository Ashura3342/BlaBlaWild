package fr.wildcodeschool.blablawild.search;

import fr.wildcodeschool.blablawild.base.MvpPresenter;

public interface ItinerarySearchPresenter<V extends ItinerarySearchView>
        extends MvpPresenter<V> {
    void onSearchSend(String departure, String destination, String date);
    void onError(int id);
}
