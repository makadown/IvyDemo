package com.makadown.ivydemo.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makadown.ivydemo.R;

import java.util.ArrayList;
import java.util.List;

public class RVFloreriaAdapter extends RecyclerView.Adapter<FloreriaViewHolder> {

    private List<ItemModel> mFloreriaModel;

    public RVFloreriaAdapter(List<ItemModel> mFloreriaModel ) {
        this.mFloreriaModel = mFloreriaModel;

    }

    @Override
    public void onBindViewHolder(FloreriaViewHolder itemViewHolder, int i) {
        final ItemModel floreriamodel = mFloreriaModel.get(i);
        itemViewHolder.bind(floreriamodel);


    }

    @Override
    public FloreriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_floreria_row, viewGroup, false);
        return new FloreriaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mFloreriaModel.size();
    }

    public void setFilter(List<ItemModel> floreriaModels ) {
        mFloreriaModel = new ArrayList<>();
        mFloreriaModel.addAll(floreriaModels);
        notifyDataSetChanged();
    }

}