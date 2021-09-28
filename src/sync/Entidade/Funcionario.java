/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="dt_nascimento")//MARCACAO
    private Date dt_nascimento;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="email")
    private String email;
    
    @Column(name="formacao")
    private String formacao;
    
    @Column(name="tipo_contrato")
    private String tipo_contrato;
    
    @Column(name="salario")
    private double salario;
    
    @Column(name="endereco")
    private String endereco;

    @ManyToOne
    @JoinColumn(name="id_cidade")
    private Cidade cidade;
    
    public Funcionario()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public Date getDt_nascimento()
    {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento)
    {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getFormacao()
    {
        return formacao;
    }

    public void setFormacao(String formacao)
    {
        this.formacao = formacao;
    }

    public String getTipoContrato()
    {
        return tipo_contrato;
    }

    public void setTipoContrato(String tipo_contrato)
    {
        this.tipo_contrato = tipo_contrato;
    }

    public double getSalario()
    {
        return salario;
    }

    public void setSalario(double salario)
    {
        this.salario = salario;
    }

    public Cidade getCidade()
    {
        return cidade;
    }

    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }
}