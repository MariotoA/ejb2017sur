/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Sesion;
import exception.FechaSesionException;
import exception.PrecioEntradasException;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.BuscadorEventoLocal;
import negocio.CreadorSesionLocal;
/**
 *
 * @author malex
 */

@ManagedBean(name = "creaSesion")
@RequestScoped
public class CreadorSesionBackingBeans {
    private Sesion sesion;
    @EJB
    private CreadorSesionLocal creador;
    @EJB
    private BuscadorEventoLocal buscador;

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    
    @PostConstruct
    public void init() {
        
        sesion = new Sesion();
        sesion.setId(Long.MIN_VALUE);
        Evento evento=null;
        Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (map.containsKey("id")&&map.containsKey("eterno")) {
            Long l = Long.parseLong(map.get("id"));
            if (Boolean.parseBoolean(map.get("eterno"))) {
                evento = this.buscador.getEventoPorId(l).getEvento();
            } else {
                evento = this.buscador.getSesionEventoPorId(l).getEvento();
            }
        }
        this.sesion.setEventoCelebrado(evento);
        
    }
    
    public void creaSesion() {
        try {
            this.creador.creaSesion(sesion);
        } catch (FechaSesionException e) {
                
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La fecha fin no puede ser anterior a la de inicio.",null);
            FacesContext.getCurrentInstance().addMessage("crea_sesion:fecha_Fin_Crea", fm);
        } catch (PrecioEntradasException e) {
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Precio no válido.",null);
            FacesContext.getCurrentInstance().addMessage("crea_sesion:Precio", fm);
        }
    }
}
