package fr.iut_amiens.weatherapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;

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
        mWeatherTask = new WeatherTask((WeatherAdapter) mRecyclerView.getAdapter());

        mWeatherTask.execute();

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
