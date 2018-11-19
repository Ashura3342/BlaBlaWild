package fr.wildcodeschool.blablawild.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import fr.wildcodeschool.blablawild.R;
import fr.wildcodeschool.blablawild.search.ItinerarySearchActivity;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private Button btSearchItinerary;
    private MainActivityContract.Presenter presenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btSearchItinerary = findViewById(R.id.bt_main_search);

        presenter = new MainActivityPresenter(this);

        btSearchItinerary.setOnClickListener(onSearchItineraryListener);
    }

    private View.OnClickListener onSearchItineraryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.onSearchLaunch();
        }
    };

    @Override
    public void searchLaunch() {
        Intent startIntent = ItinerarySearchActivity.getStartIntent(this);
        startActivity(startIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
