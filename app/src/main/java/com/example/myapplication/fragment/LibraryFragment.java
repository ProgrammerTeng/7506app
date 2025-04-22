package com.example.myapplication.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Book;
import com.example.myapplication.R;
import com.example.myapplication.adapter.BookAdapter;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private List<Book> bookList;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_library, container, false);

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recommendRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create book list (this could be dynamic data from a server or database)
        bookList = new ArrayList<>();
        bookList.add(new Book("A Tale for the Time Being", "Rose Weiguan", "suspense", 9.6, R.drawable.timebeing, "Those who have experienced pain and lost youth, you are never alone.", 733));
        bookList.add(new Book("I Love Myself", "Rose Weiguan", "suspense", 9.1, R.drawable.myself, "We are not alone.", 285));

        // Initialize adapter and set it to RecyclerView
        adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
