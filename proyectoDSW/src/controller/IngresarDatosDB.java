/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Macas
 */
public class IngresarDatosDB {
    public static void ingresarDatos(Connection conexion, String query){
        try (PreparedStatement stmt=conexion.prepareStatement(query);){
            int ingreso=stmt.executeUpdate();
            if(ingreso>0){
                AlarmaMsg.setAlarma("Se ha ingresado correctamente los datos");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngresarDatosDB.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("Ocurrio un problema");
        }
    }
}
