package fr.wildcodeschool.blablawild.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.list.ItineraryListActivity;

public class ItinerarySearchActivity extends AppCompatActivity
    implements ItinerarySearchView{

    private ItinerarySearchPresenter<ItinerarySearchView> presenter
            = new ItinerarySearchPresenterImpl<ItinerarySearchView>();

    private EditText departure;
    private EditText destination;
    private EditText date;
    private Button searchSend;


    public static Intent getStartIntent(Context context) {
        return  new Intent(context, ItinerarySearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        departure = findViewById(R.id.search_departure_edit);
        destination = findViewById(R.id.search_destination_edit);
        date = findViewById(R.id.search_date_edit);
        searchSend = findViewById(R.id.bt_search_send);

        presenter.attach(this);

        searchSend.setOnClickListener(onSearchSendListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    private View.OnClickListener onSearchSendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onSearchSend(departure.getText().toString(),
                    destination.getText().toString(),
                    date.getText().toString());
        }
    };


    @Override
    public void searchSend(Bundle bundle) {
        Intent intent = ItineraryListActivity.getStartIntent(this);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showError(int id) {
        Toast toast = Toast.makeText(this, id, Toast.LENGTH_SHORT);
        toast.show();
    }
}

