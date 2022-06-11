/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jhamilr
 */
public class AbridorVentanas <Control>{
   FXMLLoader cargador;
    Scene escena;
    Stage ventana;
    Parent fxml;
    
    public AbridorVentanas(String direccion) {
        ventana=new Stage();
        cargador=new FXMLLoader();
       try {
           cargador.setLocation(getClass().getResource(direccion));
           fxml=cargador.load();
           escena=new Scene(fxml);
       } catch (IOException ex) {
           Logger.getLogger(AbridorVentanas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 
    public void abrirVentana(String nombre) {
        ventana.setTitle(nombre);
        Application aplicacion=new Application() {
            @Override
            public void start(Stage stage) throws Exception {
                stage.setScene(escena);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            }
        };
       try {
           aplicacion.start(ventana);
       } catch (Exception ex) {
           Logger.getLogger(AbridorVentanas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public Control getControlador(){
       return  cargador.getController();
    }

    public Parent getFxml() {
        return fxml;
    }

    public void setFxml(Parent fxml) {
        this.fxml = fxml;
    }

    public Stage getVentana() {
        return ventana;
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }
    
    
}
