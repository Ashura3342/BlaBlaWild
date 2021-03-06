package fr.wildcodeschool.blablawild.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.base.BasePresenter;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.adapter.TripRowView;
import fr.wildcodeschool.blablawild.models.TripModel;

public class ItineraryListPresenterImpl<V extends ItineraryListView> extends BasePresenter<V>
        implements ItineraryListPresenter<V> {

    private List<TripModel> results = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY-HH:mm", Locale.FRANCE);

    private void loadData() {

        try {
            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            getView().notifyInsertTripRow(results.size());
        }
    }

    @Override
    public void onViewItinerary(ItineraryData itineraryData) {
        if (itineraryData != null) {
            loadData();
            getView().viewItinerary(itineraryData);
        } else {
            onError(R.string.no_itinerary_found);
        }
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(TripRowView tripRowView, int position) {
        TripModel trip = results.get(position);
        tripRowView.setDate(trip.getDate());
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
        getView().showError(id);
    }
}
