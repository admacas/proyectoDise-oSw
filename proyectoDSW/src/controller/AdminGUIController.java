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
public class AdminGUIController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button btnVenta;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnProducto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/Login.fxml");
        stage.show();
    }

    @FXML
    private void changeVentanaProducto(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/ProductoGUI.fxml");
        stage.show();
    }
    
}
