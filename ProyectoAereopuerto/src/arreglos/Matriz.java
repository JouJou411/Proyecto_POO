/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

/**
 *
 * @author Joabp
 */
public class Matriz {

    Object[][] matriz;

    public void add(Object obj, int x) {
        if (obj != null) {
            try {
                if (matriz == null) {
                    matriz = new Object[1][1];
                    matriz[0][0] = obj;
                } else {
                    int aux = getX();
                    if (x < getX()) {
                        if (returnObject(x, getY(x) - 1) == null) {
                            matriz[x][getY(x) - 1] = obj;
                        } else {
                            agrega(obj, getX(), getY() + 1, x, getY(x));
                        }
                    } else {
                        agrega(obj, getX() + 1, getY(), x, 0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    private void agrega(Object obj, int x, int y, int a, int b) {
        Object[][] aux = new Object[x][y];
        int i = 0;
        for (Object[] objects : matriz) {
            System.arraycopy(objects, 0, aux[i], 0, objects.length);
            i++;
        }
        aux[a][b] = obj;
        matriz = aux;
    }

    public int getX() {
        try {
            return matriz.length;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getY() {
        try {
            return matriz[getX() - 1].length;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getY(int x) {
        try {
            return matriz[x].length;
        } catch (Exception e) {
            return 0;
        }
    }

    public Object returnObject(int x, int y) {
        try {
            return matriz[x][y];
        } catch (Exception e) {
            return null;
        }
    }
}
