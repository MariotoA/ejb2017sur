/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import jointables.VistaEvento;
import negocio.BuscadorEventoLocal;
import negocio.ModificadorUsuarioLocal;

/**
 *
 * @author malex
 */
@ManagedBean(name="eventoSeleccionado")
@RequestScoped
public class EventoSeleccionadoBackingBeans {
    private VistaEvento vistaEvento;
    @EJB
    private BuscadorEventoLocal buscador;
    @EJB
    private ModificadorUsuarioLocal mod;
    public VistaEvento getVistaEvento() {
        return vistaEvento;
    }

    public void setVistaEvento(VistaEvento vistaEvento) {
        this.vistaEvento = vistaEvento;
    }

    
    @PostConstruct
    public void init() {
       
       Map<String,String> map = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
       if (map.containsKey("nombre")) {
           vistaEvento = buscador.getEventoPorNombre(map.get("nombre"));
       } else {
           Long id;
        Boolean eterno;
        id = Long.parseLong(map.get("id"));
        if (map.containsKey("eternal")) {
            eterno =  Boolean.parseBoolean(map.get("eternal"));
        } else {
            eterno=null;
        }
        
        if (eterno != null && eterno) {
            vistaEvento = buscador.getEventoPorId(id);
        } else {
            vistaEvento = buscador.getSesionEventoPorId(id);
        }}
        
    }
    
}
