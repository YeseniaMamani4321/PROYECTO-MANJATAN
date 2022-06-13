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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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

    @FXML
    private Button boton_administrador;

    @FXML
    private Button boton_productos;

    @FXML
    private Button boton_proveedor;
    Stage principal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void abrir_ventana_proveedores(MouseEvent event) {
        cambiarColorBoton(boton_proveedor);
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void abrir_gestor_administrador(MouseEvent event) {
        cambiarColorBoton(boton_administrador);
        abrir_ventana_administrador();
    }

    @FXML
    void agregar_proveedor(ActionEvent event) {
        cambiarColorBoton(boton_proveedor);
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
        abrirVentana.getControlador().getProveedores_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getProveedor_agregar());
        ventana.getChildren().add(abrirVentana.getFxml());
    }

    @FXML
    void abrir_ventana_productos(MouseEvent event) {
        cambiarColorBoton(boton_productos);
        AbridorVentanas<GestionProductoController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/GestionProductos.fxml");
        abrirVentana.getControlador().setVentana(abrirVentana.getVentana());
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void eliminar_producto(ActionEvent event) {
        cambiarColorBoton(boton_productos);
        AbridorVentanas<GestionProductoController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/GestionProductos.fxml");
        abrirVentana.getControlador().getProductos_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getEliminar_producto());
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void eliminar_proeveedor(ActionEvent event) {
        cambiarColorBoton(boton_proveedor);
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
        cambiarColorBoton(boton_productos);
        AbridorVentanas<GestionProductoController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/GestionProductos.fxml");
        abrirVentana.getControlador().getProductos_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getModificar_producto());
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void modificar_proveedor(ActionEvent event) {
        cambiarColorBoton(boton_proveedor);
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
        cambiarColorBoton(boton_administrador);
        abrir_ventana_administrador();
    }

    @FXML
    void registrar_producto(ActionEvent event) {
        cambiarColorBoton(boton_productos);
        AbridorVentanas<GestionProductoController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/GestionProductos.fxml");
        abrirVentana.getControlador().getProductos_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getAgregar_producto());
        ventana.getChildren().add(abrirVentana.getFxml());
    }

    @FXML
    void salir_sistema(ActionEvent event) {
        principal.close();
    }

    @FXML
    void salir_sistema_menu(MouseEvent event) {
        principal.close();
    }

    @FXML
    void ver_lista_productos(ActionEvent event) {
        cambiarColorBoton(boton_productos);
        AbridorVentanas<GestionProductoController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/GestionProductos.fxml");
        abrirVentana.getControlador().getProductos_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getVer_lista_producto());
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    @FXML
    void ver_lista_proveedor(ActionEvent event) {
        cambiarColorBoton(boton_proveedor);
        AbridorVentanas<VentanaProveedorController> abrirVentana = new AbridorVentanas<>("/proyecto/vista/VentanaProveedor.fxml");
        abrirVentana.getControlador().getProveedores_ventana()
                .getSelectionModel()
                .select(abrirVentana
                        .getControlador()
                        .getProveedores_ver());
        ventana.getChildren().add(abrirVentana.getFxml());

    }

    public void abrir_ventana_administrador() {
        cambiarColorBoton(boton_administrador);
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

    public Stage getPrincipal() {
        return principal;
    }

    public void setPrincipal(Stage principal) {
        this.principal = principal;
    }

    private void cambiarColorBoton(Button boton) {
        Button[] botones = {boton_administrador, boton_productos, boton_proveedor};
        for (Button boto : botones) {
            if (boto.equals(boton)) {
                boto.setStyle("-fx-background-color: #3f47ba;");
            } else {
                boto.setStyle("-fx-background-color: #7178df;");
            }
        }
    }

}
