/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import negocio.BuscadorUsuarioLocal;
import negocio.ModificadorUsuario;
import negocio.ModificadorUsuarioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "perfil")
@RequestScoped
public class PerfilUsuarioBackingBeans {
   
   
   private Usuario usuario;
   @EJB
   private ModificadorUsuarioLocal mod;
   @EJB
   private BuscadorUsuarioLocal buscador;
   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   public String modificarUsuario() {
       mod.refrescarUsuario(usuario);
       return null;
   }
   
   public String creaPerfil(Usuario us) {
       usuario = buscador.buscaUsuarioPorNombre(us.getNombre());
       return "perfil.xhtml";
   }
   
    
}
