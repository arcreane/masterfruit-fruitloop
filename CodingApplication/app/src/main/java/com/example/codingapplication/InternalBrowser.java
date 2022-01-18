package com.example.codingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class InternalBrowser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_browser);
        Log.d("URL", "OnCreate");
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        if(intent != null){
            Uri uri = intent.getData();
            if(uri != null){
                String url = uri.toString();
                Log.d("URL", "url : " + url);
                try {
                    webView.loadUrl(String.valueOf(new URL(url)));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}