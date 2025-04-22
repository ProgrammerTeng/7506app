package com.example.myapplication.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Book;
import com.example.myapplication.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookTitle, bookAuthor, bookQuote, bookReaders, bookRating;

        public BookViewHolder(View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.bookImage);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
            bookQuote = itemView.findViewById(R.id.bookQuote);
            bookReaders = itemView.findViewById(R.id.bookReaders);
            bookRating = itemView.findViewById(R.id.bookRating);
        }
    }

    public BookAdapter(List<Book> books) {
        this.bookList = books;
    }

    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_card, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bookImage.setImageResource(book.getImageResId());
        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor() + " / " + book.getGenre());
        holder.bookQuote.setText("“" + book.getQuote() + "”");
        holder.bookReaders.setText(book.getReaders() + " people read");
        holder.bookRating.setText(String.valueOf(book.getRating()));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
