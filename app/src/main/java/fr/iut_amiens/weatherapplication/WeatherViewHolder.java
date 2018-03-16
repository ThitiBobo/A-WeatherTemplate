package fr.iut_amiens.weatherapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

/**
 * Created by canard on 16/03/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    public WeatherViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(WeatherResponse weather){

    }
}
