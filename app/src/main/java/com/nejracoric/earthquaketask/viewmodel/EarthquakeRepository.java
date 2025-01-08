package com.nejracoric.earthquaketask.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.nejracoric.earthquaketask.data.EarthquakeResponse;
import com.nejracoric.earthquaketask.data.Feature;
import com.nejracoric.earthquaketask.data.Properties;
import com.nejracoric.earthquaketask.network.RetrofitAPI;
import com.nejracoric.earthquaketask.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeRepository {

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<List<Properties>> requestEarthquakes() {
        final MutableLiveData<List<Properties>> mutableLiveData = new MutableLiveData<>();

        RetrofitAPI api = RetrofitClient.getInstance().create(RetrofitAPI.class);
        Call<EarthquakeResponse> call = api.getEarthquakeData("geojson", "2025-01-01", "2025-01-02");

        call.enqueue(new Callback<EarthquakeResponse>() {
            @Override
            public void onResponse(@NonNull Call<EarthquakeResponse> call, @NonNull Response<EarthquakeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Properties> earthquakeList = new ArrayList<>();
                    for (Feature feature : response.body().getFeatures()) {
                        earthquakeList.add(feature.getProperties());
                    }
                    mutableLiveData.setValue(earthquakeList);
                } else {
                    Log.e(TAG, "Response unsuccessful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<EarthquakeResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "API call failed", t);
            }
        });

        return mutableLiveData;
    }

}