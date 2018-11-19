package fr.wildcodeschool.blablawild.search;

import android.os.Bundle;
import android.support.annotation.StringRes;

public interface SearchActivityContract {
    interface Presenter {
        void onSearchSend(String departure, String destination, String date);
        void onError(@StringRes int id);
    }

    interface View {
        void showError(@StringRes int id);
        void searchSend(Bundle bundle);
    }
}
