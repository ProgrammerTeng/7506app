package com.example.myapplication.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<DiscoverBookAdapter.BookViewHolder> {
    private List<Integer> imageList;  // 存储图片资源的列表

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView coverImage;

        public BookViewHolder(View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.image_cover);  // 获取 ImageView
        }
    }

    public StoreAdapter(List<Integer> images) {
        if (images == null) {
            throw new IllegalArgumentException("imageList cannot be null");
        }
        imageList = images;
    }

    @Override
    public DiscoverBookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 使用 item_book.xml 布局
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discover_item_book, parent, false);
        return new DiscoverBookAdapter.BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DiscoverBookAdapter.BookViewHolder holder, int position) {
        // 直接设置图片资源
        holder.coverImage.setImageResource(imageList.get(position));  // 设置封面图片
    }

    @Override
    public int getItemCount() {
        return imageList != null ? imageList.size() : 0;
    }
}
