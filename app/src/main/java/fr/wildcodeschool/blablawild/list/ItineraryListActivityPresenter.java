package fr.wildcodeschool.blablawild.list;

import android.os.Bundle;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.models.ItineraryModel;

public class ItineraryListActivityPresenter implements ItineraryListActivityContract.Presenter {

    ItineraryListActivityContract.View view;

    public ItineraryListActivityPresenter(ItineraryListActivityContract.View view, Bundle bundle) {
        this.view = view;
        onViewItinerary(bundle);
    }

    @Override
    public void onViewItinerary(Bundle bundle) {
        if (bundle.containsKey("itinerary")) {
            view.viewItinerary((ItineraryModel)bundle.getSerializable("itinerary"));
        } else {
            onError(R.string.search_string_error);
        }
    }

    @Override
    public void onError(int id) {
        view.showError(id);
    }
}
