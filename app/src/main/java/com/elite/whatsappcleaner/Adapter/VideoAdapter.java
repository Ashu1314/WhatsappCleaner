package com.elite.whatsappcleaner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elite.whatsappcleaner.Activity.VideoActivity;
import com.elite.whatsappcleaner.R;

import java.io.File;
import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    Context context;
    public ArrayList<String> Video = new ArrayList<String>();

    public VideoAdapter(VideoActivity videoActivity, ArrayList<String> Video) {
        this.context = videoActivity;
        this.Video = Video;
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

        final File videoFile = new File(Video.get(i));
//        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        Bitmap myBitmap = ThumbnailUtils.createVideoThumbnail(videoFile.getAbsolutePath(), MediaStore.Video.Thumbnails.MICRO_KIND);

        myViewHolder.image.setImageBitmap(myBitmap);
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(videoFile));
                file.delete();
                Video.remove(i);
                notifyDataSetChanged();
            }
        });
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(String.valueOf(videoFile)), "video/*");
                context.startActivity(Intent.createChooser(intent, "Complete action using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Video.size();
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
