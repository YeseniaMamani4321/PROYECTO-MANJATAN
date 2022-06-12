/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
/**
 *
 * @author jhamilr
 */
public class GeneradorQr {

    public GeneradorQr() {
    }

    Image generarQr(int codigo) {
        int size=450;
        String data=codigo+"";
        try {
        BitMatrix matrix;
         Writer writer = new MultiFormatWriter();
          EnumMap<EncodeHintType,String> hints = new EnumMap<EncodeHintType,String>(EncodeHintType.class);
           hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");            
            matrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size, hints);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
        
            MatrixToImageWriter.writeToStream(matrix, "PNG", output);
        
            byte[] data_array = output.toByteArray();
            ByteArrayInputStream input = new ByteArrayInputStream(data_array);
            return new Image(input);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriterException ex) {
            Logger.getLogger(GeneradorQr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    
    
}
