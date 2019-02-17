package com.elite.whatsappcleaner.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elite.whatsappcleaner.Activity.DocumentActivity;
import com.elite.whatsappcleaner.Activity.ImageActivity;
import com.elite.whatsappcleaner.R;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;

import static com.elite.whatsappcleaner.MainActivity.getExt;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> Document = new ArrayList<String>();

    public DocumentAdapter(DocumentActivity documentActivity, ArrayList<String> Document) {
        this.context = documentActivity;
        this.Document = Document;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.documentcard, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final File DocumentFile = new File(Document.get(i));
        Log.i("data", "DocumentFile " + DocumentFile);

        final String extension = getExt(String.valueOf(DocumentFile));
        Log.i("data", "Extension " + extension);

        String filename = FilenameUtils.getName(String.valueOf(DocumentFile));
        Log.i("data", "FileOutput " + filename);

        myViewHolder.type.setText(extension);
        myViewHolder.name.setText(filename);
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(String.valueOf(DocumentFile));
                file.delete();
                Document.remove(i);
                notifyDataSetChanged();
            }
        });


        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extension.equals("pdf")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
                    Log.i("DocumentAdapter", " PDF ");
                } else if (extension.equals("mp3")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "audio/*");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
                    Log.i("DocumentAdapter", " MP3 ");
                } else if (extension.equals("docx")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "application/msword");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
                    Log.i("DocumentAdapter", " DOCX ");
                } else {
                    String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), mimetype);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
//                    Toast.makeText(context, "No handler for this type of file.", Toast.LENGTH_LONG).show();
                    Log.i("DocumentAdapter", " Else ");
                }
            }
        });

//        else if (!((extension.equals("pdf")) || (extension.equals("mp3")) || (extension.equals("docx")))) {
//            String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), mimetype);
//            context.startActivity(Intent.createChooser(intent, "Complete action using"));
//        }

//        if (extension == "doc") {
//            myViewHolder.image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "docs/*");
//                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
//                }
//            });
//        }
//
//        if (extension == "mp3") {
//            myViewHolder.image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "audio/*");
//                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
//                }
//            });
//        }
//        if (extension == "mp3") {
//            myViewHolder.image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), "application/vnd.android.package-archive");
//                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
//                }
//            });
//        }
//        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.parse(String.valueOf(DocumentFile)), extension);
//                try {
//                    context.startActivity(Intent.createChooser(intent, "Complete action using"));
//                } catch (ActivityNotFoundException e) {
//                    Toast.makeText(context, "No handler for this type of file.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return Document.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image, delete;
        TextView type,name;

        MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            delete = itemView.findViewById(R.id.delete);
            type = itemView.findViewById(R.id.type);
            name = itemView.findViewById(R.id.name);
        }
    }
}
