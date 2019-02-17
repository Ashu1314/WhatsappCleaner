package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elite.whatsappcleaner.Adapter.ProfileAdapter;
import com.elite.whatsappcleaner.Adapter.WallPaperAdapter;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Photo;
import static com.elite.whatsappcleaner.MainActivity.Wallpaper;

public class WallPaperActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        context=WallPaperActivity.this;

        recyclerView = findViewById(R.id.recycleview_WallPaper);
        gridLayoutManager = new GridLayoutManager(WallPaperActivity.this, 3);
        final WallPaperAdapter adapter = new WallPaperAdapter(WallPaperActivity.this, Wallpaper);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
