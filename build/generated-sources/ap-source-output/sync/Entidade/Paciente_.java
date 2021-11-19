package sync.Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, Cidade> cidade;
	public static volatile SingularAttribute<Paciente, String> telefone;
	public static volatile SingularAttribute<Paciente, String> endereco;
	public static volatile SingularAttribute<Paciente, String> cpf;
	public static volatile SingularAttribute<Paciente, Convenio> convenio;
	public static volatile SingularAttribute<Paciente, String> nome;
	public static volatile SingularAttribute<Paciente, Integer> id;
	public static volatile SingularAttribute<Paciente, String> sexo;
	public static volatile SingularAttribute<Paciente, Date> dt_nascimento;
	public static volatile SingularAttribute<Paciente, String> email;

}

