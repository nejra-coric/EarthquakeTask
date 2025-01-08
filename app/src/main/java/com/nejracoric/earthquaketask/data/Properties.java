package com.nejracoric.earthquaketask.data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Properties {
    private double mag;
    private String place;
    private long time;
    private long updated;
    private String url;
    private String detail;
    private int tsunami;
    private String title;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMag() {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(mag);
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date(time));
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

