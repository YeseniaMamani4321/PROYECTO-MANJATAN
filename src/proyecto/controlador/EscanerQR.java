/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.nio.Buffer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.JavaFXFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import static org.bytedeco.opencv.global.opencv_highgui.imshow;
import static org.bytedeco.opencv.global.opencv_highgui.waitKey;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_objdetect.QRCodeDetector;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
import org.opencv.core.MatOfByte;
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
        camera.ventana=QRventana.getVentana();
        QRventana.getControlador().setVentana(camera.ventana);
        camera.imagen=QRventana.getControlador().getCamara();
        QRventana.getControlador().setDato(new String[1]);
        camera.setDato(QRventana.getControlador().getDato());
        Thread hilo = new Thread(camera);
        hilo.start();
        QRventana.abrirVentana("Escaner QR"); 
        if(camera.getDato()[0]==null){
            return  -1;
        }
        try{
        return Integer.parseInt(camera.getDato()[0]);
        }catch(Exception es){
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
        String datoCodigo = "";
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
                    datoCodigo = obtenerDatoQR(pts, decoded);
                    if(datoCodigo!=null){
                        dato[0]=datoCodigo;
                        Platform.runLater(new Runnable() {
                            
                                    public void run() {
                                        ventana.close();
                                    }
                                });
                       
                        break;
                    }
                }
                //System.out.println("cargar Imagen");
                imagen.setImage(converter.convert(convert(frame)));
                if(!ventana.isShowing()){
                    break;
                }
               //System.out.println("finaliza Imagen");
            }

        }
        captura.release();

    }

    public Frame convert(Mat mat) {
        Frame frame;
        OpenCVFrameConverter.ToMat matConverter=new OpenCVFrameConverter.ToMat();
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
