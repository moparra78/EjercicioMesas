/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesas;

import javax.swing.JOptionPane;
import java.lang.reflect.Array;

/**
 *
 * @author Monica
 */
public class OrganizadorSillas {

    public static int contarFormas(int[] a, int k){
         int forma=1, x=1, y=1, z=0, valor=1, valor2=1, auxiliar1=1, auxiliar2=1;
         while (z < a.length){
             auxiliar1= (int) Math.pow(2, (int) Array.get(a, z));
             forma=forma*auxiliar1;
             z++;
         }

         if(a.length>k){
             x=a.length;
             y=x-k;
             while(x!=0){
                 valor=valor*x;
                 x--;
             }
             while(y!=0){
                 valor2=valor2*y;
                 y--;
             }
             auxiliar2=valor/valor2;
             forma=(forma*2)+auxiliar2;
         }
         else{
             auxiliar2=a.length-1;
             forma =(forma+auxiliar2)*k;
         }
         return forma;
     }
    
    public static void main(String[] args) {

        int k = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de mesas: "));
        if(k<1 || k>1000){
            System.out.print("El número de mesas debe ser entre 1 y 1000 \n");
        }
        else {
            int familia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de familias: "));
            if(familia<1 || familia>1000){
                System.out.print("La cantidad de familias debe ser entre 1 y 1000 \n");
            }
            else {
                int a[] = new int[familia];

                for (int i = 0; i < familia; i++) {
                    int hijos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de hijos de la familia " + (i + 1)));
                    if(hijos<1 || hijos>1000){
                        System.out.print("La cantidad de hijos debe ser entre 1 y 1000 \n");
                    }
                    else{
                        a[i] = hijos;}
                }

                int contar = contarFormas(a, k);
                
                /*JOptionPane.showMessageDialog( + contar);*/
                System.out.print("Formas posibles: " + contar);
                System.out.print(" \n");
            }
        }
    }    
}

