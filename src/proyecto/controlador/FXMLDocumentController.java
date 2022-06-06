/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Administrador;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author luisf
 */
public class FXMLDocumentController implements Initializable {
    LibreriaGrafica libreria;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        libreria=new LibreriaGrafica();
    }    
    
    @FXML
    private Button botonAcceder;
    
    @FXML
    private PasswordField contrasenia;

    @FXML
    private TextField usuario;
    private Stage principal;
    @FXML
    void acceder(MouseEvent event) {
        Administrador admin=new Administrador();
        BaseDeDatos<Administrador> bdAdministrador=new BaseDeDatos<Administrador>(admin);
        ArrayList<Administrador> administradores=bdAdministrador.ListaObjetos();
        
        if(administradores.isEmpty()){
            libreria.MostrarInformacion("No existe ningun administrador registrado");
            if(libreria.ObtenerConfirmacion("¿Desea registrar un nuevo administrador?").get()==ButtonType.OK){
                //Open to menu for Administrador
            }
            else{
                libreria.MostrarInformacion("Cerrando sistema");
                bdAdministrador.close();
                principal.close();
            }
        }
        else{
            Administrador administrador=null;
            for(int n=0; n<administradores.size(); n++){
                
               administrador=administradores.get(n);
               if(administrador.getCarnet().equals(usuario.getText().toUpperCase())&&administrador.getContrasena().equals(contrasenia.getText())){
                      n=administradores.size();
               } 
               else{
                       administrador=null;
                       }
            }
            if(administrador==null){
                libreria.MostrarInformacion("No se encontro al administrador");
            }else{
                principal.close();
            }
            
        }
        
    }
    

    public Stage getPrincipal() {
        return principal;
    }

    public void setPrincipal(Stage principal) {
        this.principal = principal;
    }

  

   
    
}
