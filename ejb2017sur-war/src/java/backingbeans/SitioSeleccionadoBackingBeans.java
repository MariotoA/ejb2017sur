/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Sitio;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.BuscadorEventoLocal;
import negocio.BuscadorSitioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "sitioSeleccionado")
@RequestScoped
public class SitioSeleccionadoBackingBeans {
    private Sitio sitio;

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }
    
    @EJB
    private BuscadorSitioLocal buscador;
    @PostConstruct
    public void init() {
       
       Map<String,String> map = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
      
        Long id = Long.parseLong(map.get("id"));
        
            sitio = buscador.getSitioPorId(id);
        
       
        
    }
}
