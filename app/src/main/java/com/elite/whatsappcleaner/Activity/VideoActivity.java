package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.elite.whatsappcleaner.R;
import com.elite.whatsappcleaner.Adapter.VideoAdapter;

import static com.elite.whatsappcleaner.MainActivity.Video;

public class VideoActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        context = VideoActivity.this;

//        progressBar = findViewById(R.id.progress_image);
        recyclerView = findViewById(R.id.recycleview_video);
        gridLayoutManager = new GridLayoutManager(VideoActivity.this, 3);
        final VideoAdapter adapter = new VideoAdapter(VideoActivity.this, Video);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
