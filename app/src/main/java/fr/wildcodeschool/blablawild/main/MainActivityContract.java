package fr.wildcodeschool.blablawild.main;

public interface MainActivityContract {
    interface Presenter {
        void onSearchLaunch();
    }

    interface View {
        void searchLaunch();
    }
}
