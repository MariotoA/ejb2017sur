/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sesion;
import entities.Sitio;
import entities.Usuario;
import exception.CreaEventoException;
import exception.FechaSesionException;
import exception.PrecioEntradasException;
import java.util.ArrayList;
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
public class CreadorEvento implements CreadorEventoLocal {

    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public Evento creaEvento(Evento evento, List<Sesion> sesiones) throws CreaEventoException {
        compruebaEvento(evento);
        arreglaEvento(evento);
        
        return em.merge(evento);
    }
    
    private void compruebaEvento(Evento evento) {
        if (evento.getNombre() == null || evento.getNombre().equals("")) {
            throw new CreaEventoException();
        }
    }

   
    private void arreglaEvento(Evento evento) {
        Query q = em.createQuery("SELECT i FROM Usuario i WHERE i.nombre = :nombre", Usuario.class);
        List<Usuario> aux = q.setParameter("nombre", evento.getCreador().getNombre()).getResultList();
        Usuario autor = aux.stream().findFirst().orElse(null);
        if (evento.getValidador()!= null) {
            Usuario validador = em.createQuery("SELECT i FROM Usuario i WHERE i.nombre = :nombre", Usuario.class)
                    .setParameter("nombre", evento.getValidador().getNombre()).getSingleResult();
            evento.setValidador(validador);
        }
        evento.setCreador(autor);
        evento.setPublicaciones(new ArrayList<>());
        evento.setInteresesSobreElEvento(new ArrayList<>());
        evento.setLocalizacion(this.obtenSitioAPartirDeSuNombre(evento.getLocalizacion().getNombre()));
        if (!autor.getRol().equals(Usuario.USUARIO)) {
            evento.setValidador(autor);
        } else {
            evento.setValidador(null);
        }
    }


    @Override
    public void mensajeError(Object parameter) {
        System.out.println(parameter.toString());
    }

    @Override
    public Sitio obtenSitioAPartirDeSuNombre(String nombreSitio) {
        Query q = em.createQuery("SELECT i FROM Sitio i WHERE i.nombre = :nombre", Sitio.class);
        List<Sitio> aux = q.setParameter("nombre", nombreSitio).getResultList();
        return aux.stream().findFirst().orElse(null);
    }

    @Override
    public List<Sitio> getAllSitios() {
        return em.createNamedQuery("Sitio.FINDALL",Sitio.class).getResultList();
    }
    
    
}
