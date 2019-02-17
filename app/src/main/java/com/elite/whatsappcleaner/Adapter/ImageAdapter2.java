package com.elite.whatsappcleaner.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elite.whatsappcleaner.Activity.ImageActivity;
import com.elite.whatsappcleaner.R;

import java.io.File;
import java.util.ArrayList;

import static com.elite.whatsappcleaner.MainActivity.Photo_sent;

public class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.MyViewHolder> {

    Context context;
    public ArrayList<String> Photo_sent = new ArrayList<String>();

    public ImageAdapter2(ImageActivity imageActivity, ArrayList<String> Photo_sent) {
        this.context = imageActivity;
        this.Photo_sent = Photo_sent;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imagecard, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final File imgFile2 = new File(Photo_sent.get(i));

        final int THUMBSIZE = 64;
        Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(imgFile2.getAbsolutePath()),
                THUMBSIZE, THUMBSIZE);

        myViewHolder.image.setImageBitmap(ThumbImage);

//        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile2.getAbsolutePath(),options);

//        myViewHolder.image.setImageBitmap(myBitmap);
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(imgFile2));
                file.delete();
                Photo_sent.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Photo_sent.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image, delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
