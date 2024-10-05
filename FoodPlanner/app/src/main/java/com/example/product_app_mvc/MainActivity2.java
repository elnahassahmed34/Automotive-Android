package com.example.product_app_mvc;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Animation animation;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.animation_layout);
        txtView =findViewById(R.id.textView2);
        txtView.startAnimation(animation);
        txtView.postOnAnimationDelayed(new Runnable() {
            @Override
            public void run() {
                Intent outIntent = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(outIntent);
                finish();
            }},3000);

    }
}