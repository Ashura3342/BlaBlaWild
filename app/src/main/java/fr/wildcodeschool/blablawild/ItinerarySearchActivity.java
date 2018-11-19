package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ItinerarySearchHolder {
    private Button btSearchSend;
    private EditText editDeparture;
    private EditText editDestination;
    private EditText editDate;

    public ItinerarySearchHolder(AppCompatActivity activity) {
        btSearchSend = activity.findViewById(R.id.bt_search_send);
        editDeparture = activity.findViewById(R.id.search_departure_edit);
        editDestination = activity.findViewById(R.id.search_destination_edit);
        editDate = activity.findViewById(R.id.search_date_edit);
    }

    public Button getBtSearchSend() {
        return btSearchSend;
    }

    public EditText getEditDeparture() {
        return editDeparture;
    }

    public EditText getEditDestination() {
        return editDestination;
    }

    public EditText getEditDate() {
        return editDate;
    }

    public String getDeparture() {
        return editDeparture.getText().toString();
    }

    public String getDestination() {
        return editDestination.getText().toString();
    }

    public String getDate() { return editDate.getText().toString(); }

    public DateFormat getDateFormat() {
        return SimpleDateFormat.getDateInstance(DateFormat.SHORT);
    }

    public Date getDateAsDate() {
        if (getDate().isEmpty())
            return null;
        try {
            return getDateFormat().parse(getDate());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class ItinerarySearchActivity extends AppCompatActivity {

    private ItinerarySearchHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        holder = new ItinerarySearchHolder(this);
        holder.getBtSearchSend().setOnClickListener(onClickBtSearchSend);
        holder.getEditDate().setHint(holder.getDateFormat().format(new Date()));
    }

    private Intent newIntent() {
        return new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class)
                .putExtra("itinerary", new Itinerary(holder.getDeparture(),
                        holder.getDestination(), holder.getDateAsDate()));
    }

    private void showError() {
        Toast.makeText(this, getString(R.string.search_error), Toast.LENGTH_SHORT)
                .show();
    }

    private boolean searchIsValidate() {
        return !holder.getDeparture().isEmpty() &&
                !holder.getDestination().isEmpty() &&
                holder.getDateAsDate() != null;
    }

    private View.OnClickListener onClickBtSearchSend = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!searchIsValidate())
                showError();
            else
                startActivity(newIntent());
        }
    };
}
