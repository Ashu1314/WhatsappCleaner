package com.elite.whatsappcleaner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elite.whatsappcleaner.Activity.AudioActivity;
import com.elite.whatsappcleaner.Activity.VoiceActivity;
import com.elite.whatsappcleaner.R;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;

public class VoiceAdapter extends RecyclerView.Adapter<VoiceAdapter.MyViewHolder> {

    Context context;
    public ArrayList<String> Voice = new ArrayList<String>();

    public VoiceAdapter(VoiceActivity voiceActivity, ArrayList<String> Voice) {
        this.context = voiceActivity;
        this.Voice = Voice;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.audiocard, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final File videoFile = new File(Voice.get(i));

        String filename = FilenameUtils.getName(String.valueOf(videoFile));
        Log.i("data", "FileOutput " + filename);

        myViewHolder.name.setText(filename);

        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(videoFile));
                file.delete();
                Voice.remove(i);
                notifyDataSetChanged();
            }
        });
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(String.valueOf(videoFile)), "audio/*");
                context.startActivity(Intent.createChooser(intent, "Complete action using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Voice.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image, delete;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            delete = itemView.findViewById(R.id.delete);
            name = itemView.findViewById(R.id.name);
        }
    }
}
