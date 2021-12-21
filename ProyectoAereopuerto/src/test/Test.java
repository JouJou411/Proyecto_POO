/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import arreglos.Arreglo;
import domain.Boletos;

/**
 *
 * @author Joabp
 */
public class Test {
    public static void main(String[] args) {
        Arreglo a = new Arreglo();
        Boletos b = new Boletos();
        System.out.println(a.length());
        a.returnObject(2);
        a.add(b);
        a.add(b);
        a.add(b);
        a.remove(2);
        a.returnObject(1);
    }
}
