/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jointables.VistaEvento;
import negocio.BuscadorEventoLocal;
import negocio.ModificadorUsuarioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "irAEvento")
@RequestScoped
public class IrAEventoBackingBeans {
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
    
    public String chooseId(VistaEvento ev) {
        return ev.isEternal()? Long.toString(ev.getEvento().getId()) : Long.toString(ev.getSesion().getId());
    }
    
    public String irAEvento() {
        return "eventoDetalle.xhtml";
    }
    
    @PostConstruct
    public void init() {
        Map<String,String> map = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
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
        }
    }

}
