package com.eijun.mvvmcovid.network;

import com.eijun.mvvmcovid.model.Covid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidDataService {

    @GET("indonesia/provinsi/")
    Call<List<Covid>> getCovid();
}
