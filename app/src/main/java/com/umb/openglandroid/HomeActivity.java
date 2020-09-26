package com.umb.openglandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class HomeActivity extends Activity
{
    private WebView webView;
    private String url = "https://umb.edu.co/";
    private String virtualURL = "https://umbvirtual.edu.co/";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);
        // reference the webview created in the Layout
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        InitButtons ();
    }

    private void InitButtons ()
    {
        Button home = findViewById(R.id.button_umb);
        Button homeVirtual = findViewById(R.id.button_umb_virtual);

        Button buttons [] = {home, homeVirtual};

        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    webView.loadUrl(v.getId() == R.id.button_umb? url : virtualURL);
                }
            });
        }
    }
}