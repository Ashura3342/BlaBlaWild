package fr.wildcodeschool.blablawild.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.adapter.TripRecyclerAdapter;

public class ItineraryListActivity extends AppCompatActivity implements ItineraryListView{

    private static final String GET_EXTRA_DATA = "itinerary";

    private DateFormat sdf = SimpleDateFormat.getDateInstance(DateFormat.SHORT);

    public static Intent getStartIntent(Context context, ItineraryData data) {
        return data != null ? new Intent(context, ItineraryListActivity.class)
                .putExtra(GET_EXTRA_DATA, data) : null;
    }

    private ItineraryListPresenter<ItineraryListView> presenter
            = new ItineraryListPresenterImpl<>();

    private TripRecyclerAdapter tripRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        presenter.attach(this);

        RecyclerView tripListView = findViewById(R.id.itinerary_list_recyler_view);

        tripListView.setLayoutManager(new LinearLayoutManager(this));

        tripRecyclerAdapter = new TripRecyclerAdapter(presenter);
        tripListView.setAdapter(tripRecyclerAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra(GET_EXTRA_DATA))
            presenter.onViewItinerary((ItineraryData)intent.getParcelableExtra(GET_EXTRA_DATA));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void viewItinerary(ItineraryData itineraryData) {
        setTitle(String.format("%s>>%s",
                itineraryData.getDeparture(), itineraryData.getDestination()));
        String date = sdf.format(itineraryData.getDate());
        Toast.makeText(this, date, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void notifyInsertTripRow(int size) {
        tripRecyclerAdapter.notifyItemRangeInserted(0, size);
    }

    @Override
    public void showError(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT)
                .show();
    }
}
