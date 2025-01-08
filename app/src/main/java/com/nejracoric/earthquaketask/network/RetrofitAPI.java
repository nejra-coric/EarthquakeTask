package com.nejracoric.earthquaketask.network;

import com.nejracoric.earthquaketask.data.EarthquakeResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("query")
    Call<EarthquakeResponse> getEarthquakeData(
            @Query("format") String format,
            @Query("starttime") String startTime,
            @Query("endtime") String endTime
    );
}
