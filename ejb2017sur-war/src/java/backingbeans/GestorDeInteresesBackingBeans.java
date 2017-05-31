/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Interes;
import entities.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jointables.VistaEvento;
import negocio.BuscadorUsuarioLocal;
import negocio.GestorDeInteresesLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "interes")
@RequestScoped
public class GestorDeInteresesBackingBeans {
    private Interes interes;
    @EJB
    private GestorDeInteresesLocal gestor;
    @EJB
    private BuscadorUsuarioLocal    buscador;
    public GestorDeInteresesBackingBeans() {
        interes = new Interes();
    }
    public void like(Evento v,Usuario us) {
        us = buscador.buscaUsuarioPorNombre(us.getNombre());
        interes.setInteresado(us);
        interes.setEventoReferido(v);
        interes.setMeGusta(true);
        gestor.setInteres(interes);
    }
    
    public void disLike(Evento v,Usuario us) {
        
        us = buscador.buscaUsuarioPorNombre(us.getNombre());
        interes.setInteresado(us);
        interes.setEventoReferido(v);
        interes.setNoMeGusta(true);
        gestor.setInteres(interes);
    }
    
    public void voyAIr(Evento v,Usuario us) {
        
        us = buscador.buscaUsuarioPorNombre(us.getNombre());
        interes.setInteresado(us);
        interes.setEventoReferido(v);
        interes.setAcudir(true);
        gestor.setInteres(interes);
    }
    
    public Long allLikes(Evento v) {
        return this.gestor.getLikes(v);
    }
    public Long allDislikes(Evento v) {
       return this.gestor.getDislikes(v);
    }
}
