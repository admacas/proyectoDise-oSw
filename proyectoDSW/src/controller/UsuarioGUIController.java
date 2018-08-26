/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Empleado;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class UsuarioGUIController implements Initializable {
    protected Conexiondb conexion;
    ObservableList<Empleado> datos;
    ArrayList<Empleado> empleados;
    @FXML
    private TableView<Empleado> tableUsuario;
    @FXML
    private TableColumn<Empleado,String> tabCedula;
    @FXML
    private TableColumn<Empleado,String> tabNombre;
    @FXML
    private TableColumn<Empleado, String> tabApe;
    @FXML
    private TableColumn<Empleado, String> tabEmail;
    @FXML
    private TableColumn<Empleado, String> tabTele;
    @FXML
    private TableColumn<Empleado, Integer> tabEdad;
    @FXML
    private TableColumn<Empleado, String> tabDir;
    @FXML
    private RadioButton radCrear;
    @FXML
    private RadioButton radUP;
    @FXML
    private RadioButton radDE;
    @FXML
    private TextField textUser;
    @FXML
    private TextField textPass;
    @FXML
    private TextField textCed;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textApe;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textTele;
    @FXML
    private TextField textEdad;
    @FXML
    private TextArea textDir;
    @FXML
    private BorderPane root;
    @FXML
    private Button btnRegresar;
    @FXML
    private ToggleGroup group1;
    @FXML
    private Button btnEjecutar;
    @FXML
    private TextField textRol;
    @FXML
    private TextField textLocal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion=new Conexiondb();
        inicializarTable();
    }    
    private void inicializarTable(){
        tabCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tabNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tabApe.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabTele.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tabEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tabDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.llenarDatosTable();
    }
    private void llenarDatosTable(){
        empleados=ObtenerDatosDB.getAllEmpleados(conexion.getConnection());
        datos=FXCollections.observableArrayList(empleados);
        tableUsuario.setItems(datos);
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException, SQLException {
        conexion.cerrarConexion();
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/SuperAdminGUI.fxml");
    }

    @FXML
    private void ejecutarAction(ActionEvent event) {
        if(radCrear.isSelected()){
            if(verificarText()){
                String query=this.construirQuery();
                IngresarDatosDB.ingresarDatos(conexion.getConnection(),query );
                limpiar();
                this.llenarDatosTable();
                radCrear.setSelected(false);
                desabilitarText();
            }else{
              AlarmaMsg.setAlarma("Todos lols campos deben estar correctamentes llenos");
            }
        }else if(radUP.isSelected()){
            
        }else if(radDE.isSelected()){
            
        }else{
            AlarmaMsg.setAlarma("Elija una opcion antes de ejecutar");
        }
        
    }
    private void habilitarText(){
        textApe.setDisable(false);
        textCed.setDisable(false);
        textDir.setDisable(false);
        textEdad.setDisable(false);
        textEmail.setDisable(false);
        textNom.setDisable(false);
        textPass.setDisable(false);
        textTele.setDisable(false);
        textUser.setDisable(false);
        textRol.setDisable(false);
        textLocal.setDisable(false);
    }
    private void setEmpleado(Empleado empleado){
        textApe.setText(empleado.getApellido());
        textCed.setText(empleado.getCedula());
        textDir.setText(empleado.getDireccion());
        textEdad.setText(String.valueOf(empleado.getEdad()));
        textEmail.setText(empleado.getEmail());
        textNom.setText(empleado.getNombre());
        textPass.setText(empleado.getPassword());
        textTele.setText(empleado.getTelefono());
        textUser.setText(empleado.getUserName());
        textRol.setText(empleado.getRol());
        textLocal.setText(String.valueOf(empleado.getIdLocal()));
    }
     private void desabilitarText(){
        textApe.setDisable(true);
        textCed.setDisable(true);
        textDir.setDisable(true);
        textEdad.setDisable(true);
        textEmail.setDisable(true);
        textNom.setDisable(true);
        textPass.setDisable(true);
        textTele.setDisable(true);
        textUser.setDisable(true);
        textRol.setDisable(true);
        textLocal.setDisable(true);
    }
     private void limpiar(){
        textApe.setText("");
        textCed.setText("");
        textDir.setText("");
        textEdad.setText("");
        textEmail.setText("");
        textNom.setText("");
        textPass.setText("");
        textTele.setText("");
        textUser.setText("");
        textLocal.setText("");
        textRol.setText("");
    }
    private boolean verificarEmpleado(Empleado empleado){
        return empleado != null;
    }
    private boolean verificarText(){
        return !("".equals(textApe.getText()) || "".equals(textCed.getText()) || "".equals(textDir.getText())
                || "".equals(textEdad.getText()) || "".equals(textEmail.getText()) || "".equals(textNom.getText())
                || "".equals(textPass.getText()) || "".equals(textTele.getText()) || "".equals(textUser.getText())
                || "".equals(textLocal.getText()));
    }

    @FXML
    private void habilitarCrear(ActionEvent event) {
        habilitarText();
    }

    @FXML
    private void habilitarActualizar(ActionEvent event) {
         Empleado empleado=tableUsuario.getSelectionModel().getSelectedItem();
        if(verificarEmpleado(empleado)){
            habilitarText();
            setEmpleado(empleado);
        }else{
            AlarmaMsg.setAlarma("Debe escoger una elemento de la tabla antes de selecionar la opcion");
            radUP.setSelected(false);
        }
    }

    @FXML
    private void habilitarEliminar(ActionEvent event) {
        Empleado empleado=tableUsuario.getSelectionModel().getSelectedItem();
        if(verificarEmpleado(empleado)){
            desabilitarText();
            setEmpleado(empleado);
        }else{
            AlarmaMsg.setAlarma("Debe escoger una elemento de la tabla antes de selecionar la opcion");
            radDE.setSelected(false);
        }
    }
    private String construirQuery(){
        return "insert into usuarios(username,passwords,rol) values('"+textUser.getText()+"','"+textPass.getText()+"','"+textRol.getText()+"');"+"\n"+
                "insert into empleados(cedula,nombre,apellido,email,telefono,edad,direccion,idlocal,iduser) values("
                + "'"+textCed.getText()+"','"+textNom.getText()+"','"+textApe.getText()+"','"+textEmail.getText()+"','"+textTele.getText()+"',"+textEdad.getText()+",'"+textDir.getText()+"',"+textLocal.getText()+
                ",(select iduser from usuarios where usuarios.username='"+textUser.getText()+"'));";
    }
    
}
