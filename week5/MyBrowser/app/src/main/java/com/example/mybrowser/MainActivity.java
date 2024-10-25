package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button btngo;
    EditText txtaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        btngo=findViewById(R.id.go);
        txtaddress=findViewById(R.id.address);
        webView.loadUrl("http://"+txtaddress.getText());
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://"+txtaddress.getText());
            }
        });
    if (getIntent()!=null && getIntent().getData()!=null){
        txtaddress.setText(getIntent().getData().toString());
        webView.loadUrl(getIntent().getData().toString());
    }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}