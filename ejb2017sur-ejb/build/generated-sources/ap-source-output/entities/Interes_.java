package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Interes.class)
public abstract class Interes_ {

	public static volatile SingularAttribute<Interes, Usuario> interesado;
	public static volatile SingularAttribute<Interes, Boolean> acudir;
	public static volatile SingularAttribute<Interes, Boolean> meGusta;
	public static volatile SingularAttribute<Interes, Long> id;
	public static volatile SingularAttribute<Interes, Boolean> noMeGusta;
	public static volatile SingularAttribute<Interes, Sesion> sesionReferida;

}

