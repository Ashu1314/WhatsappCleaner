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

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    Context context;
    public ArrayList<String> Photo = new ArrayList<String>();

    public ImageAdapter(ImageActivity imageActivity, ArrayList<String> Photo) {
        this.context = imageActivity;
        this.Photo = Photo;
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

        final File imgFile = new File(Photo.get(i));
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        final int THUMBSIZE = 64;

        Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(imgFile.getAbsolutePath()),
                THUMBSIZE, THUMBSIZE);

        myViewHolder.image.setImageBitmap(ThumbImage);
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(imgFile));
                file.delete();
                Photo.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Photo.size();
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
