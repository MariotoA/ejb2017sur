/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sesion;
import exception.FechaSesionException;
import exception.PrecioEntradasException;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class CreadorSesion implements CreadorSesionLocal {

    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public void creaSesion(Sesion sesion) {
        this.compruebaSesion(sesion);
        this.em.merge(sesion);
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
