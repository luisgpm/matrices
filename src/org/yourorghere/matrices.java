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
public class matrices
{
    public static double[][] multiplicaMatriz(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        // se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        /**
         * si no se cumple la condición se retorna una matriz vacía
         */
        return c;
    }
//    public double [][]multiplicaMatriz(double matriz1[][], double matriz2[][])
//    {
//        double matrizR[][]=null;
//        for (int i = 0; i < matriz1.length; i++)
//        {
//            for (int j = 0; j < matriz2[i].length; j++)
//            {
//                for (int k = 0; k < matriz2.length; k++)
//                {
//                     matrizR[i][j]+=matriz1[i][k]*matriz2[k][j];
//                }
//            }
//        }
//        return matrizR;
//    }
    
    public double [][]escalacion(double mat[][], double pfx, double pfy )
    {
        double sx = 3;
        double sy = 3;
        double esca[][]={{sx,0,0},{0,sy,0},{pfx*(1-sx),pfy*(1-sy),1}};
        
        double matR[][]=multiplicaMatriz(mat, esca);
        return matR;
    }
    
    public double [][]traslacionPF(double mat[][])
    {
        double tx=.25;
        double ty=.25;
        double tras[][]={{1,0,0},{0,1,0},{tx,ty,1}};
        double matR[][]=multiplicaMatriz(mat, tras);
        return matR;
    }
    
    public double [][]rotacionPF(double mat [][], double pfx, double pfy, double grados)
    {
        grados = grados *0.0175;
        double cos=Math.cos(grados);
        double sen=Math.sin(grados);
        double rot[][]={{cos, sen,0},{sen,cos,0},{pfx*(1-cos)-pfy*sen,   pfy*(1-cos)+pfx*sen,    1}};
        double matR[][]=multiplicaMatriz(mat, rot);
        return matR;
    }
    
    public double [][]corteX(double mat[][], double shx)
    {
        double corte[][]={{1,0,0},{shx,1,0},{0,0,1}};
        double matR[][]=multiplicaMatriz(mat, corte);
        return matR;
    }
    
    public double [][]corteY(double mat[][],double  shy)
    {
        double corte[][]={{1,shy,0},{0,1,0},{0,0,1}};
        double matR[][]=multiplicaMatriz(mat, corte);
        return matR;
    }
    
    public double [][]refleccionX(double mat[][])
    {
        double refleX[][]={{-1,0,0},{0,1,0},{0,0,1}};
        double matR[][]=multiplicaMatriz(mat, refleX);
        return matR;
    }
    
    public double [][]refleccionY(double mat[][])
    {
        double refleY[][]={{1,0,0},{0,-1,0},{0,0,1}};
        double matR[][]=multiplicaMatriz(mat, refleY);
        return matR;
    }
    
    public double [][]refleccionR(double mat[][])
    {
        double refleR[][]={{0,1,0},{1,0,0},{0,0,1}};
        double  matR[][]=multiplicaMatriz(mat,refleR);
        return matR;
    } 
    
    public double [][]refelccionOrigen(double mat [][])
    {
        double refle[][]={{1,0,0},{0,1,0},{0,0,1}};
        double matR[][]=multiplicaMatriz(mat, refle);
        return matR;
    }
}
