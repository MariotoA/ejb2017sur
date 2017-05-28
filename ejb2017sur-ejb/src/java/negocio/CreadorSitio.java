/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Sitio;
import entities.Usuario;
import exception.CreaSitioException;
import exception.NombreInvalidoSitioException;
import exception.SitioRepetidoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author malex
 */
@Stateless
public class CreadorSitio implements CreadorSitioLocal {

    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public void creaSitio(Sitio sitio) throws CreaSitioException {
        validaSitio(sitio);
        arreglaSitio(sitio);
        em.merge(sitio);
        
    }

    private void validaSitio(Sitio sitio) {
        String nombre = sitio.getNombre();
        Query q = em.createQuery("SELECT i.nombre FROM Sitio i WHERE i.nombre = :nombre",String.class);
        if (nombre == null || nombre.equals("")) {
            throw new NombreInvalidoSitioException();
        }
        List<String> aux = q.setParameter("nombre", nombre).getResultList();
        String sit = aux.stream().findFirst().orElse(null);
        
        if (sit != null) {
            throw new SitioRepetidoException();
        }
        
        
    }

    private void arreglaSitio(Sitio sitio) {
        Query q = em.createNamedQuery("Usuario.FINDBYNAME",Usuario.class);
        List<Usuario> aux = q.setParameter("nombre", sitio.getCreador().getNombre())
                .getResultList();
        Usuario creador = aux.stream().findFirst().orElse(null);
        sitio.setCreador(creador);
        if (sitio.getValidador() != null) {
            sitio.setValidador(creador);
        }
    }

    
    
}
