package com.demo.usbmvvm.ui.list;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.usbmvvm.R;
import com.demo.usbmvvm.adapter.PostListViewAdapter;
import com.demo.usbmvvm.callback.PostListItemClickListener;
import com.demo.usbmvvm.databinding.ListFragmentBinding;
import com.demo.usbmvvm.model.PostModel;

import java.util.List;

public class ListFragment extends Fragment {

    private ListViewModel mViewModel;
    private ListFragmentBinding binding;
    private PostListViewAdapter adapter;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);

        adapter = new PostListViewAdapter(projectClickCallback);
        binding.itemList.setAdapter(adapter);
        binding.itemList.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.setIsLoading(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        // TODO: Use the ViewModel
        observeViewModel(mViewModel);
    }

    private void observeViewModel(ListViewModel mViewModel) {
        // Update the list when the data changes
        mViewModel.getProjectListObservable().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(@Nullable List<PostModel> projects) {
                if (projects != null) {
                    adapter.setPostList(projects);
                }
            }
        });
    }

    private final PostListItemClickListener projectClickCallback = new PostListItemClickListener() {
        @Override
        public void onListItemClicked(PostModel postModel) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
//                ((MainActivity) getActivity()).show(project);
            }
        }
    };

}
