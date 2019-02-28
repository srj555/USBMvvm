package com.demo.usbmvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.usbmvvm.R;
import com.demo.usbmvvm.callback.PostListItemClickListener;
import com.demo.usbmvvm.databinding.ItemListContentBinding;
import com.demo.usbmvvm.model.PostModel;

import java.util.List;

public class PostListViewAdapter extends RecyclerView.Adapter<PostListViewAdapter.ViewHolder> {

    private List<PostModel> mValues;
    private PostListItemClickListener listener;

    public PostListViewAdapter(
            PostListItemClickListener listener) {
        this.listener = listener;
    }

    public void setPostList(List<PostModel> postList) {
        this.mValues = postList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemListContentBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list_content,
                        parent, false);

        binding.setCallback(listener);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.binding.setProject(mValues.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mValues == null ? 0 : mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final ItemListContentBinding binding;

        public ViewHolder(ItemListContentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
