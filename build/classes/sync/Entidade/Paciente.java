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
@Table(name="paciente")
public class Paciente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "dt_nascimento")
    private Date dt_nascimento;
    
    @Column(name = "cpf") //talvez alterar
    private String cpf;
    
    @Column(name = "sexo")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name="id_convenio")
    private Convenio convenio;
    
    /*public Paciente(int id, String nome, Date dt_nascimento, String sexo, Cidade cidade, String endereco, String telefone ,String email, Convenio convenio)
    {
        this.id = id;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.sexo = sexo;
        this.cidade = cidade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.convenio = convenio;
    }*/

    public Paciente()
    {
        
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public Date getDtNascimento()
    {
        return dt_nascimento;
    }

    public void setDtNascimento(Date dt_nascimento)
    {
        this.dt_nascimento = dt_nascimento;
    }
    
    public String getCPF()
    {
        return cpf;
    }

    public void setCPF(String cpf)
    {
        this.cpf = cpf;
    }
    
    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
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
    
    public Cidade getCidade()
    {
        return cidade;
    }

    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }
    
    public Convenio getConvenio()
    {
        return convenio;
    }

    public void setConvenio(Convenio convenio)
    {
        this.convenio = convenio;
    }
    
    public String toString()
    {
        return this.nome;
    }
}