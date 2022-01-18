package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NavigatorSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_select);
        Log.d("URL", "NAvigoator create");
        Button inner = findViewById(R.id.openInnerBrower);
        Button external = findViewById(R.id.openExternalBrowser);

        inner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView url = findViewById(R.id.urlAdress);
                Intent intentInnerNavigator = new Intent(NavigatorSelect.this, InternalBrowser.class);
                intentInnerNavigator.setData( Uri.parse(url.getText().toString()));
                startActivity(intentInnerNavigator);
            }
        });
        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView url = findViewById(R.id.urlAdress);
                Intent intentNavigator = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString()));
                startActivity(intentNavigator);
            }
        });
    }
}