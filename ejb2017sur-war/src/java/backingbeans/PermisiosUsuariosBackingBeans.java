/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import negocio.ModificadorUsuarioLocal;
import negocio.BuscadorEventoLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "permisos")
@RequestScoped
public class PermisiosUsuariosBackingBeans {
    @EJB
    private BuscadorEventoLocal buscador;
    @EJB
    private ModificadorUsuarioLocal modificador;
    private Usuario seleccionado;
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.modificador.message(rol);
        this.rol = rol;
    }
    
    public Usuario getSeleccionado() {
        return seleccionado;
    }
    public void setSeleccionado(Usuario us, String rol) {
        us.setRol(rol);
        this.seleccionado = us;
    }
    public void setSeleccionado(Usuario seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    public List<Usuario> completar(String query)  {
        return this.buscador.buscaUsuariosConNombreParecido(query);
    }
    public List<Usuario> getUsuarios() {
        return this.buscador.buscaUsuariosOrdenPorFechaIngreso();
    }
    public void cambiaRol(Usuario us){
        this.modificador.message(us.getRol());
        us.setRol(rol);
       this.modificador.refrescarUsuario(us);
    }
}
