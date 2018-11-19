package fr.wildcodeschool.blablawild.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;

public class ItineraryListActivity extends AppCompatActivity implements ItineraryListView{

    public static Intent getStartIntent(Context context) {
        return new Intent(context, ItineraryListActivity.class);
    }

    private ItineraryListPresenter<ItineraryListView> presenter
            = new ItineraryListPresenterImpl<ItineraryListView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);
        Intent intent = getIntent();
        presenter.attach(this);
        presenter.onViewItinerary(intent.getExtras());
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
    public void showError(int id) {
        finish();
    }
}
