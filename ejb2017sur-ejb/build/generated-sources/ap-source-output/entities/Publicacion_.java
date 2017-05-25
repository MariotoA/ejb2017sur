package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Publicacion.class)
public abstract class Publicacion_ {

	public static volatile SingularAttribute<Publicacion, String> texto;
	public static volatile SingularAttribute<Publicacion, String> multimedia;
	public static volatile SingularAttribute<Publicacion, Usuario> creador;
	public static volatile SingularAttribute<Publicacion, Evento> eventoReferido;
	public static volatile SingularAttribute<Publicacion, Sitio> sitioReferido;
	public static volatile SingularAttribute<Publicacion, String> titulo;
	public static volatile SingularAttribute<Publicacion, Integer> valoracion;
	public static volatile SingularAttribute<Publicacion, Long> id;

}

