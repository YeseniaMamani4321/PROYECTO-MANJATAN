/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Administrador;
import proyecto.vista.AbridorVentanas;

/**
 *
 * @author jhamilr
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private AnchorPane ventana;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void abrir_ventana_proveedores(MouseEvent event) {
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void abrir_gestor_administrador(MouseEvent event) {
        abrir_ventana_administrador();
    }

    @FXML
    void agregar_proveedor(ActionEvent event) {
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
         abrirVentana.getControlador().getProveedores_ventana()
                 .getSelectionModel()
                 .select(abrirVentana
                         .getControlador()
                         .getProveedor_agregar());
         ventana.getChildren().add(abrirVentana.getFxml());
    }

    @FXML
    void eliminar_producto(ActionEvent event) {

    }

    @FXML
    void eliminar_proeveedor(ActionEvent event) {
         AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
         abrirVentana.getControlador().getProveedores_ventana()
                 .getSelectionModel()
                 .select(abrirVentana
                         .getControlador()
                         .getProveedor_eliminar());
         ventana.getChildren().add(abrirVentana.getFxml());
       
    }

    @FXML
    void modificar_producto(ActionEvent event) {

    }

    @FXML
    void modificar_proveedor(ActionEvent event) {
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
         abrirVentana.getControlador().getProveedores_ventana()
                 .getSelectionModel()
                 .select(abrirVentana
                         .getControlador()
                         .getProveedor_modificar());
         ventana.getChildren().add(abrirVentana.getFxml());
    }

    @FXML
    void modificar_administrador(ActionEvent event) {
        abrir_ventana_administrador();
    }

    @FXML
    void registrar_producto(ActionEvent event) {

    }

    @FXML
    void salir_sistema(ActionEvent event) {

    }

    @FXML
    void ver_lista_productos(ActionEvent event) {

    }

    @FXML
    void ver_lista_proveedor(ActionEvent event) {
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
         abrirVentana.getControlador().getProveedores_ventana()
                 .getSelectionModel()
                 .select(abrirVentana
                         .getControlador()
                         .getProveedores_ver());
         ventana.getChildren().add(abrirVentana.getFxml());

    }

    public void abrir_ventana_administrador() {
        AbridorVentanas<GestionAdministradorController> VentanaAdministrador = new AbridorVentanas<>("/proyecto/vista/GestionAdministrador.fxml");
        Administrador administrador_modificable = new Administrador();
        BaseDeDatos<Administrador> baseDeDatosadministrador = new BaseDeDatos<>(administrador_modificable);
        administrador_modificable = baseDeDatosadministrador.ListaObjetos().get(0);
        VentanaAdministrador.getControlador().getVentanaRegistrar().setDisable(true);
        VentanaAdministrador.getControlador().setAdministrador(administrador_modificable);
        Tab ventana_modificar = VentanaAdministrador.getControlador().getVentanaModificar();
        ventana_modificar.setDisable(false);
        VentanaAdministrador.getControlador().getVentana_seleccion().getSelectionModel().select(ventana_modificar);
        ventana.getChildren().add(VentanaAdministrador.getFxml());
        baseDeDatosadministrador.close();
    }
}
