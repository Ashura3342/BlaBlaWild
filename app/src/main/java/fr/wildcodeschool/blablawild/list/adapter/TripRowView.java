package fr.wildcodeschool.blablawild.list.adapter;

import fr.wildcodeschool.blablawild.base.MvpView;

public interface TripRowView extends MvpView {
    void setDate(String date);
    void setPrice(int price);
    void setFirstName(String firstName);
    void setLastName(String lastName);
}
