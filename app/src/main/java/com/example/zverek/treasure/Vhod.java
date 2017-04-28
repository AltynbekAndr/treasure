package com.example.zverek.treasure;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Vhod extends Activity {


    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhod);
        String path = "fonts/TAURU.TTF";
        TextView text6 = (TextView) findViewById(R.id.textView6);
        TextView text7 = (TextView) findViewById(R.id.textView7);
        Typeface typeface = Typeface.createFromAsset(getAssets(), path);
        text6.setTypeface(typeface);
        text7.setTypeface(typeface);

        btn3 = (Button)findViewById(R.id.button3);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation anim = AnimationUtils.loadAnimation(Vhod.this,R.anim.my_tween_anim);
                imageView.startAnimation(anim);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton img = (ImageButton) findViewById(R.id.imageButton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
