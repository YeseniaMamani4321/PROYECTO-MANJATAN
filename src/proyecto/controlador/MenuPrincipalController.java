/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Administrador;
import proyecto.vista.AbridorVentanas;

/**
 *
 * @author jhamilr
 */
public class MenuPrincipalController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void abrir_ventana_proveedores(MouseEvent event) {
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
        abrirVentana.abrirVentana("proveedores");
    }

    @FXML
    void abrir_gestor_administrador(MouseEvent event) {
        Administrador administrador_modificable=new Administrador();
        BaseDeDatos<Administrador>baseDeDatos=new BaseDeDatos<>(administrador_modificable);
        administrador_modificable=baseDeDatos.ListaObjetos().get(0);
        AbridorVentanas<GestionAdministradorController> abridorVentanas = new AbridorVentanas<>("/proyecto/vista/GestionAdministrador.fxml");
        abridorVentanas.getControlador().getVentanaRegistrar().setDisable(true);
        abridorVentanas.getControlador().setAdministrador(administrador_modificable);
        Tab ventana_modificar=abridorVentanas.getControlador().getVentanaModificar();
        ventana_modificar.setDisable(false);
        abridorVentanas.getControlador().getVentana_seleccion().getSelectionModel().select(ventana_modificar);
        abridorVentanas.abrirVentana("Gestion Administrador");
    }

}
