package fr.wildcodeschool.blablawild.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.adapter.TripRecyclerAdapter;

public class ItineraryListActivity extends AppCompatActivity implements ItineraryListView{

    public static Intent getStartIntent(Context context) {
        return new Intent(context, ItineraryListActivity.class);
    }

    private ItineraryListPresenter<ItineraryListView> presenter
            = new ItineraryListPresenterImpl<>();

    private TripRecyclerAdapter tripRecyclerAdapter;

    private RecyclerView tripListView;
    private DateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        presenter.attach(this);

        tripListView = findViewById(R.id.itinerary_list_recyler_view);

        sdf = SimpleDateFormat.getDateInstance(DateFormat.SHORT);

        tripListView.setLayoutManager(new LinearLayoutManager(this));

        tripRecyclerAdapter = new TripRecyclerAdapter(presenter);
        tripListView.setAdapter(tripRecyclerAdapter);

        Intent intent = getIntent();
        presenter.onViewItinerary((ItineraryData)intent.getSerializableExtra("itinerary"));
    }

    @Override
    public Date stringAsDate(String date) throws ParseException {
        if (date.isEmpty())
            return null;
        return sdf.parse(date);
    }

    @Override
    public String dateAsString(Date date) {
        return sdf.format(date);
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
    }

    @Override
    public void notifyRangeInsertTripRow(int min, int max) {
        tripRecyclerAdapter.notifyItemRangeInserted(min, max);
    }

    @Override
    public void showError(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT)
                .show();
    }
}
