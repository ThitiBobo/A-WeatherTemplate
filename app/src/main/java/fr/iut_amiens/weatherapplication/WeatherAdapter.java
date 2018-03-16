package fr.iut_amiens.weatherapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;


/**
 * Created by canard on 16/03/18.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<WeatherResponse> mWeatherResponses;

    public WeatherAdapter(Context context, LayoutInflater layoutInflater) {
        mContext = context;
        mLayoutInflater = layoutInflater;

    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        WeatherResponse weather = mWeatherResponses.get(position);
        holder.bind(weather);
    }

    @Override
    public int getItemCount() {
        if (mWeatherResponses != null)
            return mWeatherResponses.size();
        return 0;
    }

    public void add (){

    }
}
