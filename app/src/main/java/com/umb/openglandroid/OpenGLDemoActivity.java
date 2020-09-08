package com.umb.openglandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.opengl.GLSurfaceView;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class OpenGLDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new GLCanvasRenderer());
        setContentView(view);

        EditText editBox = new EditText(this);
        editBox.setText("Hello World: The Spinning Cube at OpenGLES 2.0");
        addContentView(editBox, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        Context context = getApplicationContext();
        String msg = getApplicationInfo().packageName;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT * 5).show();
    }
}
