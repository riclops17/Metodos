/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricardo
 */

public class metodoBiseccion {
    public static void main(String[] args) {      
        System.out.println(raiz(1.5,1.7,0.01) );            
        }
    
    public static double funcion(double x){
       double res;
        res = x*x*x-2*x-1;
       return res;
    }
    public static double raiz(double a , double b ,double err){
        double r;
        r = (a +b) / 2;
        while((Math.abs(a-b)>=err)&& (Math.abs(funcion(r))>= err)){
            r = (a+b)/2;
            r = funcion(r);
            if (funcion(a)*funcion(b)< 0){
                b = r;
            }else{
                a = r;
            }
           
    }
        
            
        return r;
    }
}
