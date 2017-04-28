package com.example.zverek.treasure;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class TwoMainActivity extends Activity {
    LinearLayout liainer;
    LinearLayout liainer2;
    LinearLayout liainer3;
    LinearLayout liainerText;
    LinearLayout linearClone;
    LinearLayout mylinerabc;
    ImageButton btn_a, btn_b, btn_c;
    ImageView imgMyPhoto;
    TextView txtmynik;
    TextView txtToStartTime;
    TextView txtlistusers;
    Button iamfoundmany;
    SoundPool s2 = null;
    ImageView imageView;
    int idddk = 0;
    int ki = 20;


    private Interpolator decelerator = new DecelerateInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_main);
        liainer = (LinearLayout) findViewById(R.id.lcont1);
        liainer2 = (LinearLayout) findViewById(R.id.lcont2);
        liainer3 = (LinearLayout) findViewById(R.id.lcont3);
        liainerText = (LinearLayout) findViewById(R.id.linear_text);
        linearClone = new LinearLayout(this);
        imageView = (ImageView) findViewById(R.id.imageView6);
        mylinerabc = (LinearLayout) findViewById(R.id.mylinerabc);
        iamfoundmany = (Button) findViewById(R.id.iamfound);
        btn_a = (ImageButton) findViewById(R.id.imageButton2);
        btn_b = (ImageButton) findViewById(R.id.imageButton3);
        btn_c = (ImageButton) findViewById(R.id.imageButton4);
        txtmynik = (TextView) findViewById(R.id.mynik);
        txtlistusers = (TextView)findViewById(R.id.txtlistusers);
        txtmynik.setText(getIntent().getStringExtra("nik"));
        imgMyPhoto = (ImageView)findViewById(R.id.myphoto);
        txtToStartTime = (TextView) findViewById(R.id.txttostart2);
        String pathNik = "fonts/nik/JingJing.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), pathNik);
        txtmynik.setTypeface(typeface);
        String pathTime = "fonts/clock/QuartzMS.TTF";
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), pathTime);
        txtToStartTime.setTypeface(typeface2);
        s2 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        idddk = s2.load(TwoMainActivity.this, R.raw.beep_seconds, 1);

        new MyAsync().execute();
        txtmynik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoMainActivity.this, MySettingsActivity.class);
                startActivity(intent);
            }
        });
        imgMyPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TwoMainActivity.this, MySettingsActivity.class);
                startActivity(intent);
            }
        });
        Button b = (Button) findViewById(R.id.button7);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(),PredGame.class);
                startActivity(intent);
            }
        });
        Button b2 = (Button) findViewById(R.id.button8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                flipit();
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                flipit2();
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                flipit3();
            }
        });
        liainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UsersListActivity.class);
                startActivity(intent);

            }
        });
        liainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UsersListActivity.class);
                startActivity(intent);

            }
        });
        liainer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UsersListActivity.class);
                startActivity(intent);

            }
        });
        iamfoundmany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IamFoundMany.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation anim = AnimationUtils.loadAnimation(TwoMainActivity.this, R.anim.my_tween_anim);
                imageView.startAnimation(anim);
            }
        });
    }


    private void flipit() {
        if (liainer.getVisibility() == View.VISIBLE || linearClone.getVisibility() == View.VISIBLE) {
            liainer.setVisibility(liainer.GONE);
            linearClone.setVisibility(linearClone.GONE);

        }
        liainer.setVisibility(liainer.VISIBLE);
        ObjectAnimator visToInvis = ObjectAnimator.ofFloat(liainer, "rotationY", 90f, -360f);

        visToInvis.setDuration(500);

        visToInvis.setInterpolator(decelerator);

        visToInvis.start();

        linearClone = liainer;


    }


    private void flipit2() {
        if (liainer.getVisibility() == View.VISIBLE || linearClone.getVisibility() == View.VISIBLE) {
            liainer.setVisibility(liainer.GONE);
            linearClone.setVisibility(linearClone.GONE);

        }
        liainer2.setVisibility(liainer2.VISIBLE);
        final ObjectAnimator visToInvis = ObjectAnimator.ofFloat(liainer2, "rotationY", 90f, -360f);

        visToInvis.setDuration(500);

        visToInvis.setInterpolator(decelerator);

        visToInvis.start();

        linearClone = liainer2;


    }


    private void flipit3() {
        if (liainer.getVisibility() == View.VISIBLE || linearClone.getVisibility() == View.VISIBLE) {
            liainer.setVisibility(liainer.GONE);
            linearClone.setVisibility(linearClone.GONE);

        }
        liainer3.setVisibility(liainer3.VISIBLE);


        ObjectAnimator visToInvis = ObjectAnimator.ofFloat(liainer3, "rotationY", 90f, -360f);

        visToInvis.setDuration(500);

        visToInvis.setInterpolator(decelerator);
        visToInvis.start();
        linearClone = liainer3;


    }

    class MyAsync extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtToStartTime.setText("00:00:" + values[0]);

            s2.play(idddk, 1, 1, 0, 0, 2);

            if (ki==0) {

                liainerText.setVisibility(liainerText.GONE);
                liainer.setRotationY(-90f);
                liainer.setVisibility(liainer.VISIBLE);
                txtlistusers.setVisibility(txtlistusers.VISIBLE);
                new MyAsync2().execute();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {

            while (ki > -1) {
                publishProgress(ki);
                ki--;

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    class MyAsync2 extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            ObjectAnimator obj = ObjectAnimator.ofFloat(liainer, "rotationY", 90f, -360);

            obj.setDuration(2500);

            obj.setInterpolator(decelerator);
            obj.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mylinerabc.setVisibility(mylinerabc.VISIBLE);
                    AnimationSet set = new AnimationSet(true);
                    Animation anim = new AlphaAnimation(0.0f,0.1f);
                    anim.setDuration(800);
                    set.addAnimation(anim);
                    anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    anim.setDuration(100);
                    set.addAnimation(anim);
                    mylinerabc.setAnimation(anim);
                    mylinerabc.startAnimation(anim);
                }
            });
            obj.start();
        }

        @Override
        protected Void doInBackground(Void... params) {
            int kk=0;
            while(kk<1){
                kk++;
                publishProgress(kk);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}

