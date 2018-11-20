package fr.wildcodeschool.blablawild.main;

import fr.wildcodeschool.blablawild.base.MvpPresenter;

public interface MainPresenter<T extends MainView> extends MvpPresenter<T> {
    void onNavigateToSearchItinerary();
}
