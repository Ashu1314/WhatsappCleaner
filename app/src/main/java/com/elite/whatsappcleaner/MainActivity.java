package com.elite.whatsappcleaner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.TextView;

import com.elite.whatsappcleaner.Activity.AudioActivity;
import com.elite.whatsappcleaner.Activity.DocumentActivity;
import com.elite.whatsappcleaner.Activity.ImageActivity;
import com.elite.whatsappcleaner.Activity.ProfileActivity;
import com.elite.whatsappcleaner.Activity.VideoActivity;
import com.elite.whatsappcleaner.Activity.VoiceActivity;
import com.elite.whatsappcleaner.Activity.WallPaperActivity;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CardView c1, c2, c3, c4, c5, c6, c7;
    TextView TotalImage, TotalAudio, TotalVideo,
            TotalProfile, TotalWallapp, TotalVoice, TotalDocument;

    public static final String FOLDER_NAME = "/WhatsApp/";
    public static ArrayList<String> Photo = new ArrayList<String>();
    public static ArrayList<String> Photo_sent = new ArrayList<String>();

    public static ArrayList<String> Audio = new ArrayList<String>();
    public static ArrayList<String> Video = new ArrayList<String>();
    public static ArrayList<String> Profile = new ArrayList<String>();
    public static ArrayList<String> Wallpaper = new ArrayList<String>();
    public static ArrayList<String> Voice = new ArrayList<String>();
    public static ArrayList<String> Voice2 = new ArrayList<String>();
    public static ArrayList<String> Document = new ArrayList<String>();

    private static File[] files1;
    private static File[] files1_sent;

    private static File[] files2;
    private static File[] files3;
    private static File[] files4;
    private static File[] files5;
    private static File[] files6;
    private static File[] files7;

    public static long folder_size_image;

    public static long folder_size_audio;
    public static long folder_size_video;
    public static long folder_size_profile;
    public static long folder_size_wallpaper;
    public static long folder_size_voice;
    public static long folder_size_document;
    public static long folder_size_calls;
    public static long folder_size_database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isStoragePermissionGranted();
        GetImageData();
        GetImageData2();

        GetAudioData();
        GetVideoData();
        GetVoiceData();
        GetVoiceData2();
        GetProfileData();
        GetWallpaperData();
        GetDocumentData();

        c1 = findViewById(R.id.imagecard);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        TotalImage = findViewById(R.id.totalimage);
        TotalImage.setText("Size: " + folder_size_image + " MB");

        c2 = findViewById(R.id.Audiocard);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AudioActivity.class));
            }
        });

        TotalAudio = findViewById(R.id.totealaudio);
        TotalAudio.setText("Size: " + folder_size_audio + " MB");

        c3 = findViewById(R.id.VidoeCard);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
            }
        });

        TotalVideo = findViewById(R.id.totalvideo);
        TotalVideo.setText("Size: " + folder_size_video + " MB");

        c4 = findViewById(R.id.Profilecard);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        TotalProfile = findViewById(R.id.totalProfile);
        TotalProfile.setText("Size: " + folder_size_profile + " MB");

        c5 = findViewById(R.id.Wallpapercard);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WallPaperActivity.class));
            }
        });

        TotalWallapp = findViewById(R.id.totalwallpaper);
        TotalWallapp.setText("Size: " + folder_size_wallpaper + " MB");

        c6 = findViewById(R.id.VoiceCard);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VoiceActivity.class));
            }
        });

        TotalVoice = findViewById(R.id.totalvoice);
        if (folder_size_voice <= 0) {
            TotalVoice.setText("Size: <1 MB");
        } else {
            TotalVoice.setText("Size: " + folder_size_voice + " MB");
        }
        c6 = findViewById(R.id.Documentcard);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DocumentActivity.class));
            }
        });

        TotalDocument = findViewById(R.id.totalDocument);
        TotalDocument.setText("Size: " + folder_size_document + " MB");
    }

    public static void GetImageData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Images";
        File targetDirector = new File(targetPath);
        files1 = targetDirector.listFiles();

        //long ImageSize2 =new StatFs(targetPath).getAvailableBytes();
        //ImageSize  =  ((long) Math.round((ImageSize2 / (1024 * 1024)) * 10) / 10);

        try {
            if (files1.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files1.length; ii++) {
                    String fileOutput = files1[ii].toString();
                    Photo.add(fileOutput);
                    Log.i("data", "FileOutput " + fileOutput);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/urfoldername/");

        folder_size_image = getFolderSize(targetDirector);
        folder_size_image = (long) ((float) Math.round((folder_size_image / (1024 * 1024)) * 10) / 10);

    }

    public static void GetImageData2() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Images/Sent";
        Log.i("data", "Photo_sent " + targetPath);
        File targetDirector = new File(targetPath);
        files1_sent = targetDirector.listFiles();

        try {
            if (files1_sent.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files1_sent.length; ii++) {
                    String fileOutput = files1_sent[ii].toString();
                    Photo_sent.add(fileOutput);
                    Log.i("data", "Photo_sent " + fileOutput);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void GetAudioData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Audio";
        File targetDirector = new File(targetPath);
        files2 = targetDirector.listFiles();

        try {
            if (files2.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files2.length; ii++) {
                    String fileOutput = files2[ii].toString();
                    Audio.add(fileOutput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        folder_size_audio = getFolderSize(targetDirector);
        folder_size_audio = (long) ((float) Math.round((folder_size_audio / (1024 * 1024)) * 10) / 10);
    }

    public static void GetVideoData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Video";
        File targetDirector = new File(targetPath);
        files3 = targetDirector.listFiles();

        try {
            if (files3.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files3.length; ii++) {
                    String fileOutput = files3[ii].toString();
                    Video.add(fileOutput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        folder_size_video = getFolderSize(targetDirector);
        folder_size_video = (long) ((float) Math.round((folder_size_video / (1024 * 1024)) * 10) / 10);
    }

    public static void GetProfileData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Profile Photos";
        File targetDirector = new File(targetPath);
        files4 = targetDirector.listFiles();

        try {
            if (files4.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files4.length; ii++) {
                    String fileOutput = files4[ii].toString();
                    Profile.add(fileOutput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        folder_size_profile = getFolderSize(targetDirector);
        folder_size_profile = (long) ((float) Math.round((folder_size_profile / (1024 * 1024)) * 10) / 10);
    }

    public static void GetWallpaperData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WallPaper";
        File targetDirector = new File(targetPath);
        files4 = targetDirector.listFiles();

        try {
            if (files4.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files4.length; ii++) {
                    String fileOutput = files4[ii].toString();
                    Wallpaper.add(fileOutput);
                    Log.i("data", "FileOutput " + fileOutput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        folder_size_wallpaper = getFolderSize(targetDirector);
        folder_size_wallpaper = (long) ((float) Math.round((folder_size_wallpaper / (1024 * 1024)) * 10) / 10);
    }

    public static void GetVoiceData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Voice Notes";
        File targetDirector = new File(targetPath);
        files5 = targetDirector.listFiles();

        try {
            if (files5.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files5.length; ii++) {
                    String fileOutput = files5[ii].toString();
                    Voice.add(fileOutput);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        folder_size_voice = getFolderSize(targetDirector);
        Log.i("data", "folder_size 1" + folder_size_voice);

//        if (folder_size_voice > 1048576) {
        folder_size_voice = (long) ((float) Math.round((folder_size_voice / (1024 * 1024)) * 10) / 10);
        Log.i("data", "folder_size 2" + folder_size_voice);
//        }
//        else {
//        }

    }


    public static void GetVoiceData2() {

        for (int i = 0; i < Voice.size(); i++) {
            String targetPath = Voice.get(i);
            File targetDirector = new File(targetPath);
            files6 = targetDirector.listFiles();

            try {
                if (files6.length != 0) {
                    // loops through the array of files, outputing the name to console
                    for (int ii = 0; ii < files6.length; ii++) {
                        String fileOutput = files6[ii].toString();
                        Voice2.add(fileOutput);
                        Log.i("data", "FileOutput_Voice2 " + fileOutput);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i("data", "Voice2: " + Voice2);
    }

    public static void GetDocumentData() {
        String targetPath = Environment.getExternalStorageDirectory().getAbsolutePath() + FOLDER_NAME + "Media/WhatsApp Documents";
        File targetDirector = new File(targetPath);
        files7 = targetDirector.listFiles();

        try {
            if (files7.length != 0) {
                // loops through the array of files, outputing the name to console
                for (int ii = 0; ii < files7.length; ii++) {
                    String fileOutput = files7[ii].toString();
                    Document.add(fileOutput);
                    Log.i("data", "FileOutput_a_Documents " + fileOutput);
                    getExt(fileOutput);
                    Log.i("data", "FileOutput_a_getExt " + getExt(fileOutput));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        folder_size_document = getFolderSize(targetDirector);
        folder_size_document = (long) ((float) Math.round((folder_size_document / (1024 * 1024)) * 10) / 10);
        Log.i("data", "folder_size" + folder_size_document);
    }

    public static long getFolderSize(File dir) {
        long size = 0;

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                // System.out.println(file.getName() + " " + file.length());
                size += file.length();
            } else
                size += getFolderSize(file);
        }
        return size;
    }

    public static String getExt(String filePath) {
        int strLength = filePath.lastIndexOf(".");
        if (strLength > 0)
            return filePath.substring(strLength + 1).toLowerCase();
        return null;
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        getdata();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        getdata();
//    }
}
