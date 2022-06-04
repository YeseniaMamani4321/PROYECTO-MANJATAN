/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.vista;

import java.util.NoSuchElementException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author jhamilr
 */
public class LibreriaGrafica {
   FXMLLoader cargador;
    public Parent cargarGrafico(String menufxml) {
        try {
            cargador=new FXMLLoader();
            cargador.setLocation(getClass().getResource(menufxml));
            return cargador.load();
        }catch(Exception es){
            
        }
        return null;
    }

    public FXMLLoader getCargador() {
        return cargador;
    }
    
    public void MostrarError(String mensaje){
         Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
             alert.setTitle("Error");
             alert.setContentText(mensaje);
             alert.showAndWait();
    }

    public void MostrarInformacion(String mensaje) {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText(mensaje);
             alert.showAndWait(); 
    }
    public String ObtenerInformacion(String mensaje){
            TextInputDialog textInput = new TextInputDialog();
            textInput.setHeaderText(null);
            textInput.setTitle("Obtener Valor");
            textInput.setContentText(mensaje);
            return textInput.showAndWait().get();
    }
    public  Optional<ButtonType> ObtenerConfirmacion(String mensaje){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Obtener Confirmacion");
            alert.setContentText(mensaje);
             return alert.showAndWait();
    }

    public int ObtenerEntero(String mensaje) {
        int salida=0;
        boolean continuar=false;
      do{
            continuar=false;
        try{
            String entrada=this.ObtenerInformacion(mensaje);
            salida=Integer.parseInt(entrada);  
        }
        catch(NoSuchElementException e){
            
        }
        catch(Exception es){
            this.MostrarError("error ingrese numeros");
            continuar=true;
        }
        }while (continuar);
      return salida;
    }
    public int ObtenerEntero(String mensaje, int limiteInferior) {
        int salida=-1;
        boolean continuar=false;
      do{
            continuar=false;
        try{
            String entrada=this.ObtenerInformacion(mensaje);
            salida=Integer.parseInt(entrada);  
            if(salida<limiteInferior){
                continuar=true;
            }
            
        }
        catch(NoSuchElementException e){
            
        }
        catch(Exception es){
            this.MostrarError("error ingrese numeros");
            continuar=true;
        }
        }while (continuar);
      return salida;
    }
        public int ObtenerEntero(String mensaje, int limiteInferior, int limiteSuperior) {
        int salida=0;
        boolean continuar=false;
      do{
            continuar=false;
        try{
            String entrada=this.ObtenerInformacion(mensaje);
            salida=Integer.parseInt(entrada);  
            if(salida<limiteInferior||salida>limiteSuperior ){
                continuar=true;
            }
            
        }
        catch(NoSuchElementException e){
            
        }
        catch(Exception es){
            this.MostrarError("error ingrese numeros");
            continuar=true;
        }
        }while (continuar);
      return salida;
    }
}

