package com.example.zverek.treasure;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;



public class PredGame extends Activity {
    Button btn_map;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pred_game);
        btn_map = (Button) findViewById(R.id.btn_nacarte);


        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String videoSource ="http://www.cats.com/cat-speak.3gp";
        videoView.setVideoURI(Uri.parse(videoSource));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus(0);
        videoView.start();


        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PredGame.this, MyYandexMap.class);
                startActivity(intent);
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(PredGame.this, R.anim.my_tween_anim);
                imageView.startAnimation(anim);
            }
        });

    }
}


