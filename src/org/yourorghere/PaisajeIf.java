/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class PaisajeIf implements GLEventListener
{
    matrices obj = new matrices();
//       gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
    double mat[][]={{0.0,0.2,1},{-0.5,0.2,1},{-0.25,0.6,1}};
    public static JComboBox cmb;
    public static int res =1;

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

                  gl.glBegin(GL.GL_QUADS);
                 gl.glColor3f(1.0f, 0.0f, 0.0f);
                   gl.glVertex2d(0.05f, -0.05f);
                gl.glVertex2d(0.05f, 0.05f);
                gl.glVertex2d(-0.05f, 0.05f);
                gl.glVertex2d(-0.05f, -0.05f);
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
               if (res==1)
        {
             //montaña
                   gl.glBegin(GL.GL_TRIANGLES);
                gl.glColor3f(0.0f, 0.50f, 0.0f);
                gl.glVertex2d(0.0f, 0.2f);
                gl.glVertex2d(-0.5f, 0.2f);
                gl.glVertex2d(-0.25f, 0.6f);
                gl.glEnd();
        }else if(res==2)
                {
                     //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double matR[][]=obj.rotacionPF(mat, -0.5, 0.2, 30);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(matR[i][0], matR[i][1]);
                 }
        gl.glEnd();
                }else if (res==3)
        {
             gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double matRR[][]=obj.traslacionPF(mat);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(matRR[i][0], matRR[i][1]);
                 }
        gl.glEnd();
        }else if (res==4)
        {
            //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat4[][]=obj.escalacion(mat, -0.5, 0.2);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat4[i][0], mat4[i][1]);
                 }
        gl.glEnd();
        }else if (res==5)
        {
             //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat5[][]=obj.refleccionX(mat);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat5[i][0], mat5[i][1]);
                 }
        gl.glEnd();
        }else if (res==6)
        {
             //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat6[][]=obj.refleccionY(mat);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat6[i][0], mat6[i][1]);
                 }
        gl.glEnd();
        }else if (res==7)
        {
            //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat7[][]=obj.corteX(mat, 2);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat7[i][0], mat7[i][1]);
                 }
        gl.glEnd();
        }else if (res==8)
        {
            //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat8[][]=obj.corteY(mat, 0.25);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat8[i][0], mat8[i][1]);
                 }
        gl.glEnd();
        }else if (res==9)
        {
             //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat9[][]=obj.refleccionR(mat);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat9[i][0], mat9[i][1]);
                 }
        gl.glEnd();
        }else if (res==10)
        {
            //montaña
           gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3f(0.0f, 0.50f, 0.0f);
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
            double mat10[][]=obj.refelccionOrigen(mat);
                 for (int i = 0; i < 3; i++)
                 {
                    gl.glVertex2d(mat10[i][0], mat10[i][1]);
                 }
        gl.glEnd();
        }
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
                
                
                TextRenderer txt = new TextRenderer(new Font ("Tahoma",Font.BOLD, 50));
                txt.beginRendering(drawable.getWidth(), drawable.getHeight());
                //txt.setColor(1f, 0f, 0f, 0.8f);
                txt.setColor(Color.CYAN);
                txt.draw("Luis", 200,200 );
                txt.endRendering();
                
                gl.glFlush();
               
        
                        
    }
    public static void main(String[] args)
    {
        Frame frame= new Frame("Luis Gerardo Porcayo");
        final GLCanvas cavanas = new GLCanvas();
        cmb = new JComboBox();
        cmb.addItem("Normal");
        cmb.addItem("Rotar");
        cmb.addItem("Trasladar");
        cmb.addItem("Escalar");
        cmb.addItem("Reflexion en X");
        cmb.addItem("Reflexion en Y");
        cmb.addItem("Corte en X");
        cmb.addItem("Corte en Y");
        cmb.addItem("Corte en la recta");
        cmb.addItem("Corte en el origen");
       
        cmb.setVisible(true);
        cmb.setForeground(Color.black);
        cmb.setBounds(100, 40, 150, 30);

        cavanas.addGLEventListener(new PaisajeIf());
        cmb.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (((String) cmb.getSelectedItem()).equals("Normal"))
                {
                    res = 1;

                } else if (((String) cmb.getSelectedItem()).equals("Rotar"))
                {
                    res = 2;

                } else if (((String) cmb.getSelectedItem()).equals("Trasladar"))
                {
                    res = 3;
                } else if (((String) cmb.getSelectedItem()).equals("Escalar"))
                {
                    res = 4;
                } else if (((String) cmb.getSelectedItem()).equals("Reflexion en X"))
                {
                    res = 5;
                } else if (((String) cmb.getSelectedItem()).equals("Reflexion en Y"))
                {
                    res = 6;
                } else if (((String)cmb.getSelectedItem()).equals("Corte en X"))
                {
                    res =7;
                }else if (((String)cmb.getSelectedItem()).equals("Corte en Y"))
                {
                    res =8;
                }else if (((String)cmb.getSelectedItem()).equals("Corte en la recta"))
                {
                    res =9;
                }else if (((String)cmb.getSelectedItem()).equals("Corte en el origen"))
                {
                    res =10;
                }
            }
        });
        frame.add(cmb);
        frame.add(cavanas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(cavanas);
        frame.addWindowListener(new WindowAdapter()
        {
             @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
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
