package fr.wildcodeschool.blablawild.main;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onSearchLaunch() {
        view.searchLaunch();
    }
}
