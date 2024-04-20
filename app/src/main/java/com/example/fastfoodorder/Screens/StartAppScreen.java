package com.example.fastfoodorder.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastfoodorder.R;

public class StartAppScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app_screen);

        Button buttonToMainScreen = findViewById(R.id.button_to_mainscreen_from_activitymain);
        buttonToMainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartAppScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}