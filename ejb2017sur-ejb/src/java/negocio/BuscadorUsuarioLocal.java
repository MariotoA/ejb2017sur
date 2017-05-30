/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Usuario;
import javax.ejb.Local;

/**
 *
 * @author malex
 */
@Local
public interface BuscadorUsuarioLocal {

    Usuario buscaUsuarioPorNombre(String nombreUsuario);
    
}
