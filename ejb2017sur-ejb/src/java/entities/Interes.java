/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author malex
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Interes.FINDALLLIKES",query="SELECT COUNT(i.meGusta) FROM Interes i join i.eventoReferido e WHERE e.id=:id"),
    @NamedQuery(name="Interes.FINDALLDISLIKES",query="SELECT COUNT(i.noMeGusta) FROM Interes i join i.eventoReferido e WHERE e.id=:id"),
    @NamedQuery(name="Interes.FINDINTERESPREVIOUSLYDECLARED",query="SELECT i FROM Interes i JOIN i.interesado u JOIN i.eventoReferido e WHERE u.id = :id AND i.id = :evento")
})
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean meGusta;
    private Boolean noMeGusta;
    private Boolean acudir;
    
    
    /*interes--usuario*/
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario interesado;
    
    /*interes--Evento*/
    @ManyToOne  
    @JoinColumn(nullable = false) 
    private Evento eventoReferido;

    
    
    public Usuario getInteresado() {
        return interesado;
    }

    public void setInteresado(Usuario interesado) {
        this.interesado = interesado;
    }

    public Evento getEventoReferido() {
        return eventoReferido;
    }

    public void setEventoReferido(Evento eventoReferido) {
        this.eventoReferido = eventoReferido;
    }

    public Boolean getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(Boolean meGusta) {
        this.meGusta = meGusta;
    }

    public Boolean getNoMeGusta() {
        return noMeGusta;
    }

    public void setNoMeGusta(Boolean noMeGusta) {
        this.noMeGusta = noMeGusta;
    }

    public Boolean getAcudir() {
        return acudir;
    }

    public void setAcudir(Boolean acudir) {
        this.acudir = acudir;
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
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicasii.Interes[ id=" + id + " ]";
    }
    
}
