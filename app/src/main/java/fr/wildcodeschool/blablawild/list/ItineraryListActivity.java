package fr.wildcodeschool.blablawild.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        presenter.attach(this);

        tripListView = findViewById(R.id.itinerary_list_recyler_view);

        tripListView.setLayoutManager(new LinearLayoutManager(this));

        tripRecyclerAdapter = new TripRecyclerAdapter(presenter);
        tripListView.setAdapter(tripRecyclerAdapter);

        Intent intent = getIntent();
        presenter.onViewItinerary((ItineraryData)intent.getSerializableExtra("itinerary"));
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
    public void notifyInsertTripRow(int size) {
        tripRecyclerAdapter.notifyItemRangeInserted(0, size);
    }

    @Override
    public void showError(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT)
                .show();
    }
}
