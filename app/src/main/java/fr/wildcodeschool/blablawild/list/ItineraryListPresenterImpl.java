package fr.wildcodeschool.blablawild.list;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public class ItineraryListPresenterImpl<V extends ItineraryListView>
        implements ItineraryListPresenter<V> {

    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public void onViewItinerary(ItineraryData itineraryData) {
        if (itineraryData != null) {
            view.viewItinerary(itineraryData);
        } else {
            onError(R.string.search_string_error);
        }
    }

    @Override
    public void onError(int id) {
        view.showError(id);
    }
}
