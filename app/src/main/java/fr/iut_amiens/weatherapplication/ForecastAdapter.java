package fr.iut_amiens.weatherapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.iut_amiens.weatherapplication.openweathermap.ForecastResponse;
import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

/**
 * Created by victo on 02/04/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder>   {

    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<ForecastResponse> mForecastResponses;

    public ForecastAdapter(Context context, LayoutInflater layoutInflater) {
        mContext = context;
        mLayoutInflater = layoutInflater;
        mForecastResponses = new ArrayList<ForecastResponse>();

    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_weather,parent,false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        ForecastResponse forecast = mForecastResponses.get(position);
        holder.bind(forecast);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
