/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Usuario;
import exception.AutenticacionException;
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
    public Usuario loginUsuario(Usuario datosLogin, String nombreOCorreo, String pass) throws AutenticacionException {
        Query q = em.createQuery("SELECT i FROM Usuario i WHERE i.password = :pass AND (i.nombre = :nombre OR i.email = :email)");
        List<Usuario> usLogin = q.setParameter("nombre", nombreOCorreo)
                        .setParameter("email", nombreOCorreo)
                        .setParameter("pass", pass)
                .getResultList();
        Usuario u = usLogin.stream().findFirst().orElse(null);
        if (u == null) {
            throw new AutenticacionException();
        }
        introduceDatosEnInstanciaBackingBeans(datosLogin,u);
        return datosLogin;
    }

    private void introduceDatosEnInstanciaBackingBeans(Usuario usBacking, Usuario usNegocio) {
        usBacking.setNombre(usNegocio.getNombre());
        usBacking.setEmail(usNegocio.getEmail());
        usBacking.setRol(usNegocio.getRol());
        usBacking.setPassword(null);
        usBacking.setRecibirNotifiaciones(usNegocio.isRecibirNotifiaciones());
    }
    
    
}
