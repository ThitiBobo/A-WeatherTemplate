package fr.iut_amiens.weatherapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.iut_amiens.weatherapplication.openweathermap.WeatherResponse;

/**
 * Created by canard on 16/03/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private CardView mCardView;

    private TextView mTextTown;
    private TextView mTextTemp;
    private TextView mTextWeather;

    private ImageView mImageWeather;
    private ImageView mButtunClear;


    public ImageView getImageWeather() {
        return mImageWeather;
    }

    public WeatherViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;

        mCardView = (CardView)itemView.findViewById(R.id.item_weather_cardview);
        mTextTown = (TextView)itemView.findViewById(R.id.item_weather_text_town);
        mTextTemp = (TextView)itemView.findViewById(R.id.item_weather_text_temp);
        mTextWeather = (TextView)itemView.findViewById(R.id.item_weather_text_weather);

        mImageWeather = (ImageView)itemView.findViewById(R.id.item_weather_image_weather);
        mButtunClear = (ImageView)itemView.findViewById(R.id.item_weather_image_clear);

        mButtunClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "PAN", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoWeatherActiviy = new Intent(mContext, InfoWeatherActivity.class);
                infoWeatherActiviy.putExtra("NameTown",String.valueOf(mTextTown.getText()));
                mContext.startActivity(infoWeatherActiviy);
            }
        });


    }

    public void bind(WeatherResponse weather){
        mTextWeather.setText(weather.getWeather().get(0).getMain());
        mTextTown.setText(weather.getName() + ", " + weather.getSys().getCountry());
        mTextTemp.setText(String.valueOf(weather.getMain().getTemp()) + "°C");
        configureWeatherIcon(weather.getWeather().get(0).getId());
    }

    private void configureWeatherIcon(int id) {
        if (id >= 200 && id < 300) {
            mImageWeather.setImageResource(R.drawable.ic_wi_storm_showers);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherStorm));


        } else if (id >= 300 && id < 600) {
            mImageWeather.setImageResource(R.drawable.ic_wi_rain);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherSnow));
        } else if (id >= 600 && id < 700) {
            mImageWeather.setImageResource(R.drawable.ic_wi_snow);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherSnow));
        } else if (id >= 700 && id < 800) {
            mImageWeather.setImageResource(R.drawable.ic_wi_cloudy_gusts);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherStorm));
        } else if (id == 800) {
            mImageWeather.setImageResource(R.drawable.ic_wi_day_sunny);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherClear));
        } else if (id == 801) {
            mImageWeather.setImageResource(R.drawable.ic_wi_day_cloudy);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherClear));
        } else if (id == 802) {
            mImageWeather.setImageResource(R.drawable.ic_wi_cloud);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherCloud));
        } else if (id == 803 || id == 804){
            mImageWeather.setImageResource(R.drawable.ic_wi_cloudy);
            mCardView.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.colorWeatherCloudy));
        }


    }
}
