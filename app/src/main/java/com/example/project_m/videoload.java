package com.example.project_m;


import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class videoload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //Video play
        final VideoView videoView =
                (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("https://firebasestorage.googleapis.com/v0/b/projectm-ea2f3.appspot.com/o/images%2F20200508_0000.png?alt=media&token=63f914cd-d117-41b1-931f-9805fbcfe91c");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setPadding(0, 0, 0, 80); //상위 레이어의 바닥에서 얼마 만큼? 패딩을 줌
        videoView.setMediaController(mediaController);

        videoView.start();


    }
}