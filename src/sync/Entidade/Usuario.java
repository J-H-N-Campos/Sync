/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Entidade;

import sync.Utils.GenericUser;
import java.util.List;
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
 * @author João
 */
@Entity
@Table(name = "usuario")
public class Usuario implements GenericUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Usuario(String nome, String senha, Funcionario funcionario)
    {
        this.nome = nome;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public Usuario() 
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

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }


    public Funcionario getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario)
    {
        this.funcionario = funcionario;
    }
    @Override
    public String toString()
    {
        return this.nome;
    }

    @Override
    public String getLogin() {
        return this.nome;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }
    
    @Override
    public int getNivelAcesso(){
        List<Funcao> lista = this.funcionario.getFuncoes();
        int nivel = 0;
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNivel_permicao()>nivel) {
                nivel = lista.get(i).getNivel_permicao();
            }
        }
                
        return nivel;
    }
}