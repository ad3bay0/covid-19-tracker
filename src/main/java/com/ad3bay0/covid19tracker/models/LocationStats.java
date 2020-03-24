package com.ad3bay0.covid19tracker.models;

/**
 * LocationStats
 */
public class LocationStats {

    private String state;
    private String country;
    private int latestCases;



    public LocationStats() {
    }


    public LocationStats(String state, String country, int latestCases) {
        this.state = state;
        this.country = country;
        this.latestCases = latestCases;
    }


    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestCases() {
        return this.latestCases;
    }

    public void setLatestCases(int latestCases) {
        this.latestCases = latestCases;
    }


    @Override
    public String toString() {
        return "{" +
            " state='" + getState() + "'" +
            ", country='" + getCountry() + "'" +
            ", latestCases='" + getLatestCases() + "'" +
            "}";
    }



}