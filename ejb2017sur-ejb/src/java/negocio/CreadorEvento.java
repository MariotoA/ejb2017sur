/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sesion;
import exception.CreaEventoException;
import exception.CreaSesionException;
import exception.FechaSesionException;
import exception.PrecioEntradasException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
        sesiones.stream().forEach(p->compruebaSesion(p));
        em.merge(evento);
        sesiones.stream().forEach(p->em.merge(p));
    }

    private void compruebaEvento(Evento evento) {
        if (evento.getNombre() == null) {
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
    
    
}
