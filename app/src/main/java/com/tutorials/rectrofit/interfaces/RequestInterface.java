package com.tutorials.rectrofit.interfaces;

import com.tutorials.rectrofit.processes.Countries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface
{
    @GET("Countries")
    Call<Countries> getCountries();
}
