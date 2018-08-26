/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.control.Alert;

/**
 *
 * @author Alex Macas
 */
public class AlarmaMsg {
    public static void setAlarma(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de Informacion");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
