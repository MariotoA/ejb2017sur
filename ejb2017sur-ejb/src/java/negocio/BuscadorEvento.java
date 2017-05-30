/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sesion;
import entities.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jointables.VistaEvento;

/**
 *
 * @author malex
 */
@Stateless
public class BuscadorEvento implements BuscadorEventoLocal {

    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public List<String> buscaSitiosConNombresParecidos(String nombreSitio) {
        return em.createNamedQuery("Sitio.FINDSIMILARBYNAME", String.class)
                .setParameter("nombre", nombreSitio).getResultList();
    }
    
    @Override
    public VistaEvento getEventoPorNombre(String nombre) {
        return new VistaEvento(
                em.createQuery("SELECT e FROM Evento e WHERE e.nombre = :nombre"
                        ,Evento.class).setParameter("nombre", nombre)
                        .getSingleResult());
    }
    
    @Override
    public List<VistaEvento> buscaEventosMostrablesAlUsuario() {
        List<Object[]> aux = em.createNamedQuery("Sesion.FINDALLWITHEACHEVENTO").getResultList();
        return aux.stream().map(arr -> new VistaEvento((Sesion) arr[0],(Evento) arr[1])).collect(Collectors.toList());
    }
    
    
    @Override
    public List<VistaEvento> buscaEventosMostrablesAlUsuario(Usuario usuario) {
        List<Object[]> aux = em.createNamedQuery("Evento.FINDTOUSER").setParameter("usuario_id", usuario.getId()).getResultList();
        List<VistaEvento> list = aux.stream().map(arr -> new VistaEvento((Sesion) arr[0],(Evento) arr[1])).collect(Collectors.toList());
        this.buscaEventosMostrablesAlUsuario().stream().forEach(p-> list.add(p));
        return list;
    }
    
    @Override
    public List<Usuario> buscaUsuariosConNombreParecido(String nombreUsuario) {
        return em.createNamedQuery("Usuario.FINDSIMILARBYNAME")
                .setParameter("nombre", nombreUsuario)
                .getResultList();
    }

    @Override
    public List<Usuario> buscaUsuariosOrdenPorFechaIngreso() {
        return em.createNamedQuery("Usuario.FINDALLORDEREDBYINGRESO").getResultList();
    }

    @Override
    public List<VistaEvento> buscaEventosValidadosQueContenganPalabra(String cadena) {
        List<Object[]> eventosFinitosAux = em.createNamedQuery("Evento.FINDSIMILARTOWORD").setParameter("palabra", cadena).getResultList();
        List<VistaEvento> res = eventosFinitosAux.stream().map(arr -> new VistaEvento((Sesion) arr[0],(Evento) arr[1])).collect(Collectors.toList());
        List<Evento> eventosEternos = em.createNamedQuery("Evento.FINDSIMILARANDETERNAL").setParameter("palabra", cadena).getResultList();
        eventosEternos.stream().forEach(p -> res.add(new VistaEvento(p)));
        return res;
    }

    @Override
    public VistaEvento getSesionEventoPorId(Long id) {
        List<Object[]> eventosFinitosAux = em.createNamedQuery("Sesion.FINDBYIDWITHEVENTO").setParameter("id", id).getResultList();
        List<VistaEvento> res = eventosFinitosAux.stream().map(arr -> new VistaEvento((Sesion) arr[0],(Evento) arr[1])).collect(Collectors.toList());
        return res.stream().findFirst().orElse(null);
    }

    @Override
    public VistaEvento getEventoPorId(Long id) {
        System.out.println(em.find(Evento.class, id));
        return new VistaEvento(em.find(Evento.class, id));
    }

    
    
}
