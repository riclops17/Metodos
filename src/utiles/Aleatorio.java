/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author riclops
 */
public class Aleatorio {

    public static double doubleAleatorio(int min, int max) {
        return Math.random() * (max - min) + min;
    }

    public static int intAleatorio(int min, int max) {
        return (int) doubleAleatorio(min, max);
    }

    public static char charAleatorio() {
        char a;
        if (Math.random() >= 0.5) {
            a = (char) intAleatorio(97, 123);
        } else {
            a = (char) intAleatorio(65, 91);
        }
        return a;
    }

    public static String stringAleatorio(int tam) {
        String res = "";
        for (int i = 0; i < tam; i++) {
            res = res + charAleatorio();
        }
        return res;
    }

    public static int tipoAleatorio() {
        int a;
        double b = Math.random();

        if (b < 0.2) {
            a = 20;
        } else {
            if (b < 0.4) {
                a = 23;

            } else {
                if (b < 0.6) {
                    a = 27;
                } else {
                    if (b < 0.8) {
                        a = 30 ;
                    } else {
                        a = 33;
                    }
                }

                }
                
            }
        return a;
        }
}
