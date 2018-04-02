package fr.iut_amiens.weatherapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.iut_amiens.weatherapplication.openweathermap.ForecastResponse;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

/**
 * Created by victo on 02/04/2018.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder {

    public CardView mCardView;

    public TextView mTextTown;
    public TextView mTextTemp;
    public TextView mTextWeather;

    public TextView mTextHumidity;
    public TextView mTextPressure;
    public TextView mTextSpeedWind;

    public ForecastViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(ForecastResponse weather){
        //mTextTown.setText(weather.getName());
        //mTextHumidity.setText(String.valueOf(weather.getMain().getTemp()));
    }
}
