package com.nejracoric.earthquaketask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nejracoric.earthquaketask.R;
import com.nejracoric.earthquaketask.data.Properties;

import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.ViewHolder> {

    private final List<Properties> earthquakeList;

    public EarthquakeAdapter(List<Properties> earthquakeList) {
        this.earthquakeList = earthquakeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.earthquake_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Properties earthquake = earthquakeList.get(position);
        holder.titleTextView.setText(earthquake.getTitle());
        holder.magnitudeTextView.setText(earthquake.getMag());
        holder.placeTextView.setText(earthquake.getPlace());
        holder.timeTextView.setText(earthquake.getTime());
        holder.typeTextView.setText(earthquake.getType());
    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }

    public void updateEarthquakeList(List<Properties> newEarthquakeList) {
        this.earthquakeList.clear();
        this.earthquakeList.addAll(newEarthquakeList);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView magnitudeTextView;
        TextView placeTextView;
        TextView timeTextView;
        TextView typeTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            magnitudeTextView = itemView.findViewById(R.id.mag);
            placeTextView = itemView.findViewById(R.id.location);
            timeTextView = itemView.findViewById(R.id.time);
            typeTextView = itemView.findViewById(R.id.type);
        }
    }
}
