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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Administrador;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author jhamilr
 */
public class GestionAdministradorController implements Initializable {

    @FXML
    private TextField CarnetRegistro;

    @FXML
    private PasswordField ContraseñaRegistro;

    @FXML
    private Label DatosCarnet;

    @FXML
    private Label DatosDireccion;

    @FXML
    private Label DatosNombre;

    @FXML
    private Label DatosTelefono;

    @FXML
    private TextField DireccionRegistro;

    @FXML
    private TextField NombreRegistro;

    @FXML
    private PasswordField NuevaContraseña;

    @FXML
    private TextField NuevaDireccion;

    @FXML
    private TextField NuevoCarnet;

    @FXML
    private TextField NuevoNombre;

    @FXML
    private TextField NuevoTelefono;

    @FXML
    private TextField TelefonoRegistro;
    @FXML
    private TabPane ventana_seleccion;
    @FXML
    private Tab VentanaModificar;
    @FXML
    private Tab VentanaRegistrar;
    @FXML
    private Button botonRegistrar;
    @FXML
    private ImageView vistaContraseñaModificacion;
    @FXML
    private ImageView vistaContraseñaRegistro;
    Administrador administrador;
    BaseDeDatos<Administrador> baseDeDatos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*")) {
                return change;
            }

            return null;
        };
        TextFormatter<String> formatoEntero = new TextFormatter<>(filter);
        TelefonoRegistro.setTextFormatter(formatoEntero);
        formatoEntero = new TextFormatter<>(filter);
        NuevoTelefono.setTextFormatter(formatoEntero);

    }

    @FXML
    void ActualizarCarnet(MouseEvent event) {
        try {
            baseDeDatos.ModificarValorBaseDeDatos("carnet", NuevoCarnet.getText().toUpperCase());
            ActualizarDatosPantalla();
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("no se permiten valores vacios");
        }
    }

    @FXML
    void ActualizarContraseña(MouseEvent event) {
        try {
            if (vistaContraseñaModificacion.getOpacity() < 1) {
                baseDeDatos.ModificarValorBaseDeDatos("contrasena", NuevaContraseña.getPromptText());
            } else {
                baseDeDatos.ModificarValorBaseDeDatos("contrasena", NuevaContraseña.getText());
            }

            ActualizarDatosPantalla();
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("no se permiten valores vacios");
        }
    }

    @FXML
    void ActualizarDireccion(MouseEvent event) {
        try {
            baseDeDatos.ModificarValorBaseDeDatos("direccion", NuevaDireccion.getText());
            ActualizarDatosPantalla();
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("no se permiten valores vacios");
        }
    }

    @FXML
    void ActualizarNombre(MouseEvent event) {
        try {
            baseDeDatos.ModificarValorBaseDeDatos("nombre", NuevoNombre.getText());
            ActualizarDatosPantalla();
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("no se permiten valores vacios");
        }
    }

    @FXML
    void ActualizarTelefono(MouseEvent event
    ) {
        try {
            baseDeDatos.ModificarValorBaseDeDatos("telefono", NuevoTelefono.getText());
            ActualizarDatosPantalla();
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("no se permiten valores vacios");
        }
    }

    @FXML
    void RegistrarAdministrador(MouseEvent event
    ) {
        try {
            administrador = new Administrador();
            baseDeDatos = new BaseDeDatos<>(administrador);
            administrador.setCarnet(CarnetRegistro.getText().toUpperCase());
            if (vistaContraseñaRegistro.getOpacity() < 1) {
                System.out.println(ContraseñaRegistro.getPromptText());
                administrador.setContrasena(ContraseñaRegistro.getPromptText());
            } else {
                administrador.setContrasena(ContraseñaRegistro.getText());
            }
            administrador.setDireccion(DireccionRegistro.getText());
            administrador.setNombre(NombreRegistro.getText());
            administrador.setTelefono(Integer.parseInt(TelefonoRegistro.getText()));
            baseDeDatos.AgregarObjetoBaseDatos();
            ActualizarDatosPantalla();
            VentanaModificar.setDisable(false);
            botonRegistrar.setDisable(true);
        } catch (Exception es) {
            new LibreriaGrafica().MostrarError("llena todos los campos");
        }
    }

    @FXML
    void mostrarContraseñaModificacion(MouseEvent event
    ) {
        alterarVistaContraseña(vistaContraseñaModificacion, NuevaContraseña);
    }

    @FXML
    void mostrarContraseñaRegistro(MouseEvent event
    ) {
        alterarVistaContraseña(vistaContraseñaRegistro, ContraseñaRegistro);

    }

    public void ActualizarDatosPantalla() {
        DatosCarnet.setText(administrador.getCarnet());
        DatosDireccion.setText(administrador.getDireccion());
        DatosNombre.setText(administrador.getNombre());
        DatosTelefono.setText(administrador.getTelefono() + "");
    }

    public void alterarVistaContraseña(ImageView vista, PasswordField entrada) {
        String contraseña;

        if (vista.getOpacity() < 1) {

            contraseña = entrada.getPromptText();
            if (!entrada.getText().equals("")) {
                contraseña = entrada.getText();
            }
            entrada.setText(contraseña);
            vista.setOpacity(1);
        } else {
            contraseña = entrada.getText();
            entrada.clear();
            entrada.setPromptText(contraseña);
            vista.setOpacity(0.4);
        }
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        if (administrador != null) {
            baseDeDatos=new BaseDeDatos<>(administrador);
            ActualizarDatosPantalla();
        }
    }

    public Tab getVentanaModificar() {
        return VentanaModificar;
    }

    public Tab getVentanaRegistrar() {
        return VentanaRegistrar;
    }

    public TabPane getVentana_seleccion() {
        return ventana_seleccion;
    }

}
