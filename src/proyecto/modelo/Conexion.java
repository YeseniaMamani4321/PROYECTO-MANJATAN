/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jhamilr
 */
public class Conexion {
 Connection con;
    public Connection getConnection(){
        try{
            String myBD = "jdbc:mariadb://localhost:3306/proyecto _final_programacion";
            con = DriverManager.getConnection(myBD,"root","");
            return con;
        }catch (SQLException e){
            System.out.print(e.toString());                  
        }
        return null;
    }
    
    
}