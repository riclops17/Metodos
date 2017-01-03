/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author ricardo
 */
public class NewtonGrado1 {
    public static void main(String[] args) {
        double x0 ,x1,fx1,fx0 , x;
        x0 = 3;
        x1= 4;
        fx1= 4.2;
        fx0= 3.1;
        x = 3.5;
        System.out.println(calcularPolinomio(fx1,fx0,x0,x1,x));
                
    }
    public static double fx1x0(double fx1 , double fx0,double x0 , double x1){
        double res;
        res = (fx1 - fx0)/ (x1 -x0);
        return res;
    }
    public static  double calcularPolinomio(double fx1 , double fx0,double x0 , double x1 , double x){
        double p;
        p = fx0 + (x - x0)*fx1x0(fx1,fx0,x0,x1);
        return p;      
    }
}
