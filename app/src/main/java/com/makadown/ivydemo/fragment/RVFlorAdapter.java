package com.makadown.ivydemo.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makadown.ivydemo.R;

import java.util.ArrayList;
import java.util.List;

public class RVFlorAdapter extends RecyclerView.Adapter<FlorViewHolder> {


    private List<ItemModel> mFlorModel;

    public RVFlorAdapter(  List<ItemModel> mFlorModel) {

        this.mFlorModel = mFlorModel;
    }

    @Override
    public void onBindViewHolder(FlorViewHolder itemViewHolder, int i) {


        final ItemModel flormodel = mFlorModel.get(i);
        itemViewHolder.bind(flormodel);
    }

    @Override
    public FlorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_flor_row, viewGroup, false);
        return new FlorViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mFlorModel.size();
    }

    public void setFilter(  List<ItemModel> florModels) {

        mFlorModel = new ArrayList<>();
        mFlorModel.addAll(florModels);
        notifyDataSetChanged();
    }

}