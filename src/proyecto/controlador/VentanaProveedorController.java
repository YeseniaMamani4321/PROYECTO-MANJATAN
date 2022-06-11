/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Proveedor;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author jhamilr
 */
public class VentanaProveedorController implements Initializable {

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
    private TextField carnet_referencia_gmail;

    @FXML
    private TextField carnet_referencia_nombre;

    @FXML
    private TextField carnet_referencia_telefono;

    @FXML
    private TextField carnet_registro_proveedor;

    @FXML
    private TextField direccion_registro_proveedor;

    @FXML
    private TextField gmail_registro;

    @FXML
    private TextField nombre_registro_proveedor;

    @FXML
    private TextField nueva_direccion;

    @FXML
    private TextField nuevo_apellido;

    @FXML
    private TextField nuevo_carnet;

    @FXML
    private TextField nuevo_gmail;

    @FXML
    private TextField nuevo_nombre;

    @FXML
    private TextField nuevo_telefono;

    @FXML
    private TextField telefono_registro_proveedor;
    @FXML
    private TableView<?> ListaProveedor;

    BaseDeDatos<Proveedor> basedeDatos;

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
        formatoEntero = new TextFormatter<>(filter);
        nuevo_telefono.setTextFormatter(formatoEntero);
        formatoTabla();
    }

    @FXML
    void actualizar_apellido(MouseEvent event) {
        if (buscarProveedor(carnet_referencia_apellido.getText())) {
            try {
                Proveedor proveedor = new Proveedor();
                proveedor.setCi(carnet_referencia_apellido.getText());
                basedeDatos = new BaseDeDatos<>(proveedor);
                basedeDatos.ModificarValorBaseDeDatos("apellido", nuevo_apellido.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void actualizar_direccion(MouseEvent event) {
        if (buscarProveedor(carnet_referencia_direccion.getText())) {
            try {
                Proveedor proveedor = new Proveedor();
                proveedor.setCi(carnet_referencia_direccion.getText());
                basedeDatos = new BaseDeDatos<>(proveedor);
                basedeDatos.ModificarValorBaseDeDatos("direccion", nueva_direccion.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void actualizar_gmail(MouseEvent event) {
        if (buscarProveedor(carnet_referencia_gmail.getText())) {
            try {
                Proveedor proveedor = new Proveedor();
                proveedor.setCi(carnet_referencia_gmail.getText());
                basedeDatos = new BaseDeDatos<>(proveedor);
                basedeDatos.ModificarValorBaseDeDatos("gmail", nuevo_gmail.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void actualizar_telefono(MouseEvent event) {
        if (buscarProveedor(carnet_referencia_telefono.getText())) {
            try {
                Proveedor proveedor = new Proveedor();
                proveedor.setCi(carnet_referencia_telefono.getText());
                basedeDatos = new BaseDeDatos<>(proveedor);
                basedeDatos.ModificarValorBaseDeDatos("telefono", nuevo_telefono.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void actualizar_carnet_proveedor(MouseEvent event) {
        if (buscarProveedor(carnet_referencia_carnet.getText())) {
            try {
                Proveedor proveedor = new Proveedor();
                proveedor.setCi(carnet_referencia_carnet.getText());
                basedeDatos = new BaseDeDatos<>(proveedor);
                basedeDatos.ModificarValorBaseDeDatos("ci", nuevo_carnet.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void agregarproveedor(MouseEvent event
    ) {
        Proveedor proveedor_agregable = new Proveedor();
        proveedor_agregable.setCi(carnet_registro_proveedor.getText());
        proveedor_agregable.setApellido(apellido_registro_proveedor.getText());
        proveedor_agregable.setNombre(nombre_registro_proveedor.getText());
        if (gmail_registro.getText().contains("@")) {
            proveedor_agregable.setGmail(gmail_registro.getText());
            proveedor_agregable.setDireccion(direccion_registro_proveedor.getText());
            proveedor_agregable.setTelefono(Integer.parseInt(telefono_registro_proveedor.getText()));
            basedeDatos = new BaseDeDatos<>(proveedor_agregable);
            basedeDatos.AgregarObjetoBaseDatos();
            limpiarPantallaRegistro();
        } else {
            new LibreriaGrafica().MostrarError("su correo no cincide con el formato");
        }

    }

    @FXML
    void cambiar_nombre(MouseEvent event
    ) {
        if (buscarProveedor(carnet_referencia_nombre.getText())) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setCi(carnet_referencia_nombre.getText());
            basedeDatos = new BaseDeDatos<>(proveedor);
            basedeDatos.ModificarValorBaseDeDatos("nombre", nuevo_nombre.getText());
        } catch (Exception ex) {
            new LibreriaGrafica().MostrarError("la modificacion no es valida");
        }
         } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    
    @FXML
    void cargar_lista(Event event) {
        ListaProveedor.getItems().clear();
        basedeDatos=new BaseDeDatos<>(new Proveedor());
        for(Proveedor proveedor:basedeDatos.ListaObjetos()){
            ObservableList<Proveedor> listaView = (ObservableList<Proveedor>)ListaProveedor.getItems();
            listaView.add(proveedor);
        }
    }
    @FXML
    void eliminar_proveedor(MouseEvent event) {
        
        if (buscarProveedor(carnet_proveedor_eliminable.getText())) {
            if(new LibreriaGrafica().ObtenerConfirmacion("¿Desea eliminar a "+carnet_proveedor_eliminable.getText()+"?").get()==ButtonType.OK){
                try {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setCi(carnet_proveedor_eliminable.getText());

                    basedeDatos = new BaseDeDatos<>(proveedor);
                    basedeDatos.eliminarObjetoBaseDeDatos();
                } catch (Exception ex) {
                    new LibreriaGrafica().MostrarError("la modificacion no es valida");
                }
            }
            
        } else {
            new LibreriaGrafica().MostrarInformacion("no se encontro el carnet ingresado");
        }
    }

    @FXML
    void mostrar_lista_proveedores(MouseEvent event
    ) {
        basedeDatos = new BaseDeDatos<>(new Proveedor());
        ArrayList<Proveedor> proveedores = basedeDatos.ListaObjetos();
        String mostrar = "";
        for (Proveedor proveedor : proveedores) {
            mostrar += proveedor.imprimible();
        }
       // vista_lista_proveedores.setText(mostrar);
    }

    private void limpiarPantallaRegistro() {
        carnet_registro_proveedor.setText("");
        apellido_registro_proveedor.setText("");
        nombre_registro_proveedor.setText("");
        gmail_registro.setText("");
        direccion_registro_proveedor.setText("");
        telefono_registro_proveedor.setText("");

    }

    private boolean buscarProveedor(String carnet) {
        basedeDatos=new BaseDeDatos<>(new Proveedor());
        ArrayList<Proveedor> proveedores = basedeDatos.ListaObjetos();
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCi().equals(carnet)) {
                return true;
            }
        }
        return false;
    }

    private void formatoTabla() {
       TableView<Proveedor> tablaProveedor = (TableView<Proveedor>) ListaProveedor;
        TableColumn<Proveedor, String> ColumnaCi = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(0);
        ColumnaCi.setCellValueFactory(new PropertyValueFactory<>("ci"));
        TableColumn<Proveedor, String> ColumnaNombre = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(1);
        ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Proveedor, String> ColumnaApellido = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(2);
        ColumnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        TableColumn<Proveedor, String> ColumnaDireccion = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(3);
        ColumnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        TableColumn<Proveedor, String> ColumnaGmail = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(4);
        ColumnaGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        TableColumn<Proveedor, String> ColumnaTelefono = (TableColumn<Proveedor, String>) tablaProveedor.getColumns().get(5);
        ColumnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono")); 
    
}

}
