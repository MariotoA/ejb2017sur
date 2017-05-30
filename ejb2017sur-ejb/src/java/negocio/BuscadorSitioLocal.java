/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Sitio;
import entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author malex
 */
@Local
public interface BuscadorSitioLocal {

    List<Sitio> buscaSitiosDeAcuerdoAUnaPalabra(String palabra);

    public List<Sitio> buscaSitiosDeAcuerdoAUnUsuario(Usuario us);

    List<Sitio> buscaSitiosDeAcuerdoAUnUsuario();

    public Sitio getSitioPorId(Long id);

    
}
