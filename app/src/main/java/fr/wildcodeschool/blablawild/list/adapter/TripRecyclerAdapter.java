package fr.wildcodeschool.blablawild.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.list.ItineraryListPresenter;
import fr.wildcodeschool.blablawild.list.ItineraryListView;

public class TripRecyclerAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private ItineraryListPresenter<ItineraryListView> presenter;

    public TripRecyclerAdapter(ItineraryListPresenter<ItineraryListView> presenter) {
        super();
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new TripViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_trip, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder tripViewHolder, int i) {
        presenter.onBindRepositoryRowViewAtPosition(tripViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getTripsRowsCount();
    }
}
