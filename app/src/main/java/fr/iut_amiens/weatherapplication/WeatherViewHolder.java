package fr.iut_amiens.weatherapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

/**
 * Created by canard on 16/03/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    public CardView mCardView;
    public TextView mTextTitle;
    public TextView mTextHumidity;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        mTextTitle = (TextView)itemView.findViewById(R.id.item_weather_text_town);
        mTextHumidity = (TextView) itemView.findViewById(R.id.item_weather_text_humidity);
    }

    public void bind(WeatherResponse weather){
        mTextTitle.setText(weather.getName());
        mTextHumidity.setText(String.valueOf(weather.getMain().getTemp()));
    }
}
