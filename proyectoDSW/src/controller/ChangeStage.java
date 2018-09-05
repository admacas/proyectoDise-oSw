/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alex Macas
 */
public class ChangeStage {
    public static Stage getStage(Node nodo){
        return (Stage)nodo.getScene().getWindow();
    }
    public static void change(Stage stage,String fxml) throws IOException{
        
        Parent root=FXMLLoader.load(ChangeStage.class.getClass().getResource(fxml));
        stage.setScene(new Scene(root));
        stage.sizeToScene();
    }
}
