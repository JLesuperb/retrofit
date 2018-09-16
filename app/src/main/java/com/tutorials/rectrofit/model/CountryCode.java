package com.tutorials.rectrofit.model;

import com.google.gson.annotations.SerializedName;

public class CountryCode
{
    @SerializedName("CountryCodeId")
    private Long countryCodeId;

    @SerializedName("Country")
    private Country country;

    @SerializedName("Code")
    private String code;

    @Override
    public String toString() {
        return code;
    }

    public Country getCountry() {
        return country;
    }
}
