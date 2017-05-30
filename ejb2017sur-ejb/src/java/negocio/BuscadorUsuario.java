/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class BuscadorUsuario implements BuscadorUsuarioLocal {
    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;
    
    @Override
    public Usuario buscaUsuarioPorNombre(String nombreUsuario) {
        return em.createNamedQuery("Usuario.FINDBYNAME",Usuario.class).setParameter("nombre", nombreUsuario).getSingleResult();
    }
    
}
