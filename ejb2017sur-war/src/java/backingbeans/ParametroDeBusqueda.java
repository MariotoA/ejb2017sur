/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.ModificadorUsuarioLocal;

/**
 *
 * @author malex
 */
@ManagedBean(name = "cadenaBusqueda")
@RequestScoped
public class ParametroDeBusqueda {
    private String cadena;
    @EJB
    private ModificadorUsuarioLocal b;
    public String getCadena() {
        return cadena;
    }

    public synchronized void setCadena(String cadena) {
        this.cadena = cadena;
        
    }
    
}
