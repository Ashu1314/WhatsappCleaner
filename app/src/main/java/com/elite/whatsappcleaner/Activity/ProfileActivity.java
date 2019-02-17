package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.elite.whatsappcleaner.Adapter.ImageAdapter;
import com.elite.whatsappcleaner.Adapter.ProfileAdapter;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Photo;
import static com.elite.whatsappcleaner.MainActivity.Profile;

public class ProfileActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context=ProfileActivity.this;

        recyclerView = findViewById(R.id.recycleview_profile);
        gridLayoutManager = new GridLayoutManager(ProfileActivity.this, 3);
        final ProfileAdapter adapter = new ProfileAdapter(ProfileActivity.this, Profile);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
