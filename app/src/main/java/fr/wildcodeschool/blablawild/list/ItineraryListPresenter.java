package fr.wildcodeschool.blablawild.list;

import fr.wildcodeschool.blablawild.base.MvpPresenter;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.adapter.TripRowView;

public interface ItineraryListPresenter<V extends ItineraryListView> extends MvpPresenter<V> {
    void onViewItinerary(ItineraryData itineraryData);
    void onError(int id);
    void onBindRepositoryRowViewAtPosition(TripRowView tripRowView, int position);
    int getTripsRowsCount();
}
