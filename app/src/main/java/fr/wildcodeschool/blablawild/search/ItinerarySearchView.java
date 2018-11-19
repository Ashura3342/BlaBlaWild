package fr.wildcodeschool.blablawild.search;

import android.os.Bundle;
import android.support.annotation.StringRes;

import fr.wildcodeschool.blablawild.base.MvpView;

public interface ItinerarySearchView extends MvpView {
    void showError(@StringRes int id);
    void searchSend(Bundle bundle);
}
