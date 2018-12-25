package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.weather.gson.Forecast;

import java.util.List;

/**
 * Created by Meo on 2018/12/23.
 */

public class Adapter extends ArrayAdapter<Forecast> {
    private int resourceId;
    private Context context;

    public Adapter(Context context, int textViewResourceId, List<Forecast> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Forecast forecast = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        View view = LayoutInflater.from(context).inflate(resourceId, null);
        TextView dateText = (TextView) view.findViewById(R.id.date_text);
        TextView infoText = (TextView) view.findViewById(R.id.info_text);
        TextView maxText = (TextView) view.findViewById(R.id.max_text);
        TextView minText = (TextView) view.findViewById(R.id.min_text);
        dateText.setText(forecast.date);
        infoText.setText(forecast.more.info);
        maxText.setText(forecast.temperature.max);
        minText.setText(forecast.temperature.min);
        return view;
    }
}
