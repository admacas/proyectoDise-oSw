/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.ChangeStage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Alex Macas
 */
public class ProyectoDSW extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ChangeStage.change(stage, "/view/Login.fxml");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
