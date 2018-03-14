package fr.iut_amiens.weatherapplication;

import android.app.Activity;
import android.os.Bundle;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;

public class MainActivity extends Activity {

    private WeatherManager weatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherManager = new WeatherManager();

        // Récupération des prévisions par nom de la ville :
        // ForecastResponse forecast = weatherManager.findForecastByCityName("Amiens");

        // Récupération des prévision par localistion :
        // ForecastResponse forecast = weatherManager.findForecastByGeographicCoordinates(49.8942, 2.2957);
    }
}
