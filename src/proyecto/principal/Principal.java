/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.principal;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proyecto.controlador.InicioSesionController;
import proyecto.modelo.BaseDeDatos;

import proyecto.modelo.Entidades.Administrador;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author jhamilr
 */
public class Principal extends Application {

    /**
     * @param args the command line arguments
     */
    private LibreriaGrafica libreriaGrafica=new LibreriaGrafica();
    public static void main(String[] args) {
  
          
          launch(args);
    }

    @Override
    public void start(Stage stage) {
        try{
        Parent root = libreriaGrafica.cargarGrafico("/proyecto/vista/InicioSesion.fxml");
        InicioSesionController controlInicioSecion=(InicioSesionController)libreriaGrafica.getCargador().getController();
        controlInicioSecion.setPrincipal(stage);
        Scene escena=new Scene(root);
        stage.setScene(escena);
        stage.setTitle("Inicio sesion");
        stage.show();
        }catch(Exception es){
            
        }
    }
    
}
