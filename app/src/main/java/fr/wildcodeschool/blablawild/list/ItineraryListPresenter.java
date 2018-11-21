package fr.wildcodeschool.blablawild.list;

import fr.wildcodeschool.blablawild.base.MvpPresenter;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public interface ItineraryListPresenter<V extends ItineraryListView> extends MvpPresenter<V> {
    void onViewItinerary(ItineraryData itineraryData);
    void onError(int id);
}
