package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joabp
 */
public class Boletos implements Serializable {

    private String fecha;
    private String folio;
    private String vuelo;
    private String nombre;
    private String apellidoP;
    private String apellidoS;
    private double precio;
    private static final long serialVersionUID = 1L;

    public Boletos() {
    }

    public Boletos(String vuelo, String nombre, String apellidoP, String apellidoS, double precio) {
        this.vuelo = vuelo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoS = apellidoS;
        this.precio = precio;
        this.fecha = setTiempo();
        this.folio = setFolio();
    }

    private String setTiempo() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now());
    }

    private String setFolio() {
        if (serialVersionUID < 10) {
            return "F000" + String.valueOf(serialVersionUID);
        } else {
            if(serialVersionUID < 100){
                return "F00" + String.valueOf(serialVersionUID);
            } else {
                if(serialVersionUID < 1000){
                    return "F0" + String.valueOf(serialVersionUID);
                } else {
                    return "F" + String.valueOf(serialVersionUID);
                }
            }
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoS() {
        return apellidoS;
    }

    public void setApellidoS(String apellidoS) {
        this.apellidoS = apellidoS;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
