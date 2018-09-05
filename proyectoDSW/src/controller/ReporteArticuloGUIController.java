/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import model.Reporte;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class ReporteArticuloGUIController implements Initializable {
    protected Conexiondb conexion=new Conexiondb();
    @FXML
    private BorderPane root;
    @FXML
    private Button btnRegresar;
    @FXML
    private TableView<Reporte> tableReporte;
    @FXML
    private TableColumn<Reporte, String> columnArticulo;
    @FXML
    private TableColumn<Reporte, Integer> columnCantidad;
    @FXML
    private TableColumn<Reporte, Double> columnTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setInicializarTable();
        // TODO
    }    


    @FXML
    private void regresar(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/ReportesGUI.fxml");
        stage.show();
    }
   
    private void setInicializarTable(){
        columnArticulo.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        columnCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        llenarTable();
    }
    private void llenarTable(){
        ArrayList<Reporte> lista=ObtenerDatosDB.getReportes(conexion.getConnection());
        ObservableList<Reporte> datos=FXCollections.observableArrayList(lista);
        tableReporte.setItems(datos);
    }
    
}
