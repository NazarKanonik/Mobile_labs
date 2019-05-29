package ua.lpnu.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGlSurfaceView extends GLSurfaceView {

    ua.lpnu.opengl.Renderer myRender;

    public MyGlSurfaceView(Context context) {
        super(context);
        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        // Set the Renderer for drawing on the GLSurfaceView
        myRender = new ua.lpnu.opengl.Renderer();
        setRenderer(myRender);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

        this.setOnClickListener(v -> myRender.changeColor = !myRender.changeColor);
    }

    @Override
    public void onPause() {
        super.onPause();
        myRender.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        myRender.onResume();
    }

}
