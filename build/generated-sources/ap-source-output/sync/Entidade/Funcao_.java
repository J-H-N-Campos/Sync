package sync.Entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcao.class)
public abstract class Funcao_ {

	public static volatile SingularAttribute<Funcao, Integer> nivel_permissao;
	public static volatile SingularAttribute<Funcao, String> especializacao;
	public static volatile SingularAttribute<Funcao, Integer> id;
	public static volatile ListAttribute<Funcao, Funcionario> funcionarios;

}

