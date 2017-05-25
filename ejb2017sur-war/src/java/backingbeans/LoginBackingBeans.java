/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author malex
 */

@ManagedBean(name = "login")
@SessionScoped
public class LoginBackingBeans {
    
    private final static String ADMINISTRADOR="a";
    public final static String USUARIO="USUARIO";
    public final static String PERIODISTA="PERIODISTA";
    public final static String SUPERUSUARIO="SUPERUSUARIO";
    private String nombreOCorreo;
    private String contrasena;
    private String rol;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String autenticar(){
        return null;
    }
    
}
