package com.example.coronavirus.interactor;

import android.util.Log;

import com.example.coronavirus.network.Endpoint;
import com.example.coronavirus.network.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractorImpl implements MainInteractor {

    Network network;
    Endpoint endpoint;

    @Override
    public void getMainInteractor(final ListenerInteractor<Object> listenerInteractor) {
        endpoint = Network.getClient().create(Endpoint.class);
        Call<Object> call = endpoint.getEndData();
        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d("respon", "INIRESPONNNN  " + response );

                Object obj = response.body();
                if (response.isSuccessful()){
                    listenerInteractor.onSuccess(obj);
                    Log.d("sukses", "" + obj );
                } else {
                    Log.d("notSukses", "gakblass   " + obj);
                }

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("notSukses", "ogak " + t);
            }
        });
    }

}
