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
    public void creaEvento(Evento evento, List<Sesion> sesiones) throws CreaEventoException {
        compruebaEvento(evento);
        arreglaEvento(evento);
        em.merge(evento);
    }
    
    private void compruebaEvento(Evento evento) {
        if (evento.getNombre() == null || evento.getNombre().equals("")) {
            throw new CreaEventoException();
        }
    }

    private void compruebaSesion(Sesion p) {
        if (p.getPrecio()!=null && p.getPrecio()<0) {
            throw new PrecioEntradasException();
        }
        if(p.getFechaInicio().after(p.getFechaFin())) {
            throw new FechaSesionException();
        }
    }

    private void arreglaEvento(Evento evento) {
        Query q = em.createQuery("SELECT i FROM Usuario i WHERE i.nombre = :nombre", Usuario.class);
        List<Usuario> aux = q.setParameter("nombre", evento.getCreador().getNombre()).getResultList();
        Usuario autor = aux.stream().findFirst().orElse(null);
        evento.setCreador(autor);
        evento.setPublicaciones(new ArrayList<>());
    }

    @Override
    public void añadeSesiones(List<Sesion> sesiones) {
        sesiones.stream().forEach(p->compruebaSesion(p));
        sesiones.stream().forEach(p->em.merge(p));
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
    
    
}
