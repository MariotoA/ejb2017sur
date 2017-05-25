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
import javax.persistence.OneToMany;

/**
 *
 * @author malex
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String pais;
    private String comunidadAutonoma;
    private String provincia;
    private String ciudad;
    @Column(nullable = false)
    private String rol;
    private boolean recibirNotifiaciones;
    
    /*Relaciones con evento.*/
    @OneToMany(mappedBy="creador")
    private List<Evento> eventosCreados;
    @OneToMany(mappedBy="validador")
    private List<Evento> eventosValidados;
    //
    /*Relaciones con sitio*/
    @OneToMany(mappedBy="creador")
    private List<Evento> sitiosCreados;
    @OneToMany(mappedBy="validador")
    private List<Evento> sitiosValidados;
    //
     /*Relaciones con publicacion*/
    @OneToMany(mappedBy="creador")
    private List<Publicacion> publicacionesCreadas;
    //
     /*Relaciones con Interes*/
    @OneToMany(mappedBy="interesado")
    private List<Interes> interesesReflejados;

    
    
    
    
    
    
    
    
    
    
    
    
    public List<Evento> getEventosCreados() {
        return eventosCreados;
    }

    public void setEventosCreados(List<Evento> eventosCreados) {
        this.eventosCreados = eventosCreados;
    }

    public List<Evento> getEventosValidados() {
        return eventosValidados;
    }

    public void setEventosValidados(List<Evento> eventosValidados) {
        this.eventosValidados = eventosValidados;
    }

    public List<Evento> getSitiosCreados() {
        return sitiosCreados;
    }

    public void setSitiosCreados(List<Evento> sitiosCreados) {
        this.sitiosCreados = sitiosCreados;
    }

    public List<Evento> getSitiosValidados() {
        return sitiosValidados;
    }

    public void setSitiosValidados(List<Evento> sitiosValidados) {
        this.sitiosValidados = sitiosValidados;
    }

    public List<Publicacion> getPublicacionesCreadas() {
        return publicacionesCreadas;
    }

    public void setPublicacionesCreadas(List<Publicacion> publicacionesCreadas) {
        this.publicacionesCreadas = publicacionesCreadas;
    }

    public List<Interes> getInteresesReflejado() {
        return interesesReflejados;
    }

    public void setInteresesReflejado(List<Interes> interesesReflejado) {
        this.interesesReflejados = interesesReflejado;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComunidadAutonoma() {
        return comunidadAutonoma;
    }

    public void setComunidadAutonoma(String comunidadAutonoma) {
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isRecibirNotifiaciones() {
        return recibirNotifiaciones;
    }

    public void setRecibirNotifiaciones(boolean recibirNotifiaciones) {
        this.recibirNotifiaciones = recibirNotifiaciones;
    }

    public List<Interes> getInteresesReflejados() {
        return interesesReflejados;
    }

    public void setInteresesReflejados(List<Interes> interesesReflejados) {
        this.interesesReflejados = interesesReflejados;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicasii.USUARIO[ id=" + id + " ]";
    }

}
