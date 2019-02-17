package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elite.whatsappcleaner.Adapter.AudioAdapter;
import com.elite.whatsappcleaner.Adapter.VoiceAdapter;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Audio;
import static com.elite.whatsappcleaner.MainActivity.Voice;
import static com.elite.whatsappcleaner.MainActivity.Voice2;

public class VoiceActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        context = VoiceActivity.this;

        recyclerView = findViewById(R.id.recycleview_voice);
        gridLayoutManager = new GridLayoutManager(VoiceActivity.this, 1);
        final VoiceAdapter adapter = new VoiceAdapter(VoiceActivity.this, Voice2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
