package fr.wildcodeschool.blablawild.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.wildcodeschool.blablawild.R;

public class TripViewHolder extends RecyclerView.ViewHolder implements TripRowView {

    private TextView dateView;
    private TextView priceView;
    private TextView firstNameView;
    private TextView lastNameView;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        dateView = itemView.findViewById(R.id.row_trip_date);
        priceView = itemView.findViewById(R.id.row_trip_price_text);
        firstNameView = itemView.findViewById(R.id.row_trip_first_name_text);
        lastNameView = itemView.findViewById(R.id.row_trip_last_name_text);
    }

    @Override
    public void setDate(String date) {
        dateView.setText(date);
    }

    @Override
    public void setPrice(int price) {
        priceView.setText(String.format("$%s", price));
    }

    @Override
    public void setFirstName(String firstName) {
        firstNameView.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        lastNameView.setText(lastName);
    }
}