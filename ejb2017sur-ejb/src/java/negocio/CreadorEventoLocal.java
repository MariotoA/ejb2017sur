/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Sesion;
import entities.Sitio;
import exception.CreaEventoException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author malex
 */
@Local
public interface CreadorEventoLocal {

    Evento creaEvento(Evento evento, List<Sesion> sesiones) throws CreaEventoException;


    void mensajeError(Object parameter);

    Sitio obtenSitioAPartirDeSuNombre(String nombreSitio);

    List<Sitio> getAllSitios();
    
}
