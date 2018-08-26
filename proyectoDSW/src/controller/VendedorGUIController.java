/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class VendedorGUIController implements Initializable {

    @FXML
    private Button btnConsultas;
    @FXML
    private Button btnVenta;
    @FXML
    private Button btnCerrar;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeViewConsulta(ActionEvent event) throws IOException {
         Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/ConsultaProductoGUI.fxml");
        stage.show();
    }

    @FXML
    private void cerrrSesion(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/Login.fxml");
        stage.show();
    
    }
    
}
