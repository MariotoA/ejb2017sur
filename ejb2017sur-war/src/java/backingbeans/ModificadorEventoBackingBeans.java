/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Usuario;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.BuscadorEventoLocal;
import negocio.CreadorEventoLocal;

/**
 *
 * @author malex
 */
@ManagedBean(name="modificadorEvento")
@RequestScoped
public class ModificadorEventoBackingBeans {
    private Evento evento;
    private Boolean validar;
    @EJB
    private CreadorEventoLocal creador;
    @EJB
    private BuscadorEventoLocal buscador;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }
    
    @PostConstruct
    public void init() {
        Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(map.get("id"));
        Boolean bool = Boolean.parseBoolean(map.get("eterno"));
        if (bool) {
        evento = buscador.getEventoPorId(id).getEvento();
        }  else {
        evento = buscador.getSesionEventoPorId(id).getEvento();
        
        }
        validar = evento.getValidador()!=null;
        
    }
    
    public void modificaNombre(Usuario us) {
        if (validar) {
            evento.setValidador(us);
        }
        creador.creaEvento(evento,null);
    }
}
