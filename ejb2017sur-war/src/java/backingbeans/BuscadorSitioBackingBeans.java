/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Sitio;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.BuscadorSitioLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "buscadorSitio")
@RequestScoped
public class BuscadorSitioBackingBeans {
    @EJB
    private BuscadorSitioLocal buscador;
    
    public List<Sitio> buscasSitiosDeAcuerdoAUnaPalabra(String cad) {
        return buscador.buscaSitiosDeAcuerdoAUnaPalabra(cad);
    }
}
