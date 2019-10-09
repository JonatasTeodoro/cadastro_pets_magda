/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author Jonatas Teodoro
 */
public class Cadastro {

    private int id;
    private String proprietario;
    private String nomeAnimal;
    private String sexo;
    private Raca raca;
    private Tipo tipo;
    private Date dataNascimento;
    private boolean ativo;

    

    public Cadastro(int id, String proprietario, String nomeAnimal, String sexo, Raca raca, Tipo tipo, Date dataNascimento, boolean ativo) {
        this.id = id;
        this.proprietario = proprietario;
        this.nomeAnimal = nomeAnimal;
        this.sexo = sexo;
        this.raca = raca;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public Cadastro() {
        id = 0;
        proprietario = new String();
        nomeAnimal = new String();
        sexo = new String();
        raca = new Raca();
        tipo = new Tipo();
        dataNascimento = new Date();
        ativo=false;
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
     * @return the proprietario
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the nomeAnimal
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    /**
     * @param nomeAnimal the nomeAnimal to set
     */
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the raca
     */
    public Raca getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
