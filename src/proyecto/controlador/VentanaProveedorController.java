/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import proyecto.modelo.BaseDeDatos;

/**
 *
 * @author jhamilr
 */
public class VentanaProveedorController implements Initializable{
  
    
    @FXML
    private TextField apellido_registro_proveedor;

    @FXML
    private TextField carnet_proveedor_eliminable;

    @FXML
    private TextField carnet_referencia_apellido;

    @FXML
    private TextField carnet_referencia_carnet;

    @FXML
    private TextField carnet_referencia_direccion;

    @FXML
    private TextField carnet_referencia_nombre;

    @FXML
    private TextField carnet_referencia_telefono;

    @FXML
    private TextField carnet_registro_proveedor;

    @FXML
    private TextField direccion_registro_proveedor;

    @FXML
    private TextField nombre_registro_proveedor;

    @FXML
    private TextField nueva_direccion;

    @FXML
    private TextField nuevo_apellido;

    @FXML
    private TextField nuevo_carnet;

    @FXML
    private TextField nuevo_nombre;

    @FXML
    private TextField nuevo_telefono;

    @FXML
    private TextField telefono_registro_proveedor;

    @FXML
    private TextArea vista_lista_proveedores;
    //BaseDeDatos<Proveedor> basedeDatos;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*")) {
                return change;
            }

            return null;
        };
        TextFormatter<String> formatoEntero = new TextFormatter<>(filter);
       telefono_registro_proveedor.setTextFormatter(formatoEntero);
       formatoEntero=new TextFormatter<>(filter);
       nuevo_telefono.setTextFormatter(formatoEntero);
    }
    
    @FXML
    void actualizar_apellido(MouseEvent event) {

    }

    @FXML
    void actualizar_direccion(MouseEvent event) {

    }

    @FXML
    void actualizar_telefono(MouseEvent event) {

    }

    @FXML
    void agregarproveedor(MouseEvent event) {
        
    }

    @FXML
    void cambiar_nombre(MouseEvent event) {

    }

    @FXML
    void eliminar_proveedor(MouseEvent event) {

    }

    @FXML
    void mostrar_lista_proveedores(MouseEvent event) {

    }
    
}
