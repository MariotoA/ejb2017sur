/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jointables;

import entities.Evento;
import entities.Sesion;

/**
 *
 * @author malex
 */
public class VistaEvento {
    private Evento evento;
    private Sesion sesion;
    
    public VistaEvento() {
    }
    
    public VistaEvento(Sesion ses, Evento ev) {
        this.evento = ev;
        this.sesion = ses;
    }
    public String next() {
        return String.format("eventoDetalle.xhtml?id=%s&eterno=%s", Long.toString(this.chooseId()),Boolean.toString(this.isEternal()));
    }
    public VistaEvento(Evento ev) {
        this(new Sesion(),ev);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public Long chooseId() {
        return this.isEternal()? this.evento.getId() : this.sesion.getId();
    }
    public boolean isEternal() {
        return this.sesion.getId()==null;
    }
    
    @Override
    public String toString() {
        return this.sesion+ " " + this.evento;
    }
    
}
