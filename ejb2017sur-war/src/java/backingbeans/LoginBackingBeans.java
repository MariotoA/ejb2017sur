/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Usuario;
import exception.AutenticacionException;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jointables.VistaEvento;
import negocio.BuscadorEventoLocal;
import negocio.LoginLocal;
import negocio.ModificadorUsuarioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "login")
@SessionScoped
public class LoginBackingBeans {
    
    private String nombreOCorreo;
    private String contrasena;
    private Usuario usuario;
    @EJB
    private LoginLocal login;
    @EJB
    private BuscadorEventoLocal ev;
    
    
    public LoginBackingBeans() {
    
    }
    public String getNombreOCorreo() {
        return nombreOCorreo;
    }

    public void setNombreOCorreo(String nombreOCorreo) {
        this.nombreOCorreo = nombreOCorreo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public synchronized String autenticar(){
        String next=null;
        try {
            usuario = new Usuario();
            login.loginUsuario(usuario, nombreOCorreo, contrasena.hashCode());
            next="eventoGenerico.xhtml";
        } catch (AutenticacionException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nombre o contraseña no existentes",null);
            FacesContext.getCurrentInstance().addMessage("barra_registro:botonLogin", fm);
            usuario = null;
        }
        return next;
    }
    public boolean isLogged() {
        return usuario != null;
    }
    
    public boolean isPeriodista() {
        return this.isLogged()&&usuario.getRol().equals(Usuario.PERIODISTA);
    }
    
    public synchronized String logout() {
        nombreOCorreo = null;
        contrasena = null;
        usuario = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        return null;
    }
    
    public boolean puedeEditar() {
        Evento eventoEditable=new Evento();
        Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (map.containsKey("id")&&map.containsKey("eterno")) {
            Long l = Long.parseLong(map.get("id"));
            if (Boolean.parseBoolean(map.get("eterno"))) {
                eventoEditable = this.ev.getEventoPorId(l).getEvento();
            } else {
                eventoEditable = this.ev.getSesionEventoPorId(l).getEvento();
            }
        }
        return isLogged() && eventoEditable.getCreador().getNombre().equals(this.usuario.getNombre())
                || isPeriodista();
    }
}
