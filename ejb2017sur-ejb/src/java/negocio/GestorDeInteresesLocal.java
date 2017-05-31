/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Evento;
import entities.Interes;
import javax.ejb.Local;

/**
 *
 * @author malex
 */
@Local
public interface GestorDeInteresesLocal {

    Long getLikes(Evento evento);

    Long getDislikes(Evento evento);

    void setInteres(Interes interes);
    
}
