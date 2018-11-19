package fr.wildcodeschool.blablawild.list;

import android.os.Bundle;
import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.base.MvpPresenter;

public interface ItineraryListPresenter<V extends ItineraryListView> extends MvpPresenter<V> {
    void onViewItinerary(Bundle bundle);
    void onError(@StringRes int id);
}
