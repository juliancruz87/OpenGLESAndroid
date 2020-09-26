package com.umb.openglandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;

public class HomeActivity extends Activity
{
    private WebView webView;
    private String url = "https://umb.edu.co/";
    private String virtualURL = "https://umbvirtual.edu.co/";
    private String user = "julian";
    private String password = "1111";

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

        InitMenuButtons();
        LoadSite ();
        InitLoginForm();
    }

    private void InitMenuButtons()
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

    private void LoadSite ()
    {
        Button btnSite = findViewById(R.id.btnLoadSite);
        final TextInputEditText siteLabel = findViewById(R.id.webSiteLabel);

        btnSite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(siteLabel.getText().toString());
            }
        });
    }

    private void InitLoginForm()
    {
        final TextInputEditText userText = findViewById(R.id.user);
        final EditText passwordText = findViewById(R.id.password);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String userLabel = userText.getText().toString().toLowerCase();
                String passwordLabel = passwordText.getText().toString().toLowerCase();

                if(userLabel.equals(user) && passwordLabel.equals(password))
                {
                    Intent mainIntent = new Intent(HomeActivity.this, OpenGLActivity.class);
                    HomeActivity.this.startActivity(mainIntent);
                }
            }
        });
    }
}