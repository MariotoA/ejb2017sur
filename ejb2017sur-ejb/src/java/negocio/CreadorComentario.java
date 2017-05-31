/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Publicacion;
import entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author malex
 */
@Stateless
public class CreadorComentario implements CreadorComentarioLocal {

    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public void creaComentario(Publicacion publicacion) {
        validaPublicacion(publicacion);
        em.merge(publicacion);
    }

    private void validaPublicacion(Publicacion publicacion) {
        publicacion.setCreador(em.createNamedQuery("Usuario.FINDBYNAME",Usuario.class)
                .setParameter("nombre",publicacion.getCreador().getNombre())
                .getSingleResult());
        publicacion.setSitioReferido(publicacion.getEventoReferido().getLocalizacion());
    }

    @Override
    public List<Publicacion> getPublicaciones(Evento evento) {
        return em.createNamedQuery("Publicacion.FINDALLABOUTANEVENT",Publicacion.class)
                .setParameter("id", evento.getId()).getResultList();
    }
    
    
    
}
