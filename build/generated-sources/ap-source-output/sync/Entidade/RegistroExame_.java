package sync.Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroExame.class)
public abstract class RegistroExame_ {

	public static volatile SingularAttribute<RegistroExame, Paciente> paciente;
	public static volatile SingularAttribute<RegistroExame, TipoExame> tipo_exame;
	public static volatile SingularAttribute<RegistroExame, Integer> id;
	public static volatile SingularAttribute<RegistroExame, Funcionario> funcionario;
	public static volatile SingularAttribute<RegistroExame, Date> dt_registro;

}

