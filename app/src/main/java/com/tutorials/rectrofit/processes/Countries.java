package com.tutorials.rectrofit.processes;

import com.google.gson.annotations.SerializedName;
import com.tutorials.rectrofit.model.Country;

public class Countries
{
    @SerializedName("Countries")
    private Country[] countries;

    @SerializedName("Country")
    private Country country;

    public Country[] getCountries() {
        return countries;
    }

    public Country getCountry() {
        return country;
    }
}
