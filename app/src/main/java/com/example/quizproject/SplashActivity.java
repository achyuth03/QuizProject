// SplashActivity.java
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

        // Delay for 2 seconds (2000 milliseconds) before moving to the next screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Uncomment this section to navigate to the HomeActivity once it's implemented
                // Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                // startActivity(intent);
                // finish(); // Close the splash screen so it won't be shown on back press
            }
        }, 2000); // 2-second delay
    }
}
