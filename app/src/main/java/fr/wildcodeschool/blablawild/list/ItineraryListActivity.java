package fr.wildcodeschool.blablawild.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.models.ItineraryModel;
import fr.wildcodeschool.blablawild.search.ItinerarySearchActivity;

public class ItineraryListActivity extends AppCompatActivity implements ItineraryListActivityContract.View{

    public static Intent getStartIntent(Context context, ItineraryModel itineraryModel) {
        Intent intent = new Intent(context, ItineraryListActivity.class);
        intent.putExtra("itinerary", itineraryModel);
        return intent;
    }

    private ItineraryModel itineraryModel;
    private ItineraryListActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);
        Intent intent = getIntent();
        presenter = new ItineraryListActivityPresenter(this, intent);
    }

    @Override
    public void viewItinerary(ItineraryModel itineraryModel) {
        setTitle(String.format("%s>>%s",
                itineraryModel.getDeparture(), itineraryModel.getDestination()));
    }

    @Override
    public void showError(int id) {
        Intent intent = ItinerarySearchActivity.getStartIntent(this);
        startActivity(intent);
    }
}
