package sync.Entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroLotacao.class)
public abstract class RegistroLotacao_ {

	public static volatile SingularAttribute<RegistroLotacao, Boolean> ativo;
	public static volatile SingularAttribute<RegistroLotacao, Paciente> paciente;
	public static volatile SingularAttribute<RegistroLotacao, Leito> leito;
	public static volatile SingularAttribute<RegistroLotacao, Integer> id;
	public static volatile SingularAttribute<RegistroLotacao, Funcionario> funcionario;

}

