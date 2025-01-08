package com.nejracoric.earthquaketask.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nejracoric.earthquaketask.adapter.EarthquakeAdapter;
import com.nejracoric.earthquaketask.data.EarthquakeResponse;
import com.nejracoric.earthquaketask.data.Feature;
import com.nejracoric.earthquaketask.data.Properties;
import com.nejracoric.earthquaketask.databinding.FragmentEarthquakeListBinding;
import com.nejracoric.earthquaketask.network.RetrofitAPI;
import com.nejracoric.earthquaketask.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeListFragment extends Fragment {

    private FragmentEarthquakeListBinding binding;
    private EarthquakeAdapter adapter;
    private List<Properties> earthquakeList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEarthquakeListBinding.inflate(inflater, container, false);

        adapter = new EarthquakeAdapter(earthquakeList);
        binding.earthquakeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.earthquakeRecycler.setAdapter(adapter);

        fetchEarthquakeData();

        return binding.getRoot();
    }

    private void fetchEarthquakeData() {
        RetrofitAPI api = RetrofitClient.getInstance().create(RetrofitAPI.class);
        Call<EarthquakeResponse> call = api.getEarthquakeData("geojson", "2025-01-01", "2025-01-02");

        call.enqueue(new Callback<EarthquakeResponse>() {
            @Override
            public void onResponse(@NonNull Call<EarthquakeResponse> call, @NonNull Response<EarthquakeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (Feature feature : response.body().getFeatures()) {
                        earthquakeList.add(feature.getProperties());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("EarthquakeListFragment", "Response unsuccessful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<EarthquakeResponse> call, @NonNull Throwable t) {
                Log.e("EarthquakeListFragment", "API call failed", t);
            }
        });
    }
}
