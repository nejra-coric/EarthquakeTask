package com.nejracoric.earthquaketask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nejracoric.earthquaketask.databinding.EarthquakeItemBinding;
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
        // Inflate the view using ViewBinding
        EarthquakeItemBinding binding = EarthquakeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Properties earthquake = earthquakeList.get(position);
        holder.binding.title.setText(earthquake.getTitle());
        holder.binding.mag.setText(earthquake.getMag());
        holder.binding.location.setText(earthquake.getPlace());
        holder.binding.time.setText(earthquake.getTime());
        holder.binding.type.setText(earthquake.getType());
    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }

    public void updateEarthquakeList(List<Properties> newEarthquakeList) {
        this.earthquakeList.clear();
        this.earthquakeList.addAll(newEarthquakeList);
        notifyDataSetChanged(); // Ensure the adapter is notified of data changes
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // Use ViewBinding to access views
        EarthquakeItemBinding binding;

        ViewHolder(@NonNull EarthquakeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
