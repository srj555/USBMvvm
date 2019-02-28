package com.demo.usbmvvm.network;


import com.demo.usbmvvm.model.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPIInterface {

    @GET("/posts")
    Call<ArrayList<PostModel>> retrievePosts();
}
