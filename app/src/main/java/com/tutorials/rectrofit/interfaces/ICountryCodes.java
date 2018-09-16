package com.tutorials.rectrofit.interfaces;

import com.tutorials.rectrofit.model.CountryCode;
import com.tutorials.rectrofit.processes.TCountryCodes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICountryCodes
{
    @GET("Test")
    Call<CountryCode[]> getCountryCodes();

    @GET("CountryCodes")
    Call<TCountryCodes> getAllCountryCodes();
}
