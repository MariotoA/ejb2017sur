/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Publicacion;
import entities.Usuario;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.BuscadorEventoLocal;
import negocio.CreadorComentario;
import negocio.CreadorComentarioLocal;

/**
 *
 * @author malex
 */
@ManagedBean(name="creadorComentario")
@RequestScoped
public class CreadorComentarioBackingBeans {
    @EJB
    private CreadorComentarioLocal creador;
    @EJB
    private BuscadorEventoLocal buscadorEvento;
    private Evento evento;
    private Publicacion pub;
    
    
    public CreadorComentarioBackingBeans() {
        pub = new Publicacion();
        pub.setId(Long.MIN_VALUE);
    }

    public Publicacion getPub() {
        return pub;
    }

    public void setPub(Publicacion pub) {
        this.pub = pub;
    }
    
    @PostConstruct
    public void init() {
        evento=new Evento();
        Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (map.containsKey("id")&&map.containsKey("eterno")) {
            Long l = Long.parseLong(map.get("id"));
            if (Boolean.parseBoolean(map.get("eterno"))) {
                evento = this.buscadorEvento.getEventoPorId(l).getEvento();
            } else {
                evento = this.buscadorEvento.getSesionEventoPorId(l).getEvento();
            }
        }
    }
    
    public void creaComentario(Usuario us) {
        
        
        this.pub.setCreador(us);
        this.pub.setEventoReferido(evento);
        this.creador.creaComentario(pub);
    }
    
    public List<Publicacion> getComentarios() {
        return this.creador.getPublicaciones(evento);
    }
}
