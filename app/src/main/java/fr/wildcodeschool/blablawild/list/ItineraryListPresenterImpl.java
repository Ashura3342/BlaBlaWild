package fr.wildcodeschool.blablawild.list;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.adapter.TripRowView;
import fr.wildcodeschool.blablawild.models.TripModel;

public class ItineraryListPresenterImpl<V extends ItineraryListView>
        implements ItineraryListPresenter<V> {

    private V view;
    private List<TripModel> results = new ArrayList<>();

    private void loadData() {
        try {
            results.add(new TripModel("Eric", "Cartman", view.stringAsDate("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", view.stringAsDate("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski",view.stringAsDate("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", view.stringAsDate("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", view.stringAsDate("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            view.notifyInsertTripRow(results.size());
        }
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public void onViewItinerary(ItineraryData itineraryData) {
        if (itineraryData != null) {
            loadData();
            view.viewItinerary(itineraryData);
        } else {
            onError(R.string.no_itinerary_found);
        }
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(TripRowView tripRowView, int position) {
        TripModel trip = results.get(position);
        tripRowView.setDate(view.dateAsString(trip.getDate()));
        tripRowView.setFirstName(trip.getFirstName());
        tripRowView.setLastName(trip.getLastName());
        tripRowView.setPrice(trip.getPrice());
    }

    @Override
    public int getTripsRowsCount() {
        return results.size();
    }

    @Override
    public void onError(int id) {
        view.showError(id);
    }
}
