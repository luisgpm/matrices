/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author Alex
 */
public class Figuras implements GLEventListener
{

    static int bandera;

    @Override
    public void init(GLAutoDrawable drawable)
    {
     GL gl=drawable.getGL();
     gl.setSwapInterval(1);
     gl.glClearColor(0.7f, 0.55f, 0.0f, 0.0f);
     gl.glShadeModel(GL.GL_SMOOTH);
    }

    @Override
    public void display(GLAutoDrawable drawable)
    {
         GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

       
        // Draw A Quad
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(1.0f, 0.0f, 0.0f);    // red
            gl.glVertex2f(-0.8f, 0.1f);  
            gl.glVertex2f( -0.2f, 0.1f); 
            gl.glVertex2f( -0.2f, 0.7f);  
            gl.glVertex2f( -0.8f, 0.7f); 
            
            gl.glColor3f(0.0f, 1.0f, 0.0f);    // gren
            gl.glVertex2f(-0.7f, -0.6f);  
            gl.glVertex2f( -0.1f, -0.6f);   
            gl.glVertex2f( -0.1f, 0.0f);  
            gl.glVertex2f( -0.7f, 0.0f); 
            
            gl.glColor3f(0.2f, 0.2f, 0.2f);    // dark gray 
            gl.glVertex2f(-0.9f, -0.7f);  
            gl.glColor3f(1.0f, 1.0f, 1.0f);   //white
            gl.glVertex2f( -0.5f, -0.7f);   
            gl.glColor3f(0.2f, 0.2f, 0.2f);  //dark gray
            gl.glVertex2f( -0.5f, -0.3f);  
            gl.glColor3f(1.0f, 1.0f, 1.0f);   //white 
            gl.glVertex2f( -0.9f, -0.3f);
        gl.glEnd();
        
        gl.glBegin(GL.GL_TRIANGLES);
        
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex2d(0.1f, -0.6f);
            gl.glVertex2d(0.7f, -0.6f);
            gl.glVertex2d(0.4f, -0.1f);
        
            gl.glColor3f(1.0f, 0.0f, 0.0f);    // Set the current drawing color to red
            gl.glVertex2f( 0.3f, -0.4f);   // Top
            gl.glColor3f(0.0f, 1.0f, 0.0f);    // Set the current drawing color to green
            gl.glVertex2f( 0.9f, -0.4f); // Bottom Left
            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
            gl.glVertex2f( 0.6f, -0.9f);  // Bottom Right
        // Finished Drawing The Triangle
        gl.glEnd();
        
        
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(1.0f, 1.0f, 0.0f);//amarillo
        for (int i = 0; i < 359; i++)
        {
            float y1= (float)((0.2f)*(Math.sin(i))+0.7);
            float x1= (float)((0.15f)*(Math.cos(i))+0.7);
            gl.glVertex2d(x1, y1);
        }
        gl.glEnd();
        
        if (bandera ==1)
        {
            gl.glBegin(gl.GL_POLYGON);
            gl.glColor3f(1.0f, 1.0f, 0.0f);
            gl.glVertex2d(0.22f, 0.68f);
            gl.glVertex2d(0.2f, 0.55f);
            gl.glVertex2d(0.3f, 0.6f);
            gl.glVertex2d(0.4f, 0.55f);
            gl.glVertex2d(0.38f, 0.68f);
            gl.glVertex2d(0.45f, 0.79f);
            gl.glVertex2d(0.35f, 0.79f);
            gl.glVertex2d(0.3f, 0.9f);
            gl.glVertex2d(0.25f, 0.79f);
            gl.glEnd();
        }
        
        if (bandera==2)
        {
            gl.glBegin(gl.GL_POLYGON);
            gl.glColor3f(1.0f, 0.0f, 1.0f);
            gl.glVertex2d(0.4f, 0.2f);
            gl.glVertex2d(0.6f, 0.2f);
            gl.glVertex2d(0.7f, 0.4f);
            gl.glVertex2d(0.6f, 0.6f);
            gl.glVertex2d(0.4f, 0.6f);
            gl.glVertex2d(0.3f, 0.4f);
            gl.glEnd();
        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

    public static void main(String[] args)
    {
        Frame frame = new Frame("coloreado figuras");
        final GLCanvas canvas = new GLCanvas();
        boolean bnd1 = false;
        canvas.addGLEventListener(new Figuras());
        MouseListener ml;
        ml = new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Robot r = null;
                try
                {
                    r = new Robot();
                } catch (AWTException ex)
                {
                    System.out.println("");
                }
                double x = e.getX();
                double y = e.getY();
                Color c = r.getPixelColor(e.getX(), e.getY());
                x = ((x - 320) / 320);
                y = ((y - 240) / 240);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                bandera = 1;
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                bandera = 2;
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
            }

        };
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.setVisible(true);
    }

}
