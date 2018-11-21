package fr.wildcodeschool.blablawild.search;

import android.os.Bundle;
import android.support.annotation.StringRes;

import java.text.ParseException;
import java.util.Date;

import fr.wildcodeschool.blablawild.base.MvpView;

public interface ItinerarySearchView extends MvpView {
    void showError(@StringRes int id);
    void searchSend(Bundle bundle);
    Date stringAsDate(String date) throws ParseException;
}
