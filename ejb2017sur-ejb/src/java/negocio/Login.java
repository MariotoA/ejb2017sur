/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Usuario;
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
public class Login implements LoginLocal {
    
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;

    @Override
    public void loginUsuario(Usuario datosLogin) {
        Query q = em.createQuery("SELECT i FROM Usuario i WHERE i.password = :pass AND (i.nombre = :nombre OR i.email = :email)");
        List<Usuario> usLogin = q.setParameter("nombre", datosLogin.getNombre())
                        .setParameter("email", datosLogin.getEmail())
                        .setParameter("pass", datosLogin.getPassword())
                .getResultList();
        Usuario u = usLogin.stream().findFirst().orElse(null);
        if (u!=null) {
           //PALANTE 
        }
    }
    
    
}
