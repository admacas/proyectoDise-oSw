/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alex Macas
 */
public class Local {
    private int localId;
    private String nombre;
    private String telefono;
    private String direccion;
    private String red;

    public Local(int localId, String nombre, String telefono, String direccion, String red) {
        this.localId = localId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.red = red;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }
}
