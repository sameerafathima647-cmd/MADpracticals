package com.mmm.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivTarget = findViewById(R.id.ivTarget);
        Button btnAnimate = findViewById(R.id.btnAnimate);

        // 1. Load the animation from the XML file in the anim folder
        Animation spinAndScaleAnimation = AnimationUtils.loadAnimation(this,
R.anim.spinandscale);

        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. Apply the animation to the specific view
                ivTarget.startAnimation(spinAndScaleAnimation);
            }
        });
    }
}
