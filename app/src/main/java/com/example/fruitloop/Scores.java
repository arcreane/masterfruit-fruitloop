package com.example.fruitloop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        Button btnBackMenu = findViewById(R.id.back_to_menu);
        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMenu = new Intent(Scores.this, MainMenu.class);
                startActivity(backMenu);
            }
        });
    }
}