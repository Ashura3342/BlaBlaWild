package fr.wildcodeschool.blablawild.search;

import java.text.ParseException;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.base.BasePresenter;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public class ItinerarySearchPresenterImpl<V extends ItinerarySearchView> extends BasePresenter<V>
        implements ItinerarySearchPresenter<V> {

    @Override
    public void onSearchSend(String departure, String destination, String date) {
        Date tmp;
        try {
            tmp = getView().stringAsDate(date);
            if (departure.isEmpty() || destination.isEmpty()) {
                onError(R.string.search_string_error);
            } else {
                getView().searchSend(new ItineraryData(departure, destination, tmp));
            }

        } catch (ParseException e) {
            onError(R.string.search_date_error);
        }
    }

    @Override
    public void onError(int id) {
        getView().showError(id);
    }
}
