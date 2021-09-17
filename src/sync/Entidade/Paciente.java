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
    
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "cpf_cnpj") //talvez alterar
    private String cpf;
    
    @Column(name = "sexo")
    private String sexo;
    
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
    
    @Column(name = "rua")
    private String rua;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "telefone_opcional")
    private String telefone_opcional;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "email_opcional")
    private String email_opcional;
    
    @Column(name = "cidade_migracao") //?????????
    private String cidade_migracao;
    
    @Column(name = "vagas")//altearar no banco
    private Integer vagas;
    
    @ManyToOne
    @JoinColumn(name="id_convenio")
    private Convenio convenio;
    
    
}   


