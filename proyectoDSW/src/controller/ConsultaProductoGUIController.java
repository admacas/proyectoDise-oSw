/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Producto;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class ConsultaProductoGUIController implements Initializable {
    protected Conexiondb conexion=new Conexiondb();
    private ArrayList<Producto> producto;
    private ObservableList<Producto> datos;
    @FXML
    private TextField textCodigo;
    @FXML
    private TextField textModelo;
    @FXML
    private TextField textDes;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TableView<Producto> tableProductos;
    @FXML
    private TableColumn<Producto, String> tabCodigo;
    @FXML
    private TableColumn<Producto, String> tabMarca;
    @FXML
    private TableColumn<Producto, String> tabModelo;
    @FXML
    private TableColumn<Producto, String> tabColor;
    @FXML
    private TableColumn<Producto, String> tabDes;
    @FXML
    private TableColumn<Producto, Integer> tabCan;
    @FXML
    private TableColumn<Producto, Double> tabPre;
    @FXML
    private BorderPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTable();
        // TODO
    }    
     private void inicializarTable(){
         tabCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tabModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tabCan.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tabColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        tabDes.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tabPre.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }
    private void llenarDatosTable(){
        producto=ObtenerDatosDB.getBuscarProducto(conexion.getConnection(),textCodigo.getText(),textModelo.getText(),textDes.getText());
        datos=FXCollections.observableArrayList(producto);
        tableProductos.setItems(datos);
    }

    @FXML
    private void buscarCodigo(KeyEvent event) {
        llenarDatosTable();
    }

    @FXML
    private void buscarModelo(KeyEvent event) {
        llenarDatosTable();
    }

    @FXML
    private void buscarDes(KeyEvent event) {
        llenarDatosTable();
    }

    @FXML
    private void buscarProducto(ActionEvent event) {
        llenarDatosTable();
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/VendedorGUI.fxml");
        stage.show();
    }
}
