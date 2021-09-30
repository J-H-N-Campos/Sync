/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Entidade;

import java.io.Serializable;
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
    private String dt_nascimento;
    
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
    
    
}   


