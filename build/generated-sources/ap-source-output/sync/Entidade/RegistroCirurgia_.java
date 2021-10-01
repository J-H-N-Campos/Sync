package sync.Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistroCirurgia.class)
public abstract class RegistroCirurgia_ {

	public static volatile SingularAttribute<RegistroCirurgia, Paciente> paciente;
	public static volatile SingularAttribute<RegistroCirurgia, TipoExame> tipo_exame;
	public static volatile SingularAttribute<RegistroCirurgia, Integer> id;
	public static volatile SingularAttribute<RegistroCirurgia, Funcionario> funcionario;
	public static volatile SingularAttribute<RegistroCirurgia, Date> dt_registro;

}

