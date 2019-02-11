package com.admin.dvdstore.dvd;

import java.io.Serializable;

/**
 * Created by Robi on 11/22/2018.
 */
public class DVDEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private int year;
    private double price;

    public DVDEntry(String title, int year, double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public DVDEntry() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "New DVD:" +
                "\r\ntitle: " + title +
                "\r\nyear: " + year +
                "\r\nprice: " + price;
    }
}
