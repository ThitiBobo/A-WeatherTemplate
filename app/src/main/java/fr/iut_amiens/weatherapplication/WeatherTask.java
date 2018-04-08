package fr.iut_amiens.weatherapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherManager;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;


public class WeatherTask extends AsyncTask {

    private Context mContext;
    private WeatherManager mWeatherManager;
    private WeatherAdapter mWeatherAdapter;

    private String mCityNames;

    private double mLatitudes;
    private double mLongitudes;

    private static final String mMsgError = new StringBuilder()
            .append("Erreur lors de la réception des informations.")
            .append("\n")
            .append("GODZILLA a surement due manger la VILLE")
            .toString();

    private static final String mMsgErrorUnknow = "bah !!";

    public WeatherTask(Context context, WeatherAdapter weatherAdapter) {
        mContext = context;
        mWeatherAdapter = weatherAdapter;
        mWeatherManager = new WeatherManager();

        mCityNames = "";
        mLongitudes = 0;
        mLatitudes = 0;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        if (mCityNames != ""){
            try {
                WeatherResponse weather = mWeatherManager.findWeatherByCityName(
                        mCityNames);
                this.publishProgress(weather);
            } catch (IOException e) {
                this.publishProgress(e);
            }
        }else{
            try {
                WeatherResponse weather = mWeatherManager.findWeatherByGeographicCoordinates(
                        mLatitudes,
                        mLongitudes);
                this.publishProgress(weather);
            } catch (IOException e) {
                this.publishProgress(e);
            }
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        if (values[0] instanceof WeatherResponse)
            mWeatherAdapter.add((WeatherResponse)values[0]);
        else if (values[0] instanceof IOException)
            Toast.makeText(mContext, mMsgError, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(mContext, mMsgErrorUnknow, Toast.LENGTH_LONG).show();
    }

    public void findWeatherByCityName(String cityName) throws IllegalStateException{
        mCityNames = cityName;
    }

    public void findWeatherByGeographicCoordinates(double latitude, double longitude) throws IllegalStateException{
        mLatitudes = latitude;
        mLongitudes= longitude;

    }

}
