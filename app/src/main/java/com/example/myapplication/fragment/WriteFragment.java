package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.StoreAdapter;

import java.util.ArrayList;
import java.util.List;

public class WriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private StoreAdapter adapter;
    private List<Integer> imageList;

    public WriteFragment() {
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
        imageList.add(R.drawable.a);  // 示例：添加图片资源
        imageList.add(R.drawable.b);  // 示例：可以继续添加更多资源
        imageList.add(R.drawable.c);  // 示例：可以继续添加更多资源
        imageList.add(R.drawable.d);  // 示例：可以继续添加更多资源
        // 可以继续添加更多图片资源...

        // 初始化适配器并设置给RecyclerView
        adapter = new StoreAdapter(imageList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}