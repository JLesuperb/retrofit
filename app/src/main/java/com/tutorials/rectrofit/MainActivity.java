package com.tutorials.rectrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tutorials.rectrofit.interfaces.ICountryCodes;
import com.tutorials.rectrofit.interfaces.RequestInterface;
import com.tutorials.rectrofit.model.CountryCode;
import com.tutorials.rectrofit.processes.Countries;
import com.tutorials.rectrofit.processes.TCountryCodes;
import com.tutorials.rectrofit.tools.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestInterface service = RetrofitClient.getRetrofitInstance().create(RequestInterface.class);
        Call<Countries> call = service.getCountries();
        /*call.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(@NonNull Call<Countries> call, @NonNull Response<Countries> response)
            {
                if (response.body().getCountries() != null) {
                    String listString = "";

                    for (Country s : response.body().getCountries())
                    {
                        listString += s + "\t";
                    }

                    Toast.makeText(getApplicationContext(),listString,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Countries> call, @NonNull Throwable t)
            {
                Log.e("CountriesProcess", t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });*/

        ICountryCodes iCountryCodes = RetrofitClient.getRetrofitInstance().create(ICountryCodes.class);
        Call<CountryCode[]> countryCodesCall = iCountryCodes.getCountryCodes();
        countryCodesCall.enqueue(new Callback<CountryCode[]>()
        {
            @Override
            public void onResponse(@NonNull Call<CountryCode[]> call, @NonNull Response<CountryCode[]> response)
            {
                if (response.body() != null)
                {
                    CountryCode[] countryCodes = response.body();
                    if(countryCodes!=null) {
                        StringBuilder listString = new StringBuilder();
                        for (CountryCode countryCode : countryCodes)
                        {
                            listString.append(countryCode.getCountry()).append(" 2 \t");
                        }
                        Toast.makeText(getApplicationContext(), listString.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CountryCode[]> call, @NonNull Throwable t)
            {

            }
        });

        Call<TCountryCodes> codesCall = iCountryCodes.getAllCountryCodes();
        codesCall.enqueue(new Callback<TCountryCodes>() {
            @Override
            public void onResponse(@NonNull Call<TCountryCodes> call, @NonNull Response<TCountryCodes> response)
            {
                if (response.body()!=null)
                {
                    TCountryCodes tCountryCodes = response.body();
                    if(tCountryCodes!=null)
                    {
                        CountryCode[] countryCodes = tCountryCodes.getCountryCodes();
                        StringBuilder listString = new StringBuilder();
                        for (CountryCode countryCode : countryCodes)
                        {
                            listString.append(countryCode.getCountry()).append(" ").append(1).append("\t");
                        }
                        Toast.makeText(getApplicationContext(), listString.toString(),Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<TCountryCodes> call, @NonNull Throwable t) {

            }
        });
    }
}
