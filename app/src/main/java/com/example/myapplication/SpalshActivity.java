package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SpalshActivity extends AppCompatActivity {

            Animation topanim,bottomanim;
            ImageView imageView;
            TextView textView;
       public  static int SPALSH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spalsh);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

                topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
                bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
                imageView =findViewById(R.id.profile);
                textView =findViewById(R.id.student_info);
                imageView.setAnimation(topanim);
                textView.setAnimation(bottomanim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LoginIntent = new Intent(SpalshActivity.this, RcyclerViewActivity.class);
                startActivity(LoginIntent);
                finish();
            }
        },SPALSH_TIME_OUT);
    }
}