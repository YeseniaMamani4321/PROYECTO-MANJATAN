/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author jhamilr
 */
public class ClientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private TextField Texto;

    @FXML
    private TableView<?> lista;
    private String MENSAJE_VACIO_BUSQUEDA="Ingrese aqui el texto a buscar";
    @FXML
    void teclaPresionada(KeyEvent event) {
        if(Texto.getText().equals(MENSAJE_VACIO_BUSQUEDA)){
            Texto.setStyle("-fx-background-color: black;");
        }
        Texto.setText("");
        
    }

    @FXML
    void teclaSuelta(KeyEvent event) {

    }

}
