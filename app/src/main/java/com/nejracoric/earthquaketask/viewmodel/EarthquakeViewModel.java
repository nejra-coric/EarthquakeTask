package com.nejracoric.earthquaketask.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nejracoric.earthquaketask.data.Properties;

import java.util.List;

public class EarthquakeViewModel extends ViewModel {

    private EarthquakeRepository earthquakeRepository;
    private MutableLiveData<List<Properties>> mutableLiveData;

    public EarthquakeViewModel(){
        earthquakeRepository = new EarthquakeRepository();
    }

    public LiveData<List<Properties>> getEarthquakes() {
        if(mutableLiveData==null){
            mutableLiveData = earthquakeRepository.requestEarthquakes();
        }
        return mutableLiveData;
    }

}