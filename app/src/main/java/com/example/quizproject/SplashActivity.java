package com.example.quizproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Use a Handler to delay the transition to HomeActivity by 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After 2 seconds, start HomeActivity
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Close SplashActivity to prevent it from being on the back stack
            }
        }, 2000); // 2000 milliseconds = 2 seconds
    }
}
