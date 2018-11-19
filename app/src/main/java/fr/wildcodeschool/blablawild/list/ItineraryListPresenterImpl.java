package fr.wildcodeschool.blablawild.list;

import android.os.Bundle;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public class ItineraryListPresenterImpl<V extends ItineraryListView> implements ItineraryListPresenter<V> {

    V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public void onViewItinerary(Bundle bundle) {
        if (bundle.containsKey("itinerary")) {
            view.viewItinerary((ItineraryData)bundle.getSerializable("itinerary"));
        } else {
            onError(R.string.search_string_error);
        }
    }

    @Override
    public void onError(int id) {
        view.showError(id);
    }
}
