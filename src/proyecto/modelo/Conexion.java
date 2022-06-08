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
            String myBD = "jdbc:mariadb://localhost:3033/PROYECTO _FINAL_PROGRAMACION";
            con = DriverManager.getConnection(myBD,"root","sopadegato123");
            return con;
        }catch (SQLException e){
            System.out.print(e.toString());                  
        }
        return null;
    }
    
    
}
