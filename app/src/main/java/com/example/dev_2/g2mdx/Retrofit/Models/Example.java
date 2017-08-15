package com.example.dev_2.g2mdx.Retrofit.Models;
        import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("city")
    @Expose
    private List<City> city = null;

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

}