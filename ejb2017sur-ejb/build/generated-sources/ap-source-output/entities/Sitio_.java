package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sitio.class)
public abstract class Sitio_ {

	public static volatile SingularAttribute<Sitio, String> descripcion;
	public static volatile SingularAttribute<Sitio, String> direccion;
	public static volatile SingularAttribute<Sitio, String> provincia;
	public static volatile ListAttribute<Sitio, Evento> eventosCelebrados;
	public static volatile SingularAttribute<Sitio, String> nombre;
	public static volatile SingularAttribute<Sitio, String> url;
	public static volatile SingularAttribute<Sitio, String> pais;
	public static volatile SingularAttribute<Sitio, Usuario> creador;
	public static volatile ListAttribute<Sitio, Publicacion> publicaciones;
	public static volatile SingularAttribute<Sitio, String> comunidadAutonoma;
	public static volatile SingularAttribute<Sitio, String> foto;
	public static volatile SingularAttribute<Sitio, String> ciudad;
	public static volatile SingularAttribute<Sitio, Long> id;
	public static volatile SingularAttribute<Sitio, Usuario> validador;

}

