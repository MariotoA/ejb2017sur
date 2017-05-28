/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Sesion;
import entities.Sitio;
import entities.Usuario;
import exception.FechaSesionException;
import exception.NombreInvalidoEventoException;
import exception.PrecioEntradasException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.CreadorEventoLocal;
import negocio.BuscadorEventoLocal;

/**
 *
 * @author malex
 */
@ManagedBean(name = "creaEvento")
@RequestScoped
public class CreadorEventoBackingBeans {
    private Evento evento;
    private String nombreSitio;
    @EJB
    private CreadorEventoLocal creador;
    @EJB
    private BuscadorEventoLocal buscador;
    
    public CreadorEventoBackingBeans() {
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

   
    public String getNombreSitio() {
        return this.nombreSitio;
    }

    public void setNombreSitio(String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }
    
    public List<String> completaNombreEvento(String nombreSitio) {
        return this.buscador.buscaSitiosConNombresParecidos(nombreSitio);
    }
    
    public String creaEvento(Usuario autor){
        try {
        Sitio sit = new Sitio();
        sit.setNombre(nombreSitio);
        this.evento.setCreador(autor);
        this.evento.setPrioridad(0);
        this.evento.setLocalizacion(sit);
        //this.evento.getLocalizacion().getEventosCelebrados().add(evento);
        //sesiones.stream().forEach(p-> p.setEventoCelebrado(evento));
        this.creador.creaEvento(evento,null);
        } catch (NombreInvalidoEventoException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"El nombre de evento es obligatorio.",null);
            FacesContext.getCurrentInstance().addMessage("Crear_Evento:Nombre_Evento", fm);
        } catch (PrecioEntradasException e) {
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Precio introducido no válido",null);
            FacesContext.getCurrentInstance().addMessage("Creacion_Datos_Sesiones:botonLogin", fm);
        } catch (FechaSesionException e) {
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Las fechas intrducidas son imposibles.",null);
            FacesContext.getCurrentInstance().addMessage("Creacion_Datos_Sesiones:fecha_Fin_Crea", fm);
        }
        return null;
    }
}
