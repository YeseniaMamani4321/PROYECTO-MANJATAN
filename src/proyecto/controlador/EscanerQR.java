/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_objdetect.QRCodeDetector;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import proyecto.vista.AbridorVentanas;
import org.bytedeco.javacv.JavaFXFrameConverter;
import javafx.application.Platform;

/**
 *
 * @author jhamilr
 */
public class EscanerQR {

    public EscanerQR() {
    }

    int obtenercodigo() {
        AbridorVentanas<EscanerQRController> QRventana = new AbridorVentanas<>("/proyecto/vista/EscanerQR.fxml");
        Camara camera = new Camara();
        camera.ventana = QRventana.getVentana();
        QRventana.getControlador().setVentana(camera.ventana);
        camera.imagen = QRventana.getControlador().getCamara();
        QRventana.getControlador().setDato(new String[1]);
        camera.setDato(QRventana.getControlador().getDato());
        Thread hilo = new Thread(camera);
        hilo.start();
        QRventana.abrirVentana("Escaner QR");
        if (camera.getDato()[0] == null) {
            return -1;
        }
        try {
            return Integer.parseInt(camera.getDato()[0]);
        } catch (Exception es) {
            return -2;
        }
    }
    /*public Image convertImage(Mat mat){
      
    }*/

}

class Camara implements Runnable {

    Stage ventana;
    ImageView imagen;
    String dato[];

    @Override
    public void run() {
        QRCodeDetector qr = new QRCodeDetector();
        VideoCapture captura = new VideoCapture();

        final JavaFXFrameConverter converter = new JavaFXFrameConverter();
          
        if (captura.open(0)) {
            while (true) {
                
                Mat frame = new Mat();
                
                captura.read(frame);
                if (frame.empty()) {
                    continue;
                }
                Mat pts = new Mat();
                
                if (qr.detect(frame, pts)) {
                    BytePointer decoded = qr.decode(frame, pts);
                    dato[0] = obtenerDatoQR(pts, decoded);
                    if (dato[0] != null) {
                        Platform.runLater(new Runnable() {

                            public void run() {
                                ventana.close();
                            }
                        });
                    }
                }

                imagen.setImage(converter.convert(convert(frame)));
                if (!ventana.isShowing()) {
                    break;
                }
            }

        }
        captura.release();

    }

    public Frame convert(Mat mat) {
        Frame frame;
        OpenCVFrameConverter.ToMat matConverter = new OpenCVFrameConverter.ToMat();
        return matConverter.convert(mat);

    }

    public static String obtenerDatoQR(Mat pts, BytePointer url) {
        if (!pts.empty()) {
            if (url != null) {
                return url.getString();
            }
        }
        return null;

    }

    public Stage getVentana() {
        return ventana;
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public String[] getDato() {
        return dato;
    }

    public void setDato(String[] dato) {
        this.dato = dato;
    }

}
