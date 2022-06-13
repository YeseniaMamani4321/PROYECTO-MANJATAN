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
import proyecto.vista.AbridorVentanas;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author luisf
 */
public class InicioSesionController implements Initializable {
    LibreriaGrafica libreria;
    BaseDeDatos<Administrador> bdAdministrador;
    ArrayList<Administrador> administradores;
    Administrador admin;
       
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        admin=new Administrador();
         bdAdministrador=new BaseDeDatos<Administrador>(admin);
        administradores=bdAdministrador.ListaObjetos();
        libreria=new LibreriaGrafica();
        if(administradores.isEmpty()){
            libreria.MostrarInformacion("No existe ningun administrador registrado");
            if(libreria.ObtenerConfirmacion("¿Desea registrar un nuevo administrador?").get()==ButtonType.OK){
                //Open to menu for Administrador
                AbridorVentanas<GestionAdministradorController> abridorVentanas=new AbridorVentanas<>("/proyecto/vista/GestionAdministrador.fxml");
                abridorVentanas.abrirVentana("Gestion Administrador");
                if(abridorVentanas.getControlador().getAdministrador()==null){
                    principal.close();
                }
            }
            else{
                libreria.MostrarInformacion("Cerrando sistema");
                bdAdministrador.close();
                principal.close();
            }
        }
        
    }    
    
    @FXML
    private Button botonAcceder;
    
    @FXML
    private PasswordField contraseña;

    @FXML
    private TextField usuario;
    private Stage principal;
    @FXML
    void acceder(MouseEvent event) {
        
            administradores=bdAdministrador.ListaObjetos();
            Administrador administrador=null;
            for(int n=0; n<administradores.size(); n++){
                
               administrador=administradores.get(n);
               if(administrador.getCarnet().equals(usuario.getText().toUpperCase())&&administrador.getContrasena().equals(contraseña.getText())){
                      n=administradores.size();
               } 
               else{
                       administrador=null;
                       
                       }
            }
            if(administrador==null){
                libreria.MostrarInformacion("Usuario o contraseña incorrectos");
            }else{
                AbridorVentanas<MenuPrincipalController> abridorVentanas=new AbridorVentanas<>("/proyecto/vista/MenuPrincipal.fxml");
                abridorVentanas.getControlador().setPrincipal(abridorVentanas.getVentana());
                abridorVentanas.abrirVentana("Menu Principal");
                principal.close();
            }
            
        
        
    }
    

    public Stage getPrincipal() {
        return principal;
    }

    public void setPrincipal(Stage principal) {
        this.principal = principal;
    }

  

   
    
}
