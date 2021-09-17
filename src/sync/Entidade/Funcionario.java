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
    private String dt_nascimento;
    
    @Column(name="cpf_cnpj")
    private String cpf;
    
    @Column(name="rg")
    private String rg;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="telefone_opcional")
    private String telefone_opc;
    
    @Column(name="email_pessoal")
    private String email_pessoal;
    
    @Column(name="email_empresa")
    private String email_empresa;
    
    @Column(name="rua")
    private String rua;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="complemento")
    private String complemento;
    
    @Column(name="formacao")
    private String formacao;
    
    @Column(name="tipo_contrato")
    private String tipo_contrato;
    
    @Column(name="salario_atual")
    private double salario_atual;
    
    @Column(name="salario_futuro")
    private double salario_futuro;
    
    @ManyToOne
    @JoinColumn(name="id_cidade")
    private Cidade cidade;
    
    
    public Funcionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone_opc() {
        return telefone_opc;
    }

    public void setTelefone_opc(String telefone_opc) {
        this.telefone_opc = telefone_opc;
    }

    public String getEmail_pessoal() {
        return email_pessoal;
    }

    public void setEmail_pessoal(String email_pessoal) {
        this.email_pessoal = email_pessoal;
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public double getSalario_atual() {
        return salario_atual;
    }

    public void setSalario_atual(double salario_atual) {
        this.salario_atual = salario_atual;
    }

    public double getSalario_futuro() {
        return salario_futuro;
    }

    public void setSalario_futuro(double salario_futuro) {
        this.salario_futuro = salario_futuro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
