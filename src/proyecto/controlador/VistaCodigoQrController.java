/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyecto.controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author jhamilr
 */
public class VistaCodigoQrController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView codigo_qr;
    Stage ventana;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void cerrar(MouseEvent event) {
        ventana.close();
    }

    @FXML
    void guardar_qr(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar codigo QR");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("IMAGEN QR", "*.png"));
        File archivo = fileChooser.showSaveDialog(ventana);
        if (archivo != null) {
            try {
                File fileToSave = archivo;
                if (!fileToSave.toString().endsWith(".png")) {

                    fileToSave = new File(archivo.getAbsolutePath() + ".png");
                }
                ImageIO.write(SwingFXUtils.fromFXImage(codigo_qr.getImage(), null), "png", fileToSave);
            } catch (IOException ex) {
                Logger.getLogger(VistaCodigoQrController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Stage getVentana() {
        return ventana;
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }

    public ImageView getCodigo_qr() {
        return codigo_qr;
    }

    public void setCodigo_qr(ImageView codigo_qr) {
        this.codigo_qr = codigo_qr;
    }

}
