package com.nejracoric.earthquaketask.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nejracoric.earthquaketask.R;
import com.nejracoric.earthquaketask.databinding.ActivityMainBinding;
import com.nejracoric.earthquaketask.databinding.FragmentEarthquakeListBinding;

public class EarthquakeListFragment extends Fragment {

    private FragmentEarthquakeListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}