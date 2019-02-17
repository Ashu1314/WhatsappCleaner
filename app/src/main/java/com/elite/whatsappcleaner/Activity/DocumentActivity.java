package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elite.whatsappcleaner.Adapter.DocumentAdapter;
import com.elite.whatsappcleaner.Adapter.WallPaperAdapter;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Document;
import static com.elite.whatsappcleaner.MainActivity.Wallpaper;

public class DocumentActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

//        context=DocumentActivity.this;

        recyclerView = findViewById(R.id.recycleview_Document);
        gridLayoutManager = new GridLayoutManager(DocumentActivity.this, 1);
        final DocumentAdapter adapter = new DocumentAdapter(DocumentActivity.this, Document);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
