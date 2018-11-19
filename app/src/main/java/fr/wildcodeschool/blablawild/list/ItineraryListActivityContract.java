package fr.wildcodeschool.blablawild.list;

import android.content.Intent;
import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.models.ItineraryModel;

public interface ItineraryListActivityContract {
    interface Presenter {
        void onViewItinerary(Intent intent);
        void onError(@StringRes int id);
    }
    interface  View {
        void viewItinerary(ItineraryModel itineraryModel);
        void showError(@StringRes int id);
    }
}
