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
public abstract class SolicitudDecorator implements Solicitud{
    protected Solicitud solicitud;
    
    public SolicitudDecorator(Solicitud solicitud){
        this.solicitud=solicitud;
    }
    @Override
     public Solicitud solicitarPermiso(){
         return solicitud.solicitarPermiso();
     }
    
    
}
