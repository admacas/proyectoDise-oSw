/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empleado;
import model.Producto;
import model.Reporte;
import model.Usuario;

/**
 *
 * @author Alex Macas
 */
public class ObtenerDatosDB {
  
    public static Usuario obtnerUser(String username,Connection conexion){
        Usuario prueba=new Usuario(0,"prueba","prueba",0,"prueba");
        String sql="select * from usuarios where usuarios.username='"+username+"' and usuarios.estado=1;";
        try ( Statement stmt=conexion.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                int id=rs.getInt("Iduser");
                String name=rs.getString("Username");
                String pass=rs.getString("Passwords");
                String rol=rs.getString("Rol");
                int estado=rs.getInt("Estado");
                Usuario user=new Usuario(id,name,pass,estado,rol);
                return user;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerDatosDB.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("Ocurio un problema");
        } 
        return prueba;
    }
    public static ArrayList<Empleado> getAllEmpleados(Connection conection){
        ArrayList<Empleado> nuevo=new ArrayList<>();
        String sql="select * from usuarios u join empleados e on u.iduser=e.iduser join locales l on l.idlocal=e.idlocal where u.estado=1;"; 
        try(Statement stmt = conection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                int iduser=rs.getInt("iduser");
                String user=rs.getString("username");
                String pass=rs.getString("passwords");
                String rol=rs.getString("rol");
                int estado=rs.getInt("estado");
                String idemple=rs.getString("cedula");
                String nombre=rs.getString("nombre");
                String ape1=rs.getString("apellido");
                String mail=rs.getString("email");
                String tele=rs.getString("telefono");
                int edad=rs.getInt("edad");
                String dir=rs.getString("direccion");
                int local=rs.getInt("idlocal");
                boolean salida=rs.getBoolean("estado");
                Empleado empleado=new Empleado(iduser,user,pass,estado,rol,idemple,nombre,ape1,mail,tele,edad,dir,local,salida);
                nuevo.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("ocurrio un error");
        }
      return nuevo;  
    }
    public static ArrayList<Reporte> getReportes(Connection conection){
        ArrayList<Reporte> nuevo=new ArrayList<>();
        String sql="select pro.codigo, sum(re.cantidad) as cantidad, sum(pro.precio) as total from productos pro join reportes re on pro.codigo=re.idproducto\n" +
                    "group by pro.codigo;"; 
        try(Statement stmt = conection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                String codigo=rs.getString("codigo");
                int cantidad=rs.getInt("cantidad");
                double total=rs.getDouble("total");
                Reporte reporte=new Reporte(codigo,cantidad,total);
                nuevo.add(reporte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("ocurrio un error");
        }
        return nuevo;  
    }
    public static ArrayList<Producto> getBuscarProducto(Connection conection,String codigo,String modelo,String des){
        ArrayList<Producto> datos=new ArrayList<>();
        String sql="select * from productos where codigo like '"+codigo+"%' and modelo like '"+modelo+"%' "
                +"and descripcion like '"+des+"%';";
        System.out.println(sql);
        try(Statement stmt = conection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);){
            while(rs.next()){
                String cod=rs.getString("codigo");
                String marca=rs.getString("marca");
                String model=rs.getString("modelo");
                String color=rs.getString("color");
                String descrip=rs.getString("descripcion");
                int cantidad=rs.getInt("cantidad");
                double precio=rs.getDouble("precio");
                Producto producto=new Producto(cod,marca,model,color,descrip,cantidad,precio);
                datos.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexiondb.class.getName()).log(Level.SEVERE, null, ex);
            AlarmaMsg.setAlarma("ocurrio un error");
        }
        return datos;
    }
    
}
