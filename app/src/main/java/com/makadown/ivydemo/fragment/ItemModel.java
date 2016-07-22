package com.makadown.ivydemo.fragment;

/**
 * Created by usuario on 15/03/2016.
 */
public class ItemModel
{
    String name;
    String isocode;


    ItemModel(String name, String isocode){
        this.name=name;
        this.isocode=isocode;
    }

    public String getName() {
        return name;
    }

    public String getisoCode() {
        return isocode;
    }
}
