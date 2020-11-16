package com.eijun.mvvmcovid.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.mvvmcovid.R;
import com.eijun.mvvmcovid.databinding.CovidListItemBinding;
import com.eijun.mvvmcovid.model.Covid;

import java.util.ArrayList;
import java.util.List;

public class CovidDataAdapter extends RecyclerView.Adapter<CovidDataAdapter.CovidViewHolders> {

    private ArrayList<Covid> covid ;

    public CovidDataAdapter(List<Covid> covid) {

    }

    @NonNull
    @Override
    public CovidViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CovidListItemBinding covidListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.covid_list_item, parent, false) ;
        return new CovidViewHolders(covidListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolders holder, int position) {
        Covid c = this.covid.get(position);
        holder.covidListItemBinding.setCovid(c);

    }

    @Override
    public int getItemCount() {
        if (covid !=null) {
            return covid.size();
        }else {
            return  0 ;
        }
    }

    public void setCovidList(ArrayList<Covid> covid){
        this.covid = covid;
        notifyDataSetChanged();
    }

    public class CovidViewHolders extends RecyclerView.ViewHolder {
        private CovidListItemBinding covidListItemBinding;

        public CovidViewHolders(@NonNull CovidListItemBinding coronaListItemBinding) {
            super(coronaListItemBinding.getRoot());
            this.covidListItemBinding = coronaListItemBinding;
        }
    }
}
