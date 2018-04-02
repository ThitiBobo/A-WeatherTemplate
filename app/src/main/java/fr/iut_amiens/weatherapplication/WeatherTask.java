package fr.iut_amiens.weatherapplication;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.io.IOException;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;


public class WeatherTask extends AsyncTask {

    private WeatherManager mWeatherManager;
    private WeatherAdapter mWeatherAdapter;

    public WeatherTask(WeatherAdapter weatherAdapter) {
        mWeatherAdapter = weatherAdapter;
        mWeatherManager = new WeatherManager();
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        try {
            WeatherResponse weather = mWeatherManager.findWeatherByCityName("New York");
            this.publishProgress(weather);

            weather = mWeatherManager.findWeatherByCityName("Bordeaux");
            this.publishProgress(weather);

            weather = mWeatherManager.findWeatherByCityName("Paris");
            this.publishProgress(weather);

            weather = mWeatherManager.findWeatherByCityName("Riga");
            this.publishProgress(weather);

            weather = mWeatherManager.findWeatherByCityName("Marseille");
            this.publishProgress(weather);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }


    @Override
    protected void onProgressUpdate(Object[] values) {
        mWeatherAdapter.add((WeatherResponse)values[0]);
    }

}
