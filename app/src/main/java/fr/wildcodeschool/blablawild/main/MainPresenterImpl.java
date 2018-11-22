package fr.wildcodeschool.blablawild.main;

import fr.wildcodeschool.blablawild.base.BasePresenter;

public class MainPresenterImpl<V extends MainView> extends BasePresenter<V>
        implements MainPresenter<V> {

    @Override
    public void onNavigateToSearchItinerary() {
        getView().navigateToSearchItinerary();
    }
}
