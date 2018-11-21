package fr.wildcodeschool.blablawild.search;


import java.text.ParseException;
import java.util.Date;

import fr.wildcodeschool.blablawild.base.MvpView;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public interface ItinerarySearchView extends MvpView {
    void showError(int id);
    void searchSend(ItineraryData itineraryData);
    Date stringAsDate(String date) throws ParseException;
}
