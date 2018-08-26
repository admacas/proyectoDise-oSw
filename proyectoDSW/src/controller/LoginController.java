/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class LoginController implements Initializable {
    protected Conexiondb conexion=new Conexiondb();
    @FXML 
    private Node root;
    @FXML
    private TextField textUser;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnSalir;
    @FXML
    private PasswordField textPass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrar(ActionEvent event) throws SQLException {
        conexion.cerrarConexion();
        Stage stage=ChangeStage.getStage((Node) event.getSource());
        stage.close();
    }

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        if(this.verificarContenido()){
            Usuario user=ObtenerDatosDB.obtnerUser(textUser.getText(), conexion.getConnection());
            cambioGUI(user);
        }else{
            AlarmaMsg.setAlarma("Los campos no estan correctamente llenos");
        }
    }
    private boolean verificarContenido(){
        return !("".equals(textUser.getText()) || "".equals(textPass.getText()));
    }
    private void cambioGUI(Usuario user) throws IOException{
        if( user.getUserName().equals(textUser.getText()) && user.getPassword().equals(textPass.getText()) && user.getRol().equals("superAdministrador") ){
            Stage stage=ChangeStage.getStage(root);
            ChangeStage.change(stage,"/view/SuperAdminGUI.fxml");
            stage.show();
        }else if( user.getUserName().equals(textUser.getText()) && user.getPassword().equals(textPass.getText()) && user.getRol().equals("administrador") ){
            Stage stage=ChangeStage.getStage(root);
            ChangeStage.change(stage,"/view/AdminGUI.fxml");
            stage.show();
        }else if( user.getUserName().equals(textUser.getText()) && user.getPassword().equals(textPass.getText()) && user.getRol().equals("gerente") ){
            Stage stage=ChangeStage.getStage(root);
            ChangeStage.change(stage,"/view/GerenteGUI.fxml");
            stage.show();
        }else if(user.getUserName().equals(textUser.getText()) && user.getPassword().equals(textPass.getText()) && user.getRol().equals("empleado")){
            Stage stage=ChangeStage.getStage(root);
            ChangeStage.change(stage,"/view/VendedorGUI.fxml");
            stage.show();
        }else{
             AlarmaMsg.setAlarma("El usuario o password incorrectos");
        }
    }
}
