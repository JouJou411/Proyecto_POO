package arreglos;

import javax.swing.JOptionPane;

/**
 *
 * @author Joabp
 */
public class Arreglo {

    private Object[] arreglo;

    public void add(Object object) {
        if (object != null) {
            try {
                if(arreglo == null){
                    arreglo = new Object[1];
                    arreglo[0] = object;
                } else {
                    Object[] aux = new Object[arreglo.length+1];
                    System.arraycopy(arreglo, 0, aux, 0, arreglo.length);
                    aux[aux.length-1] = object;
                    arreglo = aux;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error no se ah podido ingresar el objeto en el arreglo");
            }
        }
    }

    public int length() {
        try {
            return arreglo.length;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public void remove(int x){
        try {
            Object[] aux = arreglo;
        arreglo = new Object[0];
        aux[x]=null;
        for(Object obj : aux){
            add(obj);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se logro eliminar el objeto del arreglo");
        }
    }
    
    public Object returnObject(int x){
        try {
            return arreglo[x];
        } catch (Exception e) {
            return null;
        }
    }
}
