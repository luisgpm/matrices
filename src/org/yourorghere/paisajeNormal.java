/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

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
import javax.swing.JComboBox;

/**
 *
 * @author luisg
 */
public class paisajeNormal implements GLEventListener
{
//       gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
  

    static final double pi=3.1416;
    @Override
    public void init(GLAutoDrawable drawable)
    {
        GL gl=drawable.getGL();
        gl.setSwapInterval(1);
        gl.glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        
    
    }

    @Override
    public void display(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

          //pasto
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2d(1.0f, 0.2f);
        gl.glVertex2d(-1.0f, 0.2f);
        gl.glVertex2d(-1.0f, -1.0f);
        gl.glVertex2d(1.0f, -1.0);
        gl.glEnd();

        //casa 
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2d(0.3f, 0.0f);
        gl.glVertex2d(0.9f, 0.0f);
        gl.glVertex2d(0.6f, 0.3f);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(0.4f, 0.0f);
        gl.glVertex2d(0.8f, 0.0f);
        gl.glVertex2d(0.6f, -0.2f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2d(0.4f, 0.0f);
        gl.glVertex2d(0.4f, -0.4f);
        gl.glVertex2d(0.8f, 0.0f);
        gl.glVertex2d(0.8f, -0.4f);
        gl.glEnd();
        
      
        //arbol
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(1.0f, 0.5f, 0.05f);
        gl.glVertex2d(-0.8f, 0.0f);
        gl.glVertex2d(-0.9f, 0.0f);
        gl.glVertex2d(-0.9f, -0.4f);
        gl.glVertex2d(-0.8f, -0.4f);
        gl.glEnd();
        
          gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
        gl.glVertex2d(-1.0f, 0.0f);
        gl.glVertex2d(-0.7f, 0.0f);
        gl.glVertex2d(-0.85f, 0.6f);
        gl.glEnd();
//        
//        
//        
 //Dibuja circunferencia sol
        gl.glBegin(gl.GL_POLYGON);
            for(int i=0; i<100; i++){
               float x = (float) Math.cos(i*pi/100);
               float y = (float) Math.sin(i*pi/100)+1;
               gl.glVertex2f(x/5, y/5); gl.glColor3f(1.0f, 0.8f, 0.2f);
            }
        gl.glEnd();        
//        
        //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
        gl.glVertex2d(0.0f, 0.2f);
        gl.glVertex2d(-0.5f, 0.2f);
        gl.glVertex2d(-0.25f, 0.6f);
        gl.glEnd();
         gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
        gl.glVertex2d(0.0f, 0.2f);
        gl.glVertex2d(0.5f, 0.2f);
        gl.glVertex2d(0.25f, 0.6f);
        gl.glEnd();
        
        //lago
        gl.glBegin(gl.GL_POLYGON);
            for(int i=0; i<100; i++){
               float x = (float) Math.cos(i*pi*2/100)-1;
               float y = (float)( Math.sin(i*pi*2/100)-3.5);
               gl.glVertex2f(x/2, y/4); gl.glColor3f(0.0f, 0.0f, 0.7f);
            }
        gl.glEnd(); 
        
        
        
        gl.glFlush();
        
    }
    public static void main(String[] args)
    {
        Frame frame= new Frame("Luis Gerardo Porcayo");
        final GLCanvas cavanas = new GLCanvas();
        boolean bnd1 = false;
        cavanas.addGLEventListener(new paisajeNormal());
        MouseListener m1;
        m1 = new MouseListener()
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        frame.add(cavanas);
        frame.setSize(640, 480);
        frame.addWindowListener(new WindowAdapter()
        {
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

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
        
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
        
    }
    
}
