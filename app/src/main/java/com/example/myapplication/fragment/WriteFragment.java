package com.example.myapplication.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;

public class WriteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 返回一个空的视图，表示此 Fragment 目前没有内容
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }
}
