package fr.wildcodeschool.blablawild.list;

import android.os.Bundle;
import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.models.ItineraryModel;

public interface ItineraryListActivityContract {
    interface Presenter {
        void onViewItinerary(Bundle bundle);
        void onError(@StringRes int id);
    }
    interface  View {
        void viewItinerary(ItineraryModel itineraryModel);
        void showError(@StringRes int id);
    }
}
