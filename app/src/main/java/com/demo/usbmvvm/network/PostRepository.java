package com.demo.usbmvvm.network;


import android.arch.lifecycle.MutableLiveData;

import com.demo.usbmvvm.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    public static MutableLiveData<List<PostModel>> getPosts() {
        final MutableLiveData<List<PostModel>> data = new MutableLiveData<>();
        RetrofitAPIInterface retrofitApiInterface = RetrofitAPIClient.getRetrofitClient().create(RetrofitAPIInterface.class);

        Call<ArrayList<PostModel>> call = retrofitApiInterface.retrievePosts();
        call.enqueue(new Callback<ArrayList<PostModel>>() {

            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
            }
        });

        return data;
    }
}
