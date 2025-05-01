package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        // Find views by ID
        View returnButton = findViewById(R.id.return_button);
        View alignStar = findViewById(R.id.aligne_star);
        View refreshButton = findViewById(R.id.btn_refresh);
        View dislikeButton = findViewById(R.id.btn_dislike);
        View likeButton = findViewById(R.id.btn_like);
        View listAddButton = findViewById(R.id.btn_listAdd);

        // Set click listeners
        returnButton.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Return button clicked", Toast.LENGTH_SHORT).show()
        );

        alignStar.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Align star clicked", Toast.LENGTH_SHORT).show()
        );

        refreshButton.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Refresh button clicked", Toast.LENGTH_SHORT).show()
        );

        dislikeButton.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Dislike button clicked", Toast.LENGTH_SHORT).show()
        );

        likeButton.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Like button clicked", Toast.LENGTH_SHORT).show()
        );

        listAddButton.setOnClickListener(v ->
                Toast.makeText(ExploreActivity.this, "Add to list button clicked", Toast.LENGTH_SHORT).show()
        );
    }
}