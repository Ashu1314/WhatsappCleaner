package com.elite.whatsappcleaner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elite.whatsappcleaner.Activity.AudioActivity;
import com.elite.whatsappcleaner.Activity.ProfileActivity;
import com.elite.whatsappcleaner.R;

import java.io.File;
import java.util.ArrayList;

import static com.elite.whatsappcleaner.MainActivity.Profile;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    Context context;
    public ArrayList<String> Profile = new ArrayList<String>();

    public ProfileAdapter(ProfileActivity profileActivity, ArrayList<String> Profile) {
        this.context = profileActivity;
        this.Profile = Profile;
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

        final File ProfileFile = new File(Profile.get(i));
        Bitmap myBitmap = BitmapFactory.decodeFile(ProfileFile.getAbsolutePath());
        myViewHolder.image.setImageBitmap(myBitmap);
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(ProfileFile));
                file.delete();
                Profile.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Profile.size();
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
