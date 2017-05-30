/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Sitio;
import entities.Usuario;
import java.util.ArrayList;
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

    @Override
    public List<Sitio> buscaSitiosDeAcuerdoAUnUsuario(Usuario us) {
        List<Sitio> res = new ArrayList<>();
        if (us.getCiudad() != null) {
            
            em.createNamedQuery("Sitio.FINDINCIUDAD",Sitio.class).setParameter("ciudad", us.getCiudad()).getResultList().stream().forEach(p->res.add( p));
        } else if (us.getProvincia() != null) {
    
            em.createNamedQuery("Sitio.FINDINPROVINCIA",Sitio.class).setParameter("provincia", us.getCiudad()).getResultList().stream().filter(p->!res.contains(p)).forEach(p->res.add( p));
        } else if (us.getComunidadAutonoma() != null) {
        
            em.createNamedQuery("Sitio.FINDINCA",Sitio.class).setParameter("comunidad", us.getComunidadAutonoma()).getResultList().stream().filter(p->!res.contains(p)).forEach(p->res.add( p));
        } else if (us.getPais() != null){
            em.createNamedQuery("Sitio.FINDPAIS",Sitio.class).setParameter("pais", us.getPais()).getResultList().stream().filter(p->!res.contains(p)).forEach(p->res.add( p));
        } else {
            em.createNamedQuery("Sitio.FINDALLVALIDATED",Sitio.class).getResultList().stream().filter(p->!res.contains(p)).forEach(p->res.add( p));
       
        }
        return res;
    }

    @Override
    public List<Sitio> buscaSitiosDeAcuerdoAUnUsuario() {
        return em.createNamedQuery("Sitio.FINDALLVALIDATED",Sitio.class).getResultList();
    }

    @Override
    public Sitio getSitioPorId(Long id) {
        return em.find(Sitio.class, id);
    }
    
    
    
    
}
