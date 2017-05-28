/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Sitio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class BuscadorSitio implements BuscadorSitioLocal {

    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public List<Sitio> buscaSitiosDeAcuerdoAUnaPalabra(String palabra) {
        return em.createNamedQuery("Sitio.FINSIMILARBYWORD",Sitio.class)
                .setParameter("palabra", palabra).getResultList();
    }
    
    
}
