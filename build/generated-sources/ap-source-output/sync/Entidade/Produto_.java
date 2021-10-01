package sync.Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, String> marca;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Integer> id;
	public static volatile SingularAttribute<Produto, Date> validade;

}

