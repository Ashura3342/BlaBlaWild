package fr.wildcodeschool.blablawild.search;

import android.os.Bundle;
import android.support.annotation.StringRes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.models.ItineraryModel;

public class SearchActivityPresenter implements SearchActivityContract.Presenter {

    private SearchActivityContract.View view;

    public SearchActivityPresenter(SearchActivityContract.View view) {
        this.view = view;
    }

    private Date stringAsDate(String date) throws ParseException {
        if (date.isEmpty()) {
            return null;
        } else {
            DateFormat sdf = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
            return sdf.parse(date);
        }
    }

    @Override
    public void onSearchSend(String departure, String destination, String date) {
        Date tmp;
        try {
            tmp = stringAsDate(date);
            if (departure.isEmpty() || destination.isEmpty()) {
                onError(R.string.search_string_error);
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("itinerary", new ItineraryModel(departure, destination, tmp));
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
