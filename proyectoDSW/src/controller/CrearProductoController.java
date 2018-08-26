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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alex Macas
 */
public class CrearProductoController implements Initializable {
    protected Conexiondb conexion=new Conexiondb();

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnCrear;
    @FXML
    private AnchorPane root;
    @FXML
    private TextField textCodigo;
    @FXML
    private TextField textMarca;
    @FXML
    private TextField textModelo;
    @FXML
    private TextField textColor;
    @FXML
    private TextArea textDes;
    @FXML
    private TextField textCantidad;
    @FXML
    private TextField textPrecio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        Stage stage=ChangeStage.getStage(root);
        ChangeStage.change(stage,"/view/ProductoGUI.fxml");
        stage.show();
    }

    @FXML
    private void crearProducto(ActionEvent event) {
        if(verificar()){
            String query=this.construirQuery();
            IngresarDatosDB.ingresarDatos(conexion.getConnection(), query);
            limpiar();
        }else{
            AlarmaMsg.setAlarma("Todos los campos deben estar llenos");
        }
    }
    private boolean verificar(){
        return !("".equals(textCodigo.getText()) || "".equals(textColor.getText()) || "".equals(textDes.getText())
                || "".equals(textCodigo.getText()) || "".equals(textMarca.getText()) || "".equals(textModelo.getText())
                || "".equals(textCantidad.getText()) || "".equals(textPrecio.getText()));
    }
    private String construirQuery(){
        return "insert into productos(codigo,marca,modelo,color,descripcion,cantidad,precio) values('"+textCodigo.getText()+"','"+textMarca.getText()
                +"','"+textModelo.getText()+"','"+textColor.getText()+"','"+textDes.getText()+"',"+textCantidad.getText()+","+textPrecio.getText()+");";
    }
    private void limpiar(){
        textCodigo.setText("");
        textColor.setText("");
        textDes.setText("");
        textMarca.setText("");
        textModelo.setText("");
        textCantidad.setText("");
        textPrecio.setText("");
    }
    
}
