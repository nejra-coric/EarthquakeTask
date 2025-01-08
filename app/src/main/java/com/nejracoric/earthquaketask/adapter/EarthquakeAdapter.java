package com.nejracoric.earthquaketask.adapter;

import android.content.Intent;
import android.net.Uri;
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

        holder.itemView.setOnClickListener( v -> {
            String url = earthquake.getUrl();
            if (url != null && !url.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }

    public void updateEarthquakeList(List<Properties> newEarthquakeList) {
        this.earthquakeList.clear();
        this.earthquakeList.addAll(newEarthquakeList);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EarthquakeItemBinding binding;

        ViewHolder(@NonNull EarthquakeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
