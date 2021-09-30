/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Entidade;

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
@Table(name="registro_exame")
public class RegistroExame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="dt_registro")
    private Date dt_registro;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_exame")
    private TipoExame tipo_exame;
    
    @ManyToOne
    @JoinColumn(name="id_funcionario")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    public int getId() {
        return id;
    }
    
    public Date getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        this.dt_registro = dt_registro;
    }

    public TipoExame getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(TipoExame tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
