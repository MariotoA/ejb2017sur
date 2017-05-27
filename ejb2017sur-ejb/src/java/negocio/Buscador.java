/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class Buscador implements BuscadorLocal {

    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public List<String> buscaSitiosConNombresParecidos(String nombreSitio) {
        return em.createNamedQuery("Sitio.FINDSIMILARBYNAME", String.class)
                .setParameter("nombre", nombreSitio).getResultList();
    }
    
    
}
