package com.example.vegeplanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlineTutorialActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_tutorial);

        toolbar = findViewById(R.id.action_bar1);
        webView = findViewById(R.id.webView);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnlineTutorialActivity.this.onBackPressed();
            }
        });

        Intent intent = getIntent();
        uri = intent.getStringExtra(ListDataActivity.EXTRA_URI);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(uri);
    }
}