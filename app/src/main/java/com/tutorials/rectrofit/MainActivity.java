package com.tutorials.rectrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tutorials.rectrofit.interfaces.RequestInterface;
import com.tutorials.rectrofit.model.Country;
import com.tutorials.rectrofit.processes.Countries;
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
        call.enqueue(new Callback<Countries>() {
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
        });
    }
}
