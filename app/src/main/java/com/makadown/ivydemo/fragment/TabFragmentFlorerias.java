package com.makadown.ivydemo.fragment;

/**
 *  Process: com.makadown.ivydemo, PID: 2271
 java.lang.ClassCastException: android.support.v7.widget.SearchView cannot be cast to android.widget.SearchView
 at com.makadown.ivydemo.fragment.TabFragmentFlorerias.onCreateOptionsMenu(TabFragmentFlorerias.java:70)
 * */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;
//import android.widget.SearchView;


import com.makadown.ivydemo.R;

import java.util.ArrayList;
import java.util.List;


public class TabFragmentFlorerias extends Fragment implements SearchView.OnQueryTextListener {


    private RecyclerView recyclerview;
    private List<ItemModel> mFloreriaModel;
    private RVFloreriaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_fragment_florerias, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        ArrayList<ItemModel> locales = CatalogoHardcode.ObtenerFlorerias();
        mFloreriaModel = new ArrayList<>();

        for (ItemModel FloreriaCode : locales) {

            mFloreriaModel.add(new ItemModel(FloreriaCode.getName(), FloreriaCode.getisoCode()));
        }

        adapter = new RVFloreriaAdapter(mFloreriaModel);
        recyclerview.setAdapter(adapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener(){
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item){
                        // Do something when collapsed
                        adapter.setFilter(mFloreriaModel);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item){
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<ItemModel> filteredModelList = filter(mFloreriaModel, newText);
        adapter.setFilter(filteredModelList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<ItemModel> filter(List<ItemModel> models, String query) {
        query = query.toLowerCase();

        final List<ItemModel> filteredModelList = new ArrayList<>();
        for (ItemModel model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

}
