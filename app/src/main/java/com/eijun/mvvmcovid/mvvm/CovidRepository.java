package com.eijun.mvvmcovid.mvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.eijun.mvvmcovid.model.Covid;
import com.eijun.mvvmcovid.network.ApiClient;
import com.eijun.mvvmcovid.network.CovidDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidRepository {
    private String TAG = "CovidRepository" ;
    private MutableLiveData<List<Covid>> mutableLiveData = new MutableLiveData<>();

    public CovidRepository() {

    }

    public MutableLiveData<List<Covid>> getMutableLiveData() {
        final CovidDataService covidDataService = ApiClient.getService();
        Call<List<Covid>> call = covidDataService.getCovid();
        call.enqueue(new Callback<List<Covid>>() {
            @Override
            public void onResponse(Call<List<Covid>> call, Response<List<Covid>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Covid>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getCause());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.toString());

            }
        });

        return mutableLiveData;
    }
}
