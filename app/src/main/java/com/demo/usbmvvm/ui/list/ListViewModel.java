package com.demo.usbmvvm.ui.list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.demo.usbmvvm.model.PostModel;
import com.demo.usbmvvm.network.PostRepository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private final LiveData<List<PostModel>> projectListObservable;

    public ListViewModel(@NonNull Application application) {
        super(application);
        projectListObservable = PostRepository.getPosts();
    }

    public LiveData<List<PostModel>> getProjectListObservable() {
        return projectListObservable;
    }
}
