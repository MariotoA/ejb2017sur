package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sesion.class)
public abstract class Sesion_ {

	public static volatile SingularAttribute<Sesion, String> urlCompraEntrada;
	public static volatile SingularAttribute<Sesion, Double> precio;
	public static volatile SingularAttribute<Sesion, Date> fechaInicio;
	public static volatile SingularAttribute<Sesion, Long> id;
	public static volatile SingularAttribute<Sesion, Evento> eventoCelebrado;
	public static volatile SingularAttribute<Sesion, Date> fechaFin;

}

