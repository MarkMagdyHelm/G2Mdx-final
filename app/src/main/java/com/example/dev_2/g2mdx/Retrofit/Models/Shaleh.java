package com.example.dev_2.g2mdx.Retrofit.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shaleh implements Serializable {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("PicLink")
    @Expose
    private String picLink;
    @SerializedName("Header")
    @Expose
    private String header;
    @SerializedName("numread")
    @Expose
    private String numread;
    @SerializedName("dates")
    @Expose
    private String dates;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("hot")
    @Expose
    private String hot;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("Latitude")
    @Expose
    private String latitude;
    @SerializedName("Longitude")
    @Expose
    private String longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getNumread() {
        return numread;
    }

    public void setNumread(String numread) {
        this.numread = numread;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}