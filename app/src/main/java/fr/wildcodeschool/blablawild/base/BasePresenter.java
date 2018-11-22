package fr.wildcodeschool.blablawild.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    public V getView() {
        return view;
    }
}
