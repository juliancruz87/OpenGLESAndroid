package com.umb.openglandroid.meshes.primitives;

import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.opengles.GL10;

public class Cube
{

    private FloatBuffer m_VertexBuffer;
    private FloatBuffer m_ColorBuffer;
    private ByteBuffer  m_IndexBuffer;

    private float vertices[] = {
            -1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, -1.0f,
            1.0f,  1.0f, -1.0f,
            -1.0f, 1.0f, -1.0f,
            -1.0f, -1.0f,  1.0f,
            1.0f, -1.0f,  1.0f,
            1.0f,  1.0f,  1.0f,
            -1.0f,  1.0f,  1.0f
    };
    private float colors[] = {
            0.0f,  1.0f,  0.0f,  1.0f,
            0.0f,  1.0f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.5f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            1.0f,  0.0f,  0.0f,  1.0f,
            0.0f,  0.0f,  1.0f,  1.0f,
            1.0f,  0.0f,  1.0f,  1.0f
    };

    private byte indices[] = {
            0, 4, 5, 0, 5, 1,
            1, 5, 6, 1, 6, 2,
            2, 6, 7, 2, 7, 3,
            3, 7, 4, 3, 4, 0,
            4, 7, 6, 4, 6, 5,
            3, 0, 1, 3, 1, 2
    };

    public Cube()
    {
        int k_FloatSize = 4;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * k_FloatSize);
        byteBuffer.order(ByteOrder.nativeOrder());
        m_VertexBuffer = byteBuffer.asFloatBuffer();
        m_VertexBuffer.put(vertices);
        m_VertexBuffer.position(0);

        byteBuffer = ByteBuffer.allocateDirect(colors.length * k_FloatSize);
        byteBuffer.order(ByteOrder.nativeOrder());
        m_ColorBuffer = byteBuffer.asFloatBuffer();
        m_ColorBuffer.put(colors);
        m_ColorBuffer.position(0);

        m_IndexBuffer = ByteBuffer.allocateDirect(indices.length);
        m_IndexBuffer.put(indices);
        m_IndexBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glFrontFace(GL10.GL_CW);

        // every vertex requires 3 floats because it's a vector positions xyz. it's not a magic number
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer);
        // every color requires 4 floats due to RGBA. it's not a magic number
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        //
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, m_IndexBuffer);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}

