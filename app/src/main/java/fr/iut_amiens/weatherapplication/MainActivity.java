package fr.iut_amiens.weatherapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;

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
        mWeatherTask = new WeatherTask((WeatherAdapter) mRecyclerView.getAdapter());

        mWeatherTask.execute();




        // Récupération de la météo actuelle :

        // WeatherResponse weather = weatherManager.findWeatherByCityName("Amiens");
        // WeatherResponse weather = weatherManager.findWeatherByGeographicCoordinates(49.8942, 2.2957);

        // documentation : https://openweathermap.org/current

        // Récupération des prévisions par nom de la ville :

        // ForecastResponse forecast = weatherManager.findForecastByCityName("Amiens");
        // ForecastResponse forecast = weatherManager.findForecastByGeographicCoordinates(49.8942, 2.2957);

        // documentation : https://openweathermap.org/forecast5
    }

    public void configureRecyclerView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.activity_main_recyclerview);

        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2)); très rigolo ^^ <3
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new WeatherAdapter(this,getLayoutInflater()));
    }
}
