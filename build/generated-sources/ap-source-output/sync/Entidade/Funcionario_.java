package sync.Entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile SingularAttribute<Funcionario, String> telefone;
	public static volatile SingularAttribute<Funcionario, Cidade> cidade;
	public static volatile SingularAttribute<Funcionario, String> endereco;
	public static volatile ListAttribute<Funcionario, Funcao> funcoes;
	public static volatile SingularAttribute<Funcionario, Double> salario;
	public static volatile SingularAttribute<Funcionario, String> nome;
	public static volatile SingularAttribute<Funcionario, Date> dt_nascimento;
	public static volatile SingularAttribute<Funcionario, String> formacao;
	public static volatile SingularAttribute<Funcionario, String> cpf;
	public static volatile SingularAttribute<Funcionario, Integer> id;
	public static volatile SingularAttribute<Funcionario, String> tipo_contrato;
	public static volatile SingularAttribute<Funcionario, String> sexo;
	public static volatile SingularAttribute<Funcionario, String> email;

}

