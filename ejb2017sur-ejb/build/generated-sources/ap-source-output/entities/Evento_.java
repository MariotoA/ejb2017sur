package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evento.class)
public abstract class Evento_ {

	public static volatile SingularAttribute<Evento, String> descripcion;
	public static volatile ListAttribute<Evento, Sesion> sesionesCelebradas;
	public static volatile SingularAttribute<Evento, String> video;
	public static volatile ListAttribute<Evento, Interes> interesesSobreElEvento;
	public static volatile SingularAttribute<Evento, String> nombre;
	public static volatile SingularAttribute<Evento, Integer> prioridad;
	public static volatile SingularAttribute<Evento, Usuario> creador;
	public static volatile ListAttribute<Evento, Publicacion> publicaciones;
	public static volatile SingularAttribute<Evento, String> foto;
	public static volatile SingularAttribute<Evento, Sitio> localizacion;
	public static volatile SingularAttribute<Evento, Long> id;
	public static volatile SingularAttribute<Evento, String> tag;
	public static volatile SingularAttribute<Evento, Usuario> validador;

}

