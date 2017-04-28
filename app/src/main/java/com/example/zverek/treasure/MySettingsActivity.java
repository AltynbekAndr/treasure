package com.example.zverek.treasure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MySettingsActivity extends Activity {
  ImageView img3;
    final int Pic_image=2;


    Bitmap bitmap;
    Button b = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);
        img3 = (ImageView) findViewById(R.id.imageView3);



        b = (Button) findViewById(R.id.button4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MySettingsActivity.this, "сохранено", Toast.LENGTH_SHORT).show();
            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pickPhoto = new Intent(Intent.ACTION_PICK);
                pickPhoto.setType("image/*");
                startActivityForResult(pickPhoto, Pic_image);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode) {
            case Pic_image:
                if(resultCode == RESULT_OK){
                    Uri uri = data.getData();
                    try {
                        InputStream input = getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(input);

                        img3.setImageBitmap(bitmap);



                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                    }  }


        }

    }
}
