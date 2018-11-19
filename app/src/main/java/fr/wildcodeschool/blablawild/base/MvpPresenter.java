package fr.wildcodeschool.blablawild.base;

public interface MvpPresenter<V extends MvpView> {
    void attach(V view);
    void detach();
}
