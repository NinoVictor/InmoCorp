/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.InmuebleImp;
import DAO.TipoInmuebleImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import inmocorp.inmobiliaria.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Inmueble;
import modelo.TipoInmueble;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class MenuPrincipalController implements Initializable {

    List<Inmueble> listaInmueble = new ArrayList();
    @FXML private JFXButton btnSalir;
    @FXML private JFXTextField txtBuscarInmu;
    @FXML private JFXButton btnBuscarInmu;
    @FXML private JFXComboBox<TipoInmueble> cbTipoInmu;
    @FXML private JFXComboBox<String> cbTipoOperacion;
    @FXML private TableColumn<Inmueble, String> colTipoOperacion;
    @FXML private TableColumn<Inmueble, String> colTipoInmu;
    @FXML private TableColumn<Inmueble, String> colDescripcion;
    @FXML private TableColumn<Inmueble, Integer> colCiudad;
    @FXML private TableColumn<Inmueble, String> colColonia;
    @FXML private TableColumn<Inmueble,Double> colPrecioRenta;
    @FXML private TableColumn<Inmueble,Double> colPrecioVenta;
    @FXML private TableView<Inmueble> tablaInmueble;

    @FXML
    private void ventanaVenta() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarVenta.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Ventas");
            stage.setScene(scene);
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
            
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }
    @FXML
    private void ventanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MenuPrincipal.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("InmoCorp");
            stage.setScene(scene);
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
            
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana principal: " + ex.getMessage());
        }
    }
    @FXML
    private void ventanaRenta() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarRenta.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Rentas");
            stage.setScene(scene);
            stage.show();
            Stage principal = (Stage) btnSalir.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Rentas: " + ex);
        }
    }
    
    private void llenarCbTipoInmueble() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        ObservableList<TipoInmueble> observablelisttipo = 
                FXCollections.observableArrayList(tipoinmuebleimp.getTipoInmuebles());
        cbTipoInmu.setItems(observablelisttipo);    
    }
    
    private void llenarCbTipoOperacion() {
        List<String> listaTipoOperacion = new ArrayList(); 
        listaTipoOperacion.add("Renta");
        listaTipoOperacion.add("Venta");
        listaTipoOperacion.add("Venta/Renta");
        ObservableList<String> obsevableListaTipoOpe = 
                FXCollections.observableArrayList(listaTipoOperacion);
        cbTipoOperacion.setItems(obsevableListaTipoOpe);
    }
    
    private void llenarTablaInmuebles() {
        TipoInmuebleImp tipoinmuebleimp = new TipoInmuebleImp();
        List<TipoInmueble> listaTipoCd = tipoinmuebleimp.getTipoInmuebles();
        colTipoOperacion.setCellValueFactory(new PropertyValueFactory("tipoOperacion"));
        colTipoInmu.setCellValueFactory(new PropertyValueFactory("idtipoinmueble"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory("notas"));
        colCiudad.setCellValueFactory(new PropertyValueFactory("idciudad"));
        colColonia.setCellValueFactory(new PropertyValueFactory("colonia"));
        colPrecioRenta.setCellValueFactory(new PropertyValueFactory("preciorenta"));
        colPrecioVenta.setCellValueFactory(new PropertyValueFactory("precioventa"));
        InmuebleImp controller = new InmuebleImp();
        listaInmueble = controller.getInmuebles();
        ObservableList<Inmueble> observableListInmu = FXCollections.observableArrayList(listaInmueble);
        tablaInmueble.setItems(observableListInmu);
    }
    private void iniciarInterfaz() {
        llenarCbTipoInmueble();
        llenarCbTipoOperacion();
        llenarTablaInmuebles();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //iniciarInterfaz();
    }
    
}
