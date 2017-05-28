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
    public VistaEvento(Evento ev) {
        this(null,ev);
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
    
    public boolean isEternal() {
        return this.sesion==null;
    }
}
