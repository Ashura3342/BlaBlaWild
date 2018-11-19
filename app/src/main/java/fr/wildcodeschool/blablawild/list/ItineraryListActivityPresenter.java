package fr.wildcodeschool.blablawild.list;

import android.content.Intent;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.models.ItineraryModel;

public class ItineraryListActivityPresenter implements ItineraryListActivityContract.Presenter {

    ItineraryListActivityContract.View view;

    public ItineraryListActivityPresenter(ItineraryListActivityContract.View view, Intent intent) {
        this.view = view;
        onViewItinerary(intent);
    }

    @Override
    public void onViewItinerary(Intent intent) {
        if (intent.hasExtra("itinerary")) {
            view.viewItinerary((ItineraryModel)intent.getSerializableExtra("itinerary"));
        } else {
            onError(R.string.search_string_error);
        }
    }

    @Override
    public void onError(int id) {
        view.showError(id);
    }
}
