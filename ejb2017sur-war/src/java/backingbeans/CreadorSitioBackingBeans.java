/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Sitio;
import entities.Usuario;
import exception.NombreInvalidoSitioException;
import exception.SitioRepetidoException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.CreadorSitioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "creaSitio")
@RequestScoped
public class CreadorSitioBackingBeans {
    private Sitio sitio;
    @EJB
    private CreadorSitioLocal creador;
    
    public CreadorSitioBackingBeans() {
        sitio = new Sitio();
        sitio.setId(Long.MIN_VALUE);
        sitio.setEventosCelebrados(new ArrayList<>());
        sitio.setPublicaciones(new ArrayList<>());
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }
    
    public String crearSitio(Usuario autor) {
        try {
        this.sitio.setCreador(autor);
        if (!autor.getRol().equals(Usuario.USUARIO)) {
            this.sitio.setValidador(autor);
        }
        creador.creaSitio(sitio);
        } catch (NombreInvalidoSitioException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nombre no introducido",null);
            FacesContext.getCurrentInstance().addMessage("Crea_Sitios:Nombre_Sitio", fm);
        } catch (SitioRepetidoException e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sitio ya existente",null);
            FacesContext.getCurrentInstance().addMessage("Crea_Sitios:Nombre_Sitio", fm);
        }
        return null;
    }
}
