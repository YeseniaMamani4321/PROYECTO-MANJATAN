/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jhamilr
 * @param <Objeto>
 */
public class BaseDeDatos<Objeto> {

    Connection conexion;
    Objeto objeto;
    public BaseDeDatos() {
        conexion=new Conexion().getConnection();
    }
    public BaseDeDatos(Objeto objeto) {
        this.objeto = objeto;
        conexion=new Conexion().getConnection();
    }

    public void AgregarObjetoBaseDatos() throws Exception{
       
            String sql = camposObjeto();
            sql = "INSERT INTO " + objeto.getClass().getSimpleName().toUpperCase() + " " + sql.toUpperCase() + " VALUES " + getCamposLlenados();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.execute();
        
         
    }
    public void ModificarValorBaseDeDatos(String nombreAtributo, String valor) throws Exception{
        if(valor.equals("")){
            throw new Exception();
        }
        
           Field atributo=objeto.getClass().getDeclaredFields()[0];
            atributo.setAccessible(true);
            String sql="UPDATE "+objeto.getClass().getSimpleName().toUpperCase()+
                    " SET "+nombreAtributo.toUpperCase()+"=\""+valor+"\""
                    +" WHERE "+atributo.getName().toUpperCase()+"=\""+atributo.get(objeto)+"\"";
            Field atributo_objeto=objeto.getClass().getDeclaredField(nombreAtributo);
            atributo_objeto.setAccessible(true);
            if(atributo_objeto.get(objeto) instanceof Integer){
            atributo_objeto.set(objeto, Integer.parseInt(valor));
            }else if(atributo_objeto.get(objeto) instanceof Double)
            {
                atributo_objeto.set(objeto, Double.parseDouble(valor));
            }
            else{
              atributo_objeto.set(objeto, valor);  
            }
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.execute();
        
        
        
    }
    
    public ArrayList<Objeto> ListaObjetos(){
        ArrayList<Objeto> listaObjetos = new ArrayList();
        String sql = "SELECT * FROM "+objeto.getClass().getSimpleName().toUpperCase();
        PreparedStatement ps;
                  ResultSet rs;
        try{
           conexion=new Conexion().getConnection();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                
                Objeto entidad= tipo();
                Field []fields=entidad.getClass().getDeclaredFields();
                for(Field field:fields){
                    field.setAccessible(true);
                    if(field.get(entidad) instanceof Integer){
                    field.set(entidad,rs.getInt(field.getName().toUpperCase()));
                    }
                    else if(field.get(entidad) instanceof Double){
                    field.set(entidad,rs.getDouble(field.getName().toUpperCase()));
                    }
                    else{
                    field.set(entidad,rs.getString(field.getName().toUpperCase()));    
                    }
                }
               listaObjetos.add(entidad);
            }
        }catch(SQLException e) {
            
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjetos;    
    }
    public ArrayList<Objeto> ListaObjetos(String condicion){
        ArrayList<Objeto> listaObjetos = new ArrayList();
        String sql = "SELECT DISTINCT * FROM "+objeto.getClass().getSimpleName().toUpperCase()+" WHERE "+condicion;
        PreparedStatement ps;
                  ResultSet rs;
        try{
           conexion=new Conexion().getConnection();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                
                Objeto entidad= tipo();
                Field []fields=entidad.getClass().getDeclaredFields();
                for(Field field:fields){
                    field.setAccessible(true);
                    if(field.get(entidad) instanceof Integer){
                    field.set(entidad,rs.getInt(field.getName().toUpperCase()));
                    }else if(field.get(entidad) instanceof Double){
                    field.set(entidad,rs.getDouble(field.getName().toUpperCase()));
                    }
                    else{
                    field.set(entidad,rs.getString(field.getName().toUpperCase())); 
                    
                    }
                }
               listaObjetos.add(entidad);
            }
        }catch(SQLException e) {
            
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjetos;    
    }
    public Objeto tipo(){
        try {
            return (Objeto) objeto.getClass().newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private String camposObjeto() {
        String consulta = "";
        Field[] fields = objeto.getClass().getDeclaredFields();
        for (int n = 0; n < fields.length; n++) {
            consulta += fields[n].getName();
            if (n < fields.length - 1) {
                consulta += ",";
            }

        }
        return "("+consulta+")";
    }

    private String getCamposLlenados() {
        String campos = "";
        Field[] fields = objeto.getClass().getDeclaredFields();
        for (int n = 0; n < fields.length; n++) {
            try {
                fields[n].setAccessible(true);
                campos+="\""+fields[n].get(objeto)+"\"";
                if (n < fields.length - 1) {
                    campos += ",";
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
               ex.printStackTrace();
            }

        }
        return "("+campos+")";
    }
    public void close(){
         try {
           conexion.close();
           } catch (SQLException ex) {
            
           }
    }
    public void eliminarObjetoBaseDeDatos() throws SQLException{
        try {
            Field atributo=objeto.getClass().getDeclaredFields()[0];
            atributo.setAccessible(true);
            String sql = "DELETE FROM "+objeto.getClass().getSimpleName().toUpperCase()+" WHERE "+atributo.getName()+" = '"+atributo.get(objeto)+"'";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.execute();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
    public void cambiarValorAutoIncremento(int valor){
         try {
            Field atributo=objeto.getClass().getDeclaredFields()[0];
            atributo.setAccessible(true);
            String sql = "ALTER TABLE "+objeto.getClass().getSimpleName().toUpperCase()+" AUTO_INCREMENT ="+ valor;
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.execute();
         } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
