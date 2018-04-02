package fr.iut_amiens.weatherapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
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
        mWeatherResponses = new ArrayList<WeatherResponse>();

    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_weather,parent,false);
        return new WeatherViewHolder(mContext,itemView);

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

    public void add (WeatherResponse weatherResponse){
        Log.v("dd",weatherResponse.toString());
        mWeatherResponses.add(weatherResponse);
        notifyDataSetChanged();

    }
}
