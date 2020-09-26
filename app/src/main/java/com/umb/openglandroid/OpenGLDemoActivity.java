package com.umb.openglandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;

public class OpenGLDemoActivity extends Activity
{
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                /* Create an Intent that will start the Home-Activity. */
                Intent mainIntent = new Intent(OpenGLDemoActivity.this, HomeActivity.class);
                OpenGLDemoActivity.this.startActivity(mainIntent);
                OpenGLDemoActivity.this.finish(); // this is to prevent back button to access splash screen again.
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}