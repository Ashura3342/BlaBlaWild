package fr.wildcodeschool.blablawild.search;

import android.os.Bundle;
import android.support.annotation.StringRes;

import java.text.ParseException;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public class ItinerarySearchPresenterImpl<V extends ItinerarySearchView>
        implements ItinerarySearchPresenter<V> {

    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void onSearchSend(String departure, String destination, String date) {
        Date tmp;
        try {
            tmp = view.stringAsDate(date);
            if (departure.isEmpty() || destination.isEmpty()) {
                onError(R.string.search_string_error);
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("itinerary", new ItineraryData(departure, destination, tmp));
                view.searchSend(bundle);
            }

        } catch (ParseException e) {
            onError(R.string.search_date_error);
        }
    }

    @Override
    public void onError(@StringRes int id) {
        view.showError(id);
    }
}
