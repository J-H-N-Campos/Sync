/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name="funcao")
class Funcao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="especializacao")
    private String especializacao;
    
    @Column(name="nivel_permicao")
    private int nivel_permicao;
    
    @ManyToMany(mappedBy="funcoes")
    private List<Funcionario> funcionarios;

    public int getId() {
        return id;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getNivel_permicao() {
        return nivel_permicao;
    }

    public void setNivel_permicao(int nivel_permicao) {
        this.nivel_permicao = nivel_permicao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
}
