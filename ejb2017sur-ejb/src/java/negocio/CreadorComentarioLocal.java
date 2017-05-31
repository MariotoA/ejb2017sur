/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Publicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author malex
 */
@Local
public interface CreadorComentarioLocal {

    void creaComentario(Publicacion publicacion);

    List<Publicacion> getPublicaciones(Evento evento);
    
}
