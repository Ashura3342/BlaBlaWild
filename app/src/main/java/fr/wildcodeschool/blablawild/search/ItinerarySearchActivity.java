package fr.wildcodeschool.blablawild.search;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.data.ItineraryData;
import fr.wildcodeschool.blablawild.list.ItineraryListActivity;

public class ItinerarySearchActivity extends AppCompatActivity
    implements ItinerarySearchView{

    private ItinerarySearchPresenter<ItinerarySearchView> presenter
            = new ItinerarySearchPresenterImpl<>();

    private EditText departure;
    private EditText destination;
    private EditText date;
    private Button searchSend;
    private Calendar calendar;
    private DateFormat sdf;


    public static Intent getStartIntent(Context context) {
        return  new Intent(context, ItinerarySearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        departure = findViewById(R.id.itinerary_search_departure_edit);
        destination = findViewById(R.id.itinerary_search_destination_edit);
        date = findViewById(R.id.itinerary_search_date_edit);
        searchSend = findViewById(R.id.itinerary_search_send_button);

        presenter.attach(this);

        calendar = Calendar.getInstance();
        sdf = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        try
        {
            if (!date.getHint().toString().isEmpty()) {
                Date tmp = stringAsDate(date.getHint().toString());
                date.setHint(sdf.format(tmp));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date.setOnClickListener(onEditDateListener(this));
        searchSend.setOnClickListener(onSearchSendListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener() {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                date.setText(sdf.format(calendar.getTime()));
            }
        };
    }

    private View.OnClickListener onEditDateListener(final Context context) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, onDateSetListener(),
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        };
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
    public Date stringAsDate(String date) throws ParseException {
        if (date.isEmpty())
            return null;
        return sdf.parse(date);
    }

    @Override
    public void searchSend(ItineraryData itineraryData) {
        Intent intent = ItineraryListActivity.getStartIntent(this, itineraryData);
        startActivity(intent);
    }

    @Override
    public void showError(int id) {
        Toast toast = Toast.makeText(this, id, Toast.LENGTH_SHORT);
        toast.show();
    }
}

