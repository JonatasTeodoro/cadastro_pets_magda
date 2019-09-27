/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Jonatas Teodoro
 */
public class Log {

    private int id;
    private Usuario usuario;
    private Date data;
    private Time hora;

    public Log(int id, Usuario usuario, Date data, Time hora) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
    }

    public Log() {
        id = 0;
        usuario = new Usuario();
        data = new Date();
        hora = new Time(new Date().getTime());
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
