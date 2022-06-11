/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo.Entidades;

import Logica.Impresion;
import Logica.Libreria;

/**
 *
 * @author jhamilr
 */
public class Proveedor implements Impresion  {
    private String ci;
    private String nombre;
    private String apellido;
    private String direccion;
    private String gmail;
    private int telefono;

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String imprimible() {
    return Libreria.getCharacteristics(false,"PROVEEDOR",
                           "ci:        "+this.ci,
                           "nombre:    "+this.nombre,
                           "apellido:  "+this.apellido,
                           "direccion: "+this.direccion,
                           "telefono:  "+this.telefono,
                           "gmail:     "+this.gmail);
    }
    
}
