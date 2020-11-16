package com.eijun.mvvmcovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.eijun.mvvmcovid.adapter.CovidDataAdapter;
import com.eijun.mvvmcovid.databinding.ActivityMainBinding;
import com.eijun.mvvmcovid.model.Covid;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        intialzeOnViews();
        getAllCovid();

        swipeRefreshLayout.setOnRefreshListener(this::getAllCovid);
    }

    private void intialzeOnViews() {
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.rv_view_covid);
    }

    private void getAllCovid() {
        swipeRefreshLayout.setRefreshing(true);
        mainViewModel.getAllCovid().observe(this, new Observer<List<Covid>>() {
            @Override
            public void onChanged(List<Covid> covids) {
                swipeRefreshLayout.setRefreshing(false);
                prepareRecyclerView(covids);
            }

            private void prepareRecyclerView(List<Covid> covids) {

                CovidDataAdapter covidDataAdapter = new CovidDataAdapter(covids);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(covidDataAdapter);
                covidDataAdapter.setCovidList((ArrayList<Covid>) covids);

            }
        });


    }
}