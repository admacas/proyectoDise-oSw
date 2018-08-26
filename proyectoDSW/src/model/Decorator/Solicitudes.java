/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorator;

import model.Empleado;

/**
 *
 * @author Alex Macas
 */
public class Solicitudes implements Solicitud{
    protected Empleado empleado;
    private String solicitud;
    private String codigoFactura;

    @Override
    public Solicitud solicitarPermiso() {
        Solicitud soli=new Solicitudes();
        return soli;
    }
    
    
}
