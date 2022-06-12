/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Producto;
import proyecto.vista.AbridorVentanas;
import proyecto.vista.LibreriaGrafica;

/**
 *
 * @author jhamilr
 */
public class GestionProductoController implements Initializable {
       @FXML
    private Tab agregar_producto;

    @FXML
    private TextField codigo_producto_qr;

    @FXML
    private ImageView codigo_qr_generado;

    @FXML
    private Label codigo_scaneado;

    @FXML
    private Label descripcion_escaneado;

    @FXML
    private Tab eliminar_producto;

    @FXML
    private Tab generar_codigo_qr;

    @FXML
    private Label marca_escaneado;

    @FXML
    private Tab modificar_producto;

    @FXML
    private Label nombre_escaneado;

    @FXML
    private TextField nueva_descripcion;

    @FXML
    private TextField nueva_marca;


    @FXML
    private TextField nuevo_nombre;

    @FXML
    private TextField nuevo_precio;

    @FXML
    private TextField nuevo_stock;

    @FXML
    private Label precio_escaneado;

    @FXML
    private TextField registro_descripcion_producto;

    @FXML
    private TextField registro_marca_producto;

    @FXML
    private TextField registro_nombre_producto;
    
    @FXML
    private TextField registro_precio_producto;

    @FXML
    private TextField registro_stock_producto;

    @FXML
    private Label stock_escaneado;

    @FXML
    private Tab ver_lista_producto;
    private int codigo_escaneado;
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
        nuevo_stock.setTextFormatter(formatoEntero);
        formatoEntero = new TextFormatter<>(filter);
        registro_stock_producto.setTextFormatter(formatoEntero);
        UnaryOperator<TextFormatter.Change> filtro = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*['.']?[0-9]*")) {
                return change;
            }

            return null;
        };
        TextFormatter<String> formatoReal=new TextFormatter<>(filtro);
        registro_precio_producto.setTextFormatter(formatoReal);
        formatoReal=new TextFormatter<>(filtro);
        nuevo_precio.setTextFormatter(formatoReal);
    }
  

   
    @FXML
    void actualizar_descripcion(MouseEvent event) {
         try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("descripcion", nueva_descripcion.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
    }

    @FXML
    void actualizar_marca(MouseEvent event) {

    }

    @FXML
    void actualizar_nombre(MouseEvent event) {

    }

    @FXML
    void actualizar_precio(MouseEvent event) {

    }

    @FXML
    void actualizar_stock(MouseEvent event) {

    }
    
    @FXML
    void agregar_producto(MouseEvent event) {
        try{
        Producto producto=new Producto();
        producto.setNombre(registro_nombre_producto.getText());
        producto.setDescripcion(registro_descripcion_producto.getText());
        producto.setMarca(registro_marca_producto.getText());
        producto.setPrecio(Double.parseDouble(registro_precio_producto.getText()));
        producto.setStock(Integer.parseInt(registro_stock_producto.getText()));
        BaseDeDatos<Producto> baseDeDatos=new BaseDeDatos<>(producto);
        if(baseDeDatos.ListaObjetos().isEmpty()){
            baseDeDatos.cambiarValorAutoIncremento(0);
        }
        baseDeDatos.AgregarObjetoBaseDatos();
        new LibreriaGrafica().MostrarInformacion("producto guardado exitosamente");
        
            AbridorVentanas<VistaCodigoQrController> abrirCodigoqr=new AbridorVentanas<>("/proyecto/vista/VistaCodigoQr.fxml");
            abrirCodigoqr.getControlador().setVentana(abrirCodigoqr.getVentana());
            ArrayList<Producto> productos=baseDeDatos.ListaObjetos();
            Producto product=productos.get(productos.size()-1);
            abrirCodigoqr.getControlador().getCodigo_qr().setImage(new GeneradorQr().generarQr(product.getCodigo()));
            abrirCodigoqr.abrirVentana("Codigo QR Generado");
            limpiarVentana();
        }catch(Exception error){
            new LibreriaGrafica().MostrarError("Datos importantes del producto incompletos");
        }
    }

    @FXML
    void escanear_codigo_qr(MouseEvent event) {
       
             codigo_escaneado= new EscanerQR().obtenercodigo();
             if(codigo_escaneado!=-1){
             if(codigo_escaneado!=-2){
             BaseDeDatos<Producto> base=new BaseDeDatos<>(new Producto());
             ArrayList<Producto> productos=base.ListaObjetos();
            Producto producto= buscarProducto(productos,codigo_escaneado);
            agregar_producto_escaneado(producto);
             }
             else{
                 new LibreriaGrafica().MostrarError("El codigo qr que puso no es propiedad del sistema");
             }
             }
    }

    @FXML
    void generar_codigo_qr(MouseEvent event) {
        
    }

    @FXML
    void guardar_codigo_qr(MouseEvent event) {

    }
    
    private void limpiarVentana() {
       registro_nombre_producto.setText("");
       registro_descripcion_producto.setText("");
       registro_precio_producto.setText("");
       registro_marca_producto.setText("");
       registro_stock_producto.setText("");
    }

    private Producto buscarProducto(ArrayList<Producto> productos, int codigo_escaneado) {
        for(Producto producto:productos){
            if(producto.getCodigo()==codigo_escaneado){
                return producto;
            }
        }
        return null;
    }

    private void agregar_producto_escaneado(Producto producto) {
        codigo_scaneado.setText(producto.getCodigo()+"");
        nombre_escaneado.setText(producto.getNombre());
        descripcion_escaneado.setText(producto.getDescripcion());
        marca_escaneado.setText(producto.getMarca());
        precio_escaneado.setText(producto.getPrecio()+"");
        stock_escaneado.setText(producto.getStock()+"");
    }

}
