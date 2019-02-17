package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elite.whatsappcleaner.Adapter.AudioAdapter;
import com.elite.whatsappcleaner.Adapter.VideoAdapter;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Audio;
import static com.elite.whatsappcleaner.MainActivity.Video;

public class AudioActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        context = AudioActivity.this;

//        progressBar = findViewById(R.id.progress_image);
        recyclerView = findViewById(R.id.recycleview_audio);
        gridLayoutManager = new GridLayoutManager(AudioActivity.this, 1);
        final AudioAdapter adapter = new AudioAdapter(AudioActivity.this, Audio);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
