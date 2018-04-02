package fr.iut_amiens.weatherapplication;

import android.support.design.widget.Snackbar;
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

    public TextView mTextTown;
    public TextView mTextTemp;
    public TextView mTextWeather;

    public TextView mTextHumidity;
    public TextView mTextPressure;
    public TextView mTextSpeedWind;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        mCardView = (CardView)itemView.findViewById(R.id.item_weather_cardview);
        //mTextTown = (TextView)itemView.findViewById(R.id.item_weather_text_town);
        //mTextHumidity = (TextView) itemView.findViewById(R.id.item_weather_text_humidity);

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "coucou", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void bind(WeatherResponse weather){
        //mTextTown.setText(weather.getName());
        //mTextHumidity.setText(String.valueOf(weather.getMain().getTemp()));
    }
}
