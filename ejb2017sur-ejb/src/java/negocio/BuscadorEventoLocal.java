/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sitio;
import entities.Usuario;
import java.util.List;
import javax.ejb.Local;
import jointables.VistaEvento;

/**
 *
 * @author malex
 */
@Local
public interface BuscadorEventoLocal {

    List<String> buscaSitiosConNombresParecidos(String nombreSitio);

    List<VistaEvento> buscaEventosMostrablesAlUsuario(Usuario usuario);

    List<Usuario> buscaUsuariosConNombreParecido(String nombreUsuario);

    public List<Usuario> buscaUsuariosOrdenPorFechaIngreso();

    public List<VistaEvento> buscaEventosValidadosQueContenganPalabra(String cadena);

    public List<VistaEvento> buscaEventosMostrablesAlUsuario();

    public VistaEvento getSesionEventoPorId(Long id);

    VistaEvento getEventoPorId(Long id);

    public VistaEvento getEventoPorNombre(String get);
    
}
