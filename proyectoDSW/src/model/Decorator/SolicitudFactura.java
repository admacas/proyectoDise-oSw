/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Decorator;

/**
 *
 * @author Alex Macas
 */
public class SolicitudFactura extends SolicitudDecorator{
    private boolean estado=false;

    public SolicitudFactura(Solicitud solicitud) {
        super(solicitud);
    }
    @Override
     public Solicitud solicitarPermiso(){
         this.estado=true;
         Solicitud nuevo=super.solicitarPermiso();
         return nuevo;
     }
    
}
