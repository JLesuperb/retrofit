package com.tutorials.rectrofit.model;

import com.google.gson.annotations.SerializedName;

public class Country
{
    @SerializedName("CountryId")
    private Long countryId;

    @SerializedName("CountryName")
    private String countryName;

    @SerializedName("ISO2")
    private String iso2;

    @SerializedName("ISO3")
    private String iso3;

    public Long getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
