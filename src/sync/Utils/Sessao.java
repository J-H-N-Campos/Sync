/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Utils;

import sync.Entidade.Usuario;

/**
 *
 * @author João
 */
public class Sessao
{
    private static Sessao instance = null;//PERTENCE A ESSA CLASSE
    private Usuario usuario;

    //OUTROS ATRIBUTOS
    private Sessao()
    { 
        //evita a classe ser instanciada fora dela (modificador privado)
    }
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public static synchronized Sessao getInstance()
    { 
        //synchronized para não deixar duas threads criar dua
        if (instance == null)
        {
            instance = new Sessao();
        }
        
        return instance;
    }

    public void fecharSessao()
    {
        Sessao.instance = null;
    }
}