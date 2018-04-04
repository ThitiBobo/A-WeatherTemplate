package fr.iut_amiens.weatherapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WeatherTask mWeatherTask;
    //DAO ?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureRecyclerView();
        configureFloatingActionButton();
        configureToolbar();
        mWeatherTask = new WeatherTask((WeatherAdapter) mRecyclerView.getAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 - Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_reload:{
                Log.v("1","cc");
                reload();
                return true;
            }
            case R.id.menu_add:{
                Log.v("2","cc");
                add();
                return true;
            }

            default:
                Log.v("3","cc");
                return super.onOptionsItemSelected(item);
        }
    }

    public void configureRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.activity_main_recyclerview);

        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2)); très rigolo ^^ <3
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new WeatherAdapter(this,getLayoutInflater()));
    }

    public void configureFloatingActionButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
    }

    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void add(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Créer un nouveau fichier");
        builder.setMessage("Saisir l nom du fichier");
        builder.setView(getLayoutInflater().inflate(R.layout.dialog_add,null));

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog dialog = (AlertDialog) dialogInterface;
                EditText dialogAddText = dialog.findViewById(R.id.dialog_add_editext_town);
                mWeatherTask.findWeatherByCityName(dialogAddText.getText().toString());
            }
        });

        builder.setNegativeButton("annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }

    private void reload(){
        Log.v("","cc");
        WeatherAdapter adapter = (WeatherAdapter)mRecyclerView.getAdapter();
        List<WeatherResponse> copy = adapter.getWeatherResponses();
        adapter.clearWeatherReponses();
        //copy.forEach((e)->mWeatherTask.findWeatherByCityName(e.getName());
        /*for(WeatherResponse e:copy){
            mWeatherTask.findWeatherByCityName(e.getName());
        }*/
    }
}
