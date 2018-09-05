/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chainofresponsability;

import model.Empleado;

/**
 *
 * @author Alex Macas
 */
public interface ManejadorEmpleado {
    public void setNext(Empleado e);
    public Empleado handle(String solicitud);
    
}
