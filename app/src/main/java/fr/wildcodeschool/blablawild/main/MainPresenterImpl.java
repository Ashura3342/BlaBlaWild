package fr.wildcodeschool.blablawild.main;

public class MainPresenterImpl<V extends MainView> implements MainPresenter<V> {

    V view;

    @Override
    public void onNavigateToSearchItineraty() {
        view.navigateToSearchItinerary();
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }
}
