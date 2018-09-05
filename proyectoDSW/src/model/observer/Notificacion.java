/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.observer;

/**
 *
 * @author Alex Macas
 */
public class Notificacion implements EstadoNotificacion{
    private boolean estado;
    
    public Notificacion(boolean estado){
        this.estado=estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void revisarNotificacion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void updateNotificacion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
