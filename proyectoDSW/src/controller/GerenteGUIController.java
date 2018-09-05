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
public class GerenteGUIController implements Initializable {

    @FXML
    private Button btnReporte;
    @FXML
    private Button btnConsulta;
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
    private void reporteVIEW(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/ReportesGUI.fxml");
        stage.show();
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/Login.fxml");
        stage.show();
    }
    
    
}
