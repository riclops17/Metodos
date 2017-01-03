/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import utiles.TecladoIn;
import java.text.DecimalFormat;

/**
 *
 * @author german
 */
public class newtonR {

    private double[] x;  //datos x
    private double[] y;  // datos y
    private int longitud; // cantidad de elem
    double[][] matrizCoef;    //matriz de los coeficientes
    double[] terminosIndep;      //tÃ©rminos independientes
    public double[] polinomio; //polinomio   a[0]+a[1]Â·x+a[2]Â·x2+...
    public int grado; //grado del polinomio

    public Metodos(double[] x, double[] y, int grado) {
        this.x = x;
        this.y = y;
        longitud = x.length;// cantidad de terminos
        this.grado = grado;
        terminosIndep = new double[grado + 1];
        matrizCoef = new double[grado + 1][grado + 1];
        polinomio = new double[grado + 1];
    }

    //metodo para generar la matriz de coeficientes
    private void coeficientes() {
        double[] s = new double[2 * grado + 1];

        double suma;
        //genero arreglo con las sumatorias 
        for (int k = 0; k <= 2 * grado; k++) {
            suma = 0.0;
            for (int i = 0; i < longitud; i++) {
                suma += potencia(x[i], k);
            }
            s[k] = suma;
        }
        //genero arreglo sumatoria de los terminos independientes
        for (int k = 0; k <= grado; k++) {
            suma = 0.0;
            for (int i = 0; i < longitud; i++) {
                suma += potencia(x[i], k) * y[i];
            }
            terminosIndep[k] = suma;
        }
        //genero matriz de coeficientes 
        for (int i = 0; i <= grado; i++) {
            for (int j = 0; j <= grado; j++) {
                matrizCoef[i][j] = s[i + j];
            }
        }
    }
     public static void mostrarArreglo(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "|");
        }
    }

    //metodo calcula potencia 
    private double potencia(double base, int exp) {
        double producto = 1.0;
        for (int i = 0; i < exp; i++) {
            producto *= base;
        }
        return producto;
    }

    //calcula el polinomio 
    public void gauss() {
        coeficientes();
        int k = 0;
        int i, j;
        double s = 0;
        double m;
        while (k <= grado - 1) {
            i = k + 1;
            while (i <= grado) {
                j = k + 1;
                m = -(matrizCoef[i][k]) / matrizCoef[k][k];

                while (j <= grado) {
                    matrizCoef[i][j] = matrizCoef[i][j] + (m * matrizCoef[k][j]);
                    j++;
                }
                terminosIndep[i] = terminosIndep[i] + (m * terminosIndep[k]);
                i++;
            }
            k++;
        }
        polinomio[grado] = terminosIndep[grado] / matrizCoef[grado][grado];
        System.out.println("a" + grado + ": " + polinomio[grado]);
        i = grado - 1;
        while (i >= 0) {
            j = i + 1;
            s = 0;
            while (j <= grado) {
                s = s + (matrizCoef[i][j] * polinomio[j]);
                j = j + 1;
            }
            polinomio[i] = (terminosIndep[i] - s) / matrizCoef[i][i];
            System.out.println("a" + i + ": " + polinomio[i]);
            i = i - 1;
        }

    }

    public String mostrarPolinomio() {
        String dato = "";
        DecimalFormat decimales = new DecimalFormat("0.0000");
        for (int i = (polinomio.length - 1); i >= 0; i--) {
            if (i != 0) {
                System.out.print(decimales.format(polinomio[i]) + " X^" + i + " + ");
            } else {
                System.out.print(decimales.format(polinomio[i]));
            }
        }
        return dato;
    }

    public void mostrarMatriz(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "|");

            }
            System.out.println("");

        }
    }

    public void calcular(int punto) {
        double aprox = 0.0;
        DecimalFormat decimales = new DecimalFormat("0.0000");
        for (int i = (polinomio.length - 1); i >= 0; i--) {
            aprox += polinomio[i] * potencia(punto, i);
        }
        System.out.println("aprox " + decimales.format(aprox));
    }
}

class prueba {

    public static void main(String[] args) {
        double[] x = {55,70,85,100, 120, 140};
        double[] y = {14.08, 13.56, 13.28 ,12.27 ,11.3 ,10.4};
        int punto;
        Metodos prueba = new Metodos(x, y, 1);
        prueba.gauss();
        System.out.println(prueba.mostrarPolinomio());
        System.out.println("ingrese valor a aproximar : ");
        punto = TecladoIn.readLineInt();
        prueba.calcular(punto);

    }
}
