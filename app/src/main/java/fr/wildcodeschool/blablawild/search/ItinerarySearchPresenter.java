package fr.wildcodeschool.blablawild.search;

import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.base.MvpPresenter;

public interface ItinerarySearchPresenter<V extends ItinerarySearchView>
        extends MvpPresenter<V> {
    void onSearchSend(String departure, String destination, String date);
    void onError(@StringRes int id);
}
