/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

import javax.swing.JOptionPane;

/**
 * Matriz dinamica
 * https://github.com/JouJou411
 * @author Joab Jaaziel Pulido Ambriz 
 */
public class Matriz {

    Object[][] matriz;

    /**
     * añade el objeto en una matriz
     *
     * @param obj Objeto a agregar
     * @param x Posicion que ocupara en la matriz
     */
    public void add(Object obj, int x) {
        if (obj != null) {
            try {
                if (matriz == null) {
                    matriz = new Object[1][1];
                    matriz[0][0] = obj;
                } else {
                    if (x < getX()) {
                        if (returnObject(x, getY(x) - 1) == null) {
                            int b = 0;
                            boolean c = true;
                            do {
                                for (Object object : matriz[x]) {
                                    if (object == null) {
                                        matriz[x][b] = obj;
                                        c = false;
                                        break;
                                    }
                                    b++;
                                }
                            } while (c);
                        } else {
                            agrega(obj, getX(), getY() + 1, x, getY(x));
                        }
                    } else {
                        agrega(obj, getX() + 1, getY(), x, -1);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        }
    }

    private void agrega(Object obj, int x, int y, int a, int b) {
        Object[][] aux = new Object[x][y];
        int i = 0;
        boolean c = true;
        for (Object[] objects : matriz) {
            System.arraycopy(objects, 0, aux[i], 0, objects.length);
            i++;
        }
        do {
            if (returnObject(a, b) == null && b != 0) {
                if (b <= 0) {
                    aux[a][b + 1] = obj;
                    c = false;
                }
                b--;
            } else {
                aux[a][b + 1] = obj;
                c = false;
            }
        } while (c);
        matriz = aux;
    }

    /**
     * Retorna la longitud de la matriz en posicion X
     *
     * @return
     */
    public int getX() {
        try {
            return matriz.length;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Retorna la longitud de la matriz en posicion Y usando la ultima posicion
     * de X
     *
     * @return
     */
    public int getY() {
        try {
            return matriz[getX() - 1].length;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Retorna la longitud de Y de acuerdo a la posicion de X
     *
     * @param x Posicion de la cual quieres saber la longitud
     * @return
     */
    public int getY(int x) {
        try {
            return matriz[x].length;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Retorna el objeto de la matriz
     *
     * @param x Posicion de X
     * @param y Posicion de Y
     * @return
     */
    public Object returnObject(int x, int y) {
        try {
            return matriz[x][y];
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Elimina el objeto en la posicion en X y Y
     *
     * @param x Posicion de X
     * @param y Posicion de Y
     */
    public void remove(int x, int y) {
        try {
            Object[][] aux = matriz;
            aux[x][y] = null;
            matriz = new Object[1][1];
            for (int i = 0; i < aux.length; i++) {
                for (Object obj : aux[i]) {
                    add(obj, i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el objeto, verificar que los datos esten correctos");
        }
    }
}
