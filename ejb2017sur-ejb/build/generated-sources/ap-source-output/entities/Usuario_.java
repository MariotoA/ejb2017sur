package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile ListAttribute<Usuario, Evento> sitiosValidados;
	public static volatile ListAttribute<Usuario, Evento> eventosValidados;
	public static volatile ListAttribute<Usuario, Interes> interesesReflejados;
	public static volatile SingularAttribute<Usuario, String> provincia;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, String> rol;
	public static volatile SingularAttribute<Usuario, String> pais;
	public static volatile SingularAttribute<Usuario, Date> fechaIngreso;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> comunidadAutonoma;
	public static volatile ListAttribute<Usuario, Publicacion> publicacionesCreadas;
	public static volatile SingularAttribute<Usuario, String> ciudad;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, Boolean> recibirNotifiaciones;
	public static volatile ListAttribute<Usuario, Evento> eventosCreados;
	public static volatile ListAttribute<Usuario, Evento> sitiosCreados;
	public static volatile SingularAttribute<Usuario, String> email;

}

