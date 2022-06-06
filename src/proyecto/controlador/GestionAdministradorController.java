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
    private PasswordField Contrase�aRegistro;

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
    private PasswordField NuevaContrase�a;

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
    private ImageView vistaContrase�aModificacion;
    @FXML
    private ImageView vistaContrase�aRegistro;
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
    void ActualizarContrase�a(MouseEvent event) {
        try {
            if (vistaContrase�aModificacion.getOpacity() < 1) {
                baseDeDatos.ModificarValorBaseDeDatos("contrasena", NuevaContrase�a.getPromptText());
            } else {
                baseDeDatos.ModificarValorBaseDeDatos("contrasena", NuevaContrase�a.getText());
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
            if (vistaContrase�aRegistro.getOpacity() < 1) {
                System.out.println(Contrase�aRegistro.getPromptText());
                administrador.setContrasena(Contrase�aRegistro.getPromptText());
            } else {
                administrador.setContrasena(Contrase�aRegistro.getText());
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
    void mostrarContrase�aModificacion(MouseEvent event
    ) {
        alterarVistaContrase�a(vistaContrase�aModificacion, NuevaContrase�a);
    }

    @FXML
    void mostrarContrase�aRegistro(MouseEvent event
    ) {
        alterarVistaContrase�a(vistaContrase�aRegistro, Contrase�aRegistro);

    }

    public void ActualizarDatosPantalla() {
        DatosCarnet.setText(administrador.getCarnet());
        DatosDireccion.setText(administrador.getDireccion());
        DatosNombre.setText(administrador.getNombre());
        DatosTelefono.setText(administrador.getTelefono() + "");
    }

    public void alterarVistaContrase�a(ImageView vista, PasswordField entrada) {
        String contrase�a;

        if (vista.getOpacity() < 1) {

            contrase�a = entrada.getPromptText();
            if (!entrada.getText().equals("")) {
                contrase�a = entrada.getText();
            }
            entrada.setText(contrase�a);
            vista.setOpacity(1);
        } else {
            contrase�a = entrada.getText();
            entrada.clear();
            entrada.setPromptText(contrase�a);
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
