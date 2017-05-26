/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Sesion;
import entities.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.CreadorEventoLocal;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author malex
 */
@ManagedBean(name = "creaEvento")
@RequestScoped
public class CreadorEventoBackingBeans {
    private Evento evento;
    private List<Sesion> sesiones;
    private Date fechaInicioSesion;
    private Date fechaFinSesion;
    private String urlCompraEntrada;
    private Double precio;
    @EJB
    private CreadorEventoLocal creador;
    
    public CreadorEventoBackingBeans() {
        evento = new Evento();
        sesiones = new ArrayList<>();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getFechaInicioSesion() {
        return fechaInicioSesion;
    }

    public void setFechaInicioSesion(Date fechaInicioSesion) {
        this.fechaInicioSesion = fechaInicioSesion;
    }

    public Date getFechaFinSesion() {
        return fechaFinSesion;
    }

    public void setFechaFinSesion(Date fechaFinSesion) {
        this.fechaFinSesion = fechaFinSesion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String getUrlCompraEntrada() {
        return urlCompraEntrada;
    }

    public void setUrlCompraEntrada(String urlCompraEntrada) {
        this.urlCompraEntrada = urlCompraEntrada;
    }
    
    public void creaSesion() {
        Sesion ses = new Sesion();
        ses.setId(Long.MIN_VALUE);
        ses.setFechaInicio(fechaInicioSesion);
        ses.setFechaFin(fechaFinSesion);
        ses.setEventoCelebrado(evento);
        ses.setPrecio(precio);
        ses.setUrlCompraEntrada(urlCompraEntrada);
    }
    
    public String creaEvento(Usuario autor){
        this.evento.setCreador(autor);
        this.evento.setPrioridad(0);
        this.evento.setSesionesCelebradas(sesiones);
        this.evento.getLocalizacion().getEventosCelebrados().add(evento);
        sesiones.stream().forEach(p-> p.setEventoCelebrado(evento));
        
        return null;
    }
}
