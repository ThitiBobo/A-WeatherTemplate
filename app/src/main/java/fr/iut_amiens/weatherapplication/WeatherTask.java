package fr.iut_amiens.weatherapplication;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;


public class WeatherTask extends AsyncTask {

    private WeatherManager mWeatherManager;
    private WeatherAdapter mWeatherAdapter;

    private List<String> mCityNames;

    private List<Double> mLatitudes;
    private List<Double> mLongitudes;

    public WeatherTask(WeatherAdapter weatherAdapter) {
        mWeatherAdapter = weatherAdapter;
        mWeatherManager = new WeatherManager();

        mCityNames = new ArrayList<String>();
        mLongitudes = new ArrayList<Double>();
        mLatitudes = new ArrayList<Double>();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        while (true) {

            while (!mCityNames.isEmpty()) {
                try {
                    WeatherResponse weather = mWeatherManager.findWeatherByCityName(
                            mCityNames.get(0));
                    this.publishProgress(weather);
                    mCityNames.remove(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            while ((!mLatitudes.isEmpty()) || (!mLongitudes.isEmpty())) {

                try {
                    WeatherResponse weather = mWeatherManager.findWeatherByGeographicCoordinates(
                            mLatitudes.get(0),
                            mLongitudes.get(0));

                    this.publishProgress(weather);
                    mLongitudes.remove(0);
                    mLongitudes.remove(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        mWeatherAdapter.add((WeatherResponse)values[0]);
    }

    public void findWeatherByCityName(String cityName) throws IllegalStateException{
        checkAsyncTask();
        mCityNames.add(cityName);
    }

    public void findWeatherByGeographicCoordinates(double latitude, double longitude) throws IllegalStateException{
        checkAsyncTask();
        mLatitudes.add(latitude);
        mLongitudes.add(longitude);

    }

    private void checkAsyncTask() throws IllegalStateException{
        if (this.getStatus() == Status.FINISHED)
            throw new IllegalStateException();
        if (this.getStatus() == Status.PENDING)
            this.execute();
    }

}
