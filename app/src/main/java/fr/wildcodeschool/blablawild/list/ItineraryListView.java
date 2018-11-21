package fr.wildcodeschool.blablawild.list;

import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.base.MvpView;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public interface ItineraryListView extends MvpView {
    void viewItinerary(ItineraryData itineraryData);
    void notifyInsertTripRow(int size);
    void showError(@StringRes int id);
}
