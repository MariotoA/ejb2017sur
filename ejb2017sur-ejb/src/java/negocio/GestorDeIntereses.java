/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Interes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class GestorDeIntereses implements GestorDeInteresesLocal {

    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;
    @Override
    public Long getLikes(Evento evento) {
        return em.createNamedQuery("Interes.FINDALLLIKES",Long.class).setParameter("id", evento.getId()).getSingleResult();
    }

    @Override
    public Long getDislikes(Evento evento) {
        return em.createNamedQuery("Interes.FINDALLDISLIKES",Long.class).setParameter("id", evento.getId()).getSingleResult();
    }

    @Override
    public void setInteres(Interes interes) {
        validaInteres(interes);
        em.merge(interes);
    }

    private void validaInteres(Interes interes) {
        List<Interes> aux = em.createNamedQuery("Interes.FINDINTERESPREVIOUSLYDECLARED",Interes.class)
                .setParameter("id", interes.getInteresado().getId())
                .setParameter("evento", interes.getEventoReferido().getId())
                .getResultList();
        
        if (!aux.isEmpty()) {
            Interes interesAnterior = aux.stream().findFirst().orElse(interes);
            interes.setId(interesAnterior.getId());
            interes.setAcudir((interesAnterior.getAcudir()==null||!interesAnterior.getAcudir())&&interes.getAcudir());
        }
        
    }


    
}
