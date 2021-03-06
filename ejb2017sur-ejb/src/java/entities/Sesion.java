/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author malex
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Sesion.FINDALLWITHEACHEVENTO", 
            query="SELECT i,j FROM Sesion i JOIN i.eventoCelebrado j WHERE j.validador IS NOT NULL"),
    @NamedQuery(name="Sesion.FINDBYIDWITHEVENTO",
            query="SELECT ses,ev FROM Sesion ses JOIN ses.eventoCelebrado ev WHERE ses.id = :id")
})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double precio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    private String urlCompraEntrada;
    
 
    /*Relaciones con Evento*/
    @ManyToOne
    @JoinColumn(nullable = false)
    private Evento eventoCelebrado;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
    
    
    
    

    public Evento getEventoCelebrado() {
        return eventoCelebrado;
    }

    public void setEventoCelebrado(Evento eventoCelebrado) {
        this.eventoCelebrado = eventoCelebrado;
    }

    

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public String getUrlCompraEntrada() {
        return urlCompraEntrada;
    }

    public void setUrlCompraEntrada(String urlCompraEntrada) {
        this.urlCompraEntrada = urlCompraEntrada;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicasii.Sesion[ id=" + id + " ]";
    }
    
}
