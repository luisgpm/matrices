/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author luisg
 */
public class prueba
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        matrices obj = new matrices();
//        gl.glVertex2d(0.0f, 0.2f);
//        gl.glVertex2d(-0.5f, 0.2f);
//        gl.glVertex2d(-0.25f, 0.6f);
        double mat[][]={{0.0,0.2,1},{-0.5,0.2,1},{-0.25,0.6,1}};
        double matR [][]=obj.rotacionPF(mat, -0.5, .2, 30);
        
        for (int i = 0; i < 3; i++)
        {
            System.out.println(matR[i][0]+" "+ matR[i][1]+" "+matR[i][2]);
            
        }
    }
    
}
