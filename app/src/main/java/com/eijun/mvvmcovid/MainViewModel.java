package com.eijun.mvvmcovid;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.eijun.mvvmcovid.model.Covid;
import com.eijun.mvvmcovid.mvvm.CovidRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private CovidRepository covidRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        covidRepository = new CovidRepository();
    }

    public LiveData<List<Covid>> getAllCovid() {
        return covidRepository.getMutableLiveData();
    }
}
