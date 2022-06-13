/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import proyecto.modelo.BaseDeDatos;
import proyecto.modelo.Entidades.Producto;
import proyecto.vista.AbridorVentanas;
import proyecto.vista.LibreriaGrafica;
import javafx.event.Event;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import proyecto.modelo.Entidades.Proveedor;

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
    @FXML
    private TableView<?> lista_productos;
    private int codigo_escaneado;
    @FXML
    private TabPane productos_ventana;
    Stage ventana;

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
        formatoEntero = new TextFormatter<>(filter);
        codigo_producto_qr.setTextFormatter(formatoEntero);
        UnaryOperator<TextFormatter.Change> filtro = change -> {
            String text = change.getText();

            if (text.matches("[0-9]*['.']?[0-9]*")) {
                return change;
            }

            return null;
        };
        TextFormatter<String> formatoReal = new TextFormatter<>(filtro);
        registro_precio_producto.setTextFormatter(formatoReal);
        formatoReal = new TextFormatter<>(filtro);
        nuevo_precio.setTextFormatter(formatoReal);
        formatoTabla();
    }

    @FXML
    void actualizar_descripcion(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("descripcion", nueva_descripcion.getText());
                descripcion_escaneado.setText(nueva_descripcion.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarError("Modificacion no valida escanee su codigo qr para proceder");
        }
    }

    @FXML
    void actualizar_marca(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("marca", nueva_marca.getText());
                marca_escaneado.setText(nueva_marca.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarError("Modificacion no valida escanee su codigo qr para proceder");
        }
    }

    @FXML
    void actualizar_nombre(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("nombre", nuevo_nombre.getText());
                nombre_escaneado.setText(nuevo_nombre.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarError("Modificacion no valida escanee su codigo qr para proceder");
        }
    }

    @FXML
    void actualizar_precio(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("precio", nuevo_precio.getText());
                precio_escaneado.setText(nuevo_precio.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarError("Modificacion no valida escanee su codigo qr para proceder");
        }
    }

    @FXML
    void actualizar_stock(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            try {
                Producto producto = new Producto();
                producto.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
                BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(producto);
                basedeDatos.ModificarValorBaseDeDatos("stock", nuevo_stock.getText());
                stock_escaneado.setText(nuevo_stock.getText());
                new LibreriaGrafica().MostrarInformacion("Dato actualizado correctamente");
            } catch (Exception ex) {
                new LibreriaGrafica().MostrarError("la modificacion no es valida");
            }
        } else {
            new LibreriaGrafica().MostrarError("Modificacion no valida escanee su codigo qr para proceder");
        }
    }

    @FXML
    void agregar_producto(MouseEvent event) {
        try {
            Producto producto = new Producto();
            producto.setNombre(registro_nombre_producto.getText());
            producto.setDescripcion(registro_descripcion_producto.getText());
            producto.setMarca(registro_marca_producto.getText());
            producto.setPrecio(Double.parseDouble(registro_precio_producto.getText()));
            producto.setStock(Integer.parseInt(registro_stock_producto.getText()));
            BaseDeDatos<Producto> baseDeDatos = new BaseDeDatos<>(producto);
            if (baseDeDatos.ListaObjetos().isEmpty()) {
                baseDeDatos.cambiarValorAutoIncremento(0);
            }
            baseDeDatos.AgregarObjetoBaseDatos();
            new LibreriaGrafica().MostrarInformacion("producto guardado exitosamente");

            AbridorVentanas<VistaCodigoQrController> abrirCodigoqr = new AbridorVentanas<>("/proyecto/vista/VistaCodigoQr.fxml");
            abrirCodigoqr.getControlador().setVentana(abrirCodigoqr.getVentana());
            ArrayList<Producto> productos = baseDeDatos.ListaObjetos();
            Producto product = productos.get(productos.size() - 1);
            abrirCodigoqr.getControlador().getCodigo_qr().setImage(new GeneradorQr().generarQr(product.getCodigo()));
            abrirCodigoqr.abrirVentana("Codigo QR Generado");
            limpiarVentana();
        } catch (Exception error) {
            new LibreriaGrafica().MostrarError("Datos importantes del producto incompletos");
        }
    }

    @FXML
    void eliminar_producto_escaneado(MouseEvent event) {
        if (!codigo_scaneado.getText().equals("")) {
            Producto productoEliminable = new Producto();
            productoEliminable.setCodigo(Integer.parseInt(codigo_scaneado.getText()));
            BaseDeDatos<Producto> productoBaseDeDatos = new BaseDeDatos<>(productoEliminable);
            try {
                productoBaseDeDatos.eliminarObjetoBaseDeDatos();
            } catch (SQLException ex) {
                Logger.getLogger(GestionProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            new LibreriaGrafica().MostrarInformacion("producto escaneado eliminado correctamente");
            limpiar_producto_escaneado();
        } else {
            new LibreriaGrafica().MostrarError("No se puede eliminar el producto escanee su codigo qr para proceder");
        }
    }

    @FXML
    void escanear_codigo_qr(MouseEvent event) {

        codigo_escaneado = new EscanerQR().obtenercodigo();
        if (codigo_escaneado != -1) {
            if (codigo_escaneado != -2) {
                BaseDeDatos<Producto> base = new BaseDeDatos<>(new Producto());
                ArrayList<Producto> productos = base.ListaObjetos();
                Producto producto = buscarProducto(productos, codigo_escaneado);
                if (producto != null) {
                    agregar_producto_escaneado(producto);
                } else {
                    new LibreriaGrafica().MostrarInformacion("El producto no fue encontrado");
                }
            } else {
                new LibreriaGrafica().MostrarError("El codigo qr que puso no es propiedad del sistema");
            }
        }
    }

    @FXML
    void generar_codigo_qr(MouseEvent event) {

        if (!codigo_producto_qr.getText().equals("")) {
            GeneradorQr generador = new GeneradorQr();
            codigo_qr_generado.setImage(generador.generarQr(Integer.parseInt(codigo_producto_qr.getText())));

        } else {
            new LibreriaGrafica().MostrarError("no ingreso ningun codigo para generar");
        }
    }

    @FXML
    void generar_lista_productos(Event event) {
        lista_productos.getItems().clear();
        BaseDeDatos<Producto> basedeDatos = new BaseDeDatos<>(new Producto());
        for (Producto producto : basedeDatos.ListaObjetos()) {
            ObservableList<Producto> listaView = (ObservableList<Producto>) lista_productos.getItems();
            listaView.add(producto);
        }
    }

    @FXML
    void guardar_codigo_qr(MouseEvent event) {
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
                ImageIO.write(SwingFXUtils.fromFXImage(codigo_qr_generado.getImage(), null), "png", fileToSave);
            } catch (IOException ex) {
                Logger.getLogger(VistaCodigoQrController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void limpiarVentana() {
        registro_nombre_producto.setText("");
        registro_descripcion_producto.setText("");
        registro_precio_producto.setText("");
        registro_marca_producto.setText("");
        registro_stock_producto.setText("");
    }

    private Producto buscarProducto(ArrayList<Producto> productos, int codigo_escaneado) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo_escaneado) {
                return producto;
            }
        }
        return null;
    }

    private void limpiar_producto_escaneado() {
        codigo_scaneado.setText("");
        nombre_escaneado.setText("");
        descripcion_escaneado.setText("");
        marca_escaneado.setText("");
        precio_escaneado.setText("");
        stock_escaneado.setText("");
    }

    private void agregar_producto_escaneado(Producto producto) {
        codigo_scaneado.setText(producto.getCodigo() + "");
        nombre_escaneado.setText(producto.getNombre());
        descripcion_escaneado.setText(producto.getDescripcion());
        marca_escaneado.setText(producto.getMarca());
        precio_escaneado.setText(producto.getPrecio() + "");
        stock_escaneado.setText(producto.getStock() + "");
    }
     private void formatoTabla() {
        TableView<Producto> tablaProducto = (TableView<Producto>) lista_productos;
        TableColumn<Producto, String> ColumnaCodigo = (TableColumn<Producto, String>) tablaProducto.getColumns().get(0);
        ColumnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        TableColumn<Producto, String> ColumnaNombre = (TableColumn<Producto, String>) tablaProducto.getColumns().get(1);
        ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Producto, String> ColumnaDescripcion = (TableColumn<Producto, String>) tablaProducto.getColumns().get(2);
        ColumnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        TableColumn<Producto, String> ColumnaMarca = (TableColumn<Producto, String>) tablaProducto.getColumns().get(3);
        ColumnaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        TableColumn<Producto, String> ColumnaStock = (TableColumn<Producto, String>) tablaProducto.getColumns().get(4);
        ColumnaStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        TableColumn<Producto, String> ColumnaPrecio = (TableColumn<Producto, String>) tablaProducto.getColumns().get(5);
        ColumnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

    }

    public Stage getVentana() {
        return ventana;
    }

    public void setVentana(Stage ventana) {
        this.ventana = ventana;
    }

    public Tab getAgregar_producto() {
        return agregar_producto;
    }

    public void setAgregar_producto(Tab agregar_producto) {
        this.agregar_producto = agregar_producto;
    }

    public Tab getEliminar_producto() {
        return eliminar_producto;
    }

    public void setEliminar_producto(Tab eliminar_producto) {
        this.eliminar_producto = eliminar_producto;
    }

    public Tab getModificar_producto() {
        return modificar_producto;
    }

    public void setModificar_producto(Tab modificar_producto) {
        this.modificar_producto = modificar_producto;
    }

    public Tab getVer_lista_producto() {
        return ver_lista_producto;
    }

    public void setVer_lista_producto(Tab ver_lista_producto) {
        this.ver_lista_producto = ver_lista_producto;
    }

    public TabPane getProductos_ventana() {
        return productos_ventana;
    }

    public void setProductos_ventana(TabPane productos_ventana) {
        this.productos_ventana = productos_ventana;
    }
    

   

}
