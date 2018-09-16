package com.tutorials.rectrofit.processes;

import com.google.gson.annotations.SerializedName;
import com.tutorials.rectrofit.model.CountryCode;

public class TCountryCodes
{
    @SerializedName("CountryCodes")
    private CountryCode[] countryCodes;

    public CountryCode[] getCountryCodes() {
        return countryCodes;
    }
}
