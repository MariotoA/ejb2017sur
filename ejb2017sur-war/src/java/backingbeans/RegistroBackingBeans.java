/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import exception.ContraseniaInvalidaException;
import exception.CorreoInvalidoException;
import exception.NombreInvalidoUsuarioException;
import negocio.RegistroLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "registro")
@RequestScoped
public class RegistroBackingBeans {
    @EJB
    private RegistroLocal reg;
    
    private Usuario us;
    private String repetirPass;
    
    
    public RegistroBackingBeans() {
        this.us = new Usuario();
        this.us.setId(Long.MIN_VALUE);
    }
    
    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public String getRepetirPass() {
        return repetirPass;
    }

    public void setRepetirPass(String repetirPass) {
        this.repetirPass = repetirPass;
    }
    
    public String registrarUsuario() {
        String next=null;
        try {
            if (this.us.getPassword().equals(this.repetirPass)) {
                reg.registrarUsuario(us);
                next="confirmacion.xhtml";
            } else {
                
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La contraseña no coincide.",null);
            FacesContext.getCurrentInstance().addMessage("Registro_datos:repassRegistro", fm);
            }
        } catch (CorreoInvalidoException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"El correo introducido es invalido, debe seguir el formato "
                    + "palabra@palabra.dominio",null);
            FacesContext.getCurrentInstance().addMessage("Registro_datos:emailRegistro", fm);
        }catch (NombreInvalidoUsuarioException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"El nombre introducido es invalido",null);
            FacesContext.getCurrentInstance().addMessage("Registro_datos:nombreRegistro", fm);
        }catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La pass introducida es invalida, debe ser de 8 a mas caracteres",null);
            FacesContext.getCurrentInstance().addMessage("Registro_datos:passRegistro", fm);
        }
        return next;
    }
    
}
