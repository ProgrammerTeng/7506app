package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.DiscoverBookAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private RecyclerView recyclerView;
    private DiscoverBookAdapter adapter;
    private List<Integer> imageList;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);

        // 初始化RecyclerView（关键修改点：改为纵向布局）
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // 默认纵向布局

        // 创建图片资源列表
        imageList = new ArrayList<>();
        imageList.add(R.drawable.discover_myself);  // 示例：添加图片资源
        imageList.add(R.drawable.discover_beautiful);  // 示例：可以继续添加更多资源
        imageList.add(R.drawable.discover_ocean_adventure);  // 示例：可以继续添加更多资源
        imageList.add(R.drawable.discover_beautiful);  // 示例：可以继续添加更多资源
        // 可以继续添加更多图片资源...

        // 初始化适配器并设置给RecyclerView
        adapter = new DiscoverBookAdapter(imageList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}