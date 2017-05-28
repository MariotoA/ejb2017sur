/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author malex
 */
@Entity
@NamedQueries ({
    @NamedQuery(name="Evento.FINDEVENTSBYNAME",
            query="SELECT e FROM Evento e WHERE e.nombre = :nombre"),
    @NamedQuery(name="Evento.FINDSIMILARANDETERNAL",
            query="SELECT j FROM Evento j WHERE j.validador IS NOT NULL AND j.id NOT IN (SELECT e.id FROM Sesion s join s.eventoCelebrado e) AND (UPPER(j.nombre) LIKE CONCAT('%',CONCAT(UPPER(:palabra),'%')) OR UPPER(j.tag) = UPPER(:palabra) OR UPPER(j.localizacion.nombre) LIKE CONCAT('%',CONCAT(UPPER(:palabra),'%')))"),
    @NamedQuery(name="Evento.FINDSIMILARTOWORD", 
            query="SELECT j,i FROM Sesion i JOIN i.eventoCelebrado j WHERE j.validador IS NOT NULL AND (UPPER(j.nombre) LIKE concat('%',concat(UPPER(:palabra),'%')) OR UPPER(j.tag) = UPPER(:palabra) OR UPPER(j.localizacion.nombre) LIKE concat('%',concat(UPPER(:palabra),'%')) OR UPPER(j.descripcion) LIKE concat('%',concat(UPPER(:palabra),'%')) )")
})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column(nullable=false)
    private String nombre;
    private String descripcion;
    private String tag;
    private String foto;
    private String video;
    private int prioridad;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario creador;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Usuario validador;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Sitio localizacion;
    
    /*Relaciones con Publicaciones*/
    @OneToMany(mappedBy="eventoReferido")
    private List<Publicacion> publicaciones;
    
    
    /*Relaciones con Sesion*/
    @OneToMany(mappedBy="eventoCelebrado")
    private List<Sesion> sesionesCelebradas;
    

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Usuario getValidador() {
        return validador;
    }

    public void setValidador(Usuario validador) {
        this.validador = validador;
    }

    public Sitio getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Sitio localizacion) {
        this.localizacion = localizacion;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<Sesion> getSesionesCelebradas() {
        return sesionesCelebradas;
    }

    public void setSesionesCelebradas(List<Sesion> sesionesCelebradas) {
        this.sesionesCelebradas = sesionesCelebradas;
    }
    
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicasii.Evento[ id=" + id + " ]";
    }
    

}
