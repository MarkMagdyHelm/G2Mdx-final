package com.example.dev_2.g2mdx.Retrofit.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListEX implements Serializable {

    @SerializedName("shaleh")
    @Expose
    private List<Shaleh> shaleh = null;

    public List<Shaleh> getShaleh() {
        return shaleh;
    }

    public void setShaleh(List<Shaleh> shaleh) {
        this.shaleh = shaleh;
    }

}