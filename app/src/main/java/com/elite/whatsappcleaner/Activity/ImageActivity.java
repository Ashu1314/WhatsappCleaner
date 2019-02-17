package com.elite.whatsappcleaner.Activity;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.elite.whatsappcleaner.Adapter.ImageAdapter;
import com.elite.whatsappcleaner.Adapter.ImageAdapter2;
import com.elite.whatsappcleaner.R;

import static com.elite.whatsappcleaner.MainActivity.Photo;
import static com.elite.whatsappcleaner.MainActivity.Photo_sent;

public class ImageActivity extends AppCompatActivity {

    Context context;
    Boolean isScrolling = false;
    int currentitem, scrollitem;
    public static int totalitem;
    RecyclerView recyclerView,recyclerView_sent;
    ProgressBar progressBar;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        context = ImageActivity.this;

        progressBar = findViewById(R.id.progress_image);
        recyclerView = findViewById(R.id.recycleview);
        gridLayoutManager = new GridLayoutManager(ImageActivity.this, 3);
        final ImageAdapter adapter = new ImageAdapter(ImageActivity.this, Photo);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);


        recyclerView_sent = findViewById(R.id.recycleview_send);
        gridLayoutManager = new GridLayoutManager(ImageActivity.this, 3);
        final ImageAdapter2 adapter2 = new ImageAdapter2(ImageActivity.this, Photo_sent);
        recyclerView_sent.setLayoutManager(gridLayoutManager);
        recyclerView_sent.setAdapter(adapter2);


//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true;
//                }
//            }
//
//            @Override
//            public void onScrolled(@NonNull final RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                currentitem = gridLayoutManager.getChildCount();
//                scrollitem = gridLayoutManager.findFirstVisibleItemPosition();
//                totalitem = gridLayoutManager.getItemCount();
//                Log.i("data", "CurrentItem " + currentitem);
//                Log.i("data", "ScrollItem " + scrollitem);
//                Log.i("data", "TotalItem " + totalitem);
//
//                if (isScrolling) {
//                    isScrolling = false;
//                    progressBar.setVisibility(View.VISIBLE);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            adapter.notifyDataSetChanged();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }, 2000);
//                }
//            }
//        });
    }
}

//        File imgFile = new  File(Photo.get(1));
//        if(imgFile.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            ImageView myImage = (ImageView) findViewById(R.id.img);
//            myImage.setImageBitmap(myBitmap);
//        }
