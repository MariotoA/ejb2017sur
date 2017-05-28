/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entities.Evento;
import entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jointables.VistaEvento;
import negocio.BuscadorEventoLocal;

/**
 *
 * @author malex
 */

@ManagedBean(name = "buscadorEvento")
@RequestScoped
public class BuscadorEventoBackingBeans {
    @EJB
    private BuscadorEventoLocal buscador;
    
    public List<VistaEvento> getEventosSegunUsuario(Usuario usuario) {
        return buscador.buscaEventosMostrablesAlUsuario(usuario);
    }
    
    public List<VistaEvento> getEventosSegunCadena(String cadena) {
        return buscador.buscaEventosValidadosQueContenganPalabra(cadena);
    }
}
