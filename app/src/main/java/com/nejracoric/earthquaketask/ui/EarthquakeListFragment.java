package com.nejracoric.earthquaketask.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nejracoric.earthquaketask.adapter.EarthquakeAdapter;
import com.nejracoric.earthquaketask.data.Properties;
import com.nejracoric.earthquaketask.databinding.FragmentEarthquakeListBinding;
import com.nejracoric.earthquaketask.viewmodel.EarthquakeViewModel;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment {

    private FragmentEarthquakeListBinding binding;
    private EarthquakeAdapter adapter;
    private EarthquakeViewModel earthquakeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEarthquakeListBinding.inflate(inflater, container, false);

        initUI();
        earthquakeViewModel = new ViewModelProvider(this).get(EarthquakeViewModel.class);
        observeEarthquakeData();

        return binding.getRoot();
    }

    private void initUI() {
        adapter = new EarthquakeAdapter(new ArrayList<>());
        binding.earthquakeRecycler.setHasFixedSize(true);
        binding.earthquakeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.earthquakeRecycler.setAdapter(adapter);
    }

    private void observeEarthquakeData() {
        earthquakeViewModel.getEarthquakes().observe(getViewLifecycleOwner(), propertiesList -> {
            if (propertiesList != null) {
                adapter.updateEarthquakeList(propertiesList);
                adapter.notifyDataSetChanged();
            } else {
                Log.e("EarthquakeListFragment", "No earthquake data available.");
            }
        });
    }
}
