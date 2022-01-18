package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView tv = new TextView(this);
//        tv.setText("Mon text tout simple");
//        setContentView(tv);

        setContentView(R.layout.activity_main);
         /*TextView thirdTextView = findViewById(R.id.textView2);
        thirdTextView.setText(R.string.newText);
        TextView fourthTextView = findViewById(R.id.textView3);
        String aString= getString(R.string.newText);

        fourthTextView.setText(aString.concat("Toto"));*/

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GuessANumber.class);
              /*  intent.setData(Uri.parse("tel:+33662151126" ));
                intent.setAction(Intent.ACTION_CALL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
                startActivity(intent);
            }
        });

    }
}