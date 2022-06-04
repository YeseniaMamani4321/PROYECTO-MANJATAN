/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo.Entidades;

import java.util.Date;

/**
 *
 * @author jhamilr
 */
public class Cliente {
    String cod_cliente;
    String CI;
    String NOMBRE;
    String APELLIDO; 
    String MAIL;
    int TELEFONO;
    String DIRECCION;
    String HORA_ENTREGA;

    public String getCOD_CLIENTE() {
        return cod_cliente;
    }

    public void setCOD_CLIENTE(String COD_CLIENTE) {
        this.cod_cliente = COD_CLIENTE;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getHORA_ENTREGA() {
        return HORA_ENTREGA;
    }

    public void setHORA_ENTREGA(String HORA_ENTREGA) {
        this.HORA_ENTREGA = HORA_ENTREGA;
    }
    public String toString(){
        return "codigo:<"+cod_cliente+"> nombre:<"+NOMBRE+"> apellido:"+APELLIDO;
    }
    
}
