/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Macas
 */
public class Conexiondb {
    private Connection conexion;
    private final String driver ="org.postgresql.Driver";
    private final String usuario ="postgres";
    private final String password ="admacas2592";
    private final String url ="jdbc:postgresql://localhost:5432/LineaBlanca";
    public Conexiondb(){
        conexion=null;
        try{
            Class.forName(driver);
            conexion=DriverManager.getConnection(url,usuario,password);
            if(conexion !=null){
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("Fallo la conexion a la base de datos");
        }
    }
    public Connection getConnection(){
        return this.conexion;
    }
     public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
}
