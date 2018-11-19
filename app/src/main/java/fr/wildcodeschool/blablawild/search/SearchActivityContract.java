package fr.wildcodeschool.blablawild.search;

import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.models.ItineraryModel;

public interface SearchActivityContract {
    interface Presenter {
        void onSearchSend(String departure, String destination, String date);
        void onError(@StringRes int id);
    }

    interface View {
        void showError(@StringRes int id);
        void searchSend(ItineraryModel itineraryModel);
    }
}
