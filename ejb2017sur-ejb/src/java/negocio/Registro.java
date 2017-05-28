/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import exception.NombreInvalidoUsuarioException;
import exception.RegistroException;
import exception.ContraseniaInvalidaException;
import exception.CorreoInvalidoException;
import entities.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author malex
 */
@Stateless
public class Registro implements RegistroLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName="ejb2017sur-ejbPU")
    private EntityManager em;
    private final int TAM_CADENA_VALIDACION = 30;

    @Override
    public void registrarUsuario(Usuario u) throws RegistroException {
        Usuario us = em.find(Usuario.class, u.getId());
        if (us != null) {
            throw new RegistroException();
        }
        this.compruebaValidezRegistro(u);
        
        u.setRol(Usuario.USUARIO);
        u.setFechaIngreso(new Date());
        em.merge(u);
        System.out.println(this.generarCadenaAleatoria());
        
    }
    
    
    
    private String generarCadenaAleatoria() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
            int v = rnd.nextInt(62);
            if (v < 26) {
                sb.append((char) ('a' + v));
            } else if (v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();

    }

    private void compruebaValidezRegistro(Usuario us) {
        Query qNombres = em.createQuery("SELECT i.nombre from Usuario i");
        Query qCorreos = em.createQuery("SELECT i.email from Usuario i");
        List<String> nombres = qNombres.getResultList();
        List<String> correos = qCorreos.getResultList();
        
        if (us.getNombre()== null || us.getNombre().equals("") || nombres.contains(us.getNombre())) {
            throw new NombreInvalidoUsuarioException();
        }
        
        if(us.getEmail() == null || us.getEmail().equals("") ||
                !us.getEmail().matches("([a-zA-Z_])(\\w+)(\\@)(\\w+)(\\.)(\\w+)") 
                || correos.contains(us.getEmail())) {
            throw new CorreoInvalidoException();
        }
        
        if (us.getPassword() == null || us.getPassword().length()<8) {
            throw new ContraseniaInvalidaException();
        }
    }

    @Override
    public void muestraMensajeError() {
        System.out.println("ERROR ");
    }
    
}
