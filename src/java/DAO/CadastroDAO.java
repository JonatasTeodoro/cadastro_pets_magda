/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Cadastro;
import MODEL.Raca;
import MODEL.Tipo;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jonatas Teodoro
 */
public class CadastroDAO extends Conexao {

    public CadastroDAO() throws Exception {
    }

    public boolean cadastrarAnimal(Cadastro obj) {
        boolean retorno = false;
        try {
            String sql = "insert into tb_animais(proprietario, nome_animal, id_tipo, id_raca, sexo, data_nascimento, ativo) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getProprietario());
            ps.setString(2, obj.getNomeAnimal());
            ps.setInt(3, obj.getTipo().getId());
            ps.setInt(4, obj.getRaca().getId());
            ps.setString(5, obj.getSexo());
            ps.setDate(6, new java.sql.Date(obj.getDataNascimento().getTime()));
            ps.setBoolean(7, obj.isAtivo());

            retorno = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean editarAnimal(Cadastro obj) {
        boolean retorno = false;
        try {
            String sql = "update tb_animais set proprietario=?, nome_animal=?, id_tipo=?, id_raca=?, sexo=?, data_nascimento=?, ativo=? where id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getProprietario());
            ps.setString(2, obj.getNomeAnimal());
            ps.setInt(3, obj.getTipo().getId());
            ps.setInt(4, obj.getRaca().getId());
            ps.setString(5, obj.getSexo());
            ps.setDate(6, new java.sql.Date(obj.getDataNascimento().getTime()));
            ps.setBoolean(7, obj.isAtivo());
            ps.setInt(8, obj.getId());

            retorno = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public ArrayList<Cadastro> buscarCadastros() {
        ArrayList<Cadastro> cadastros = new ArrayList<>();
        Cadastro obj;
        Tipo tipo;
        Raca raca;
        try {
            String sql = "select ani.*, tipo.id as tipo_id, tipo.descricao as tipo_descricao, raca.id as raca_id, raca.descricao as raca_descricao from tb_animais ani, tb_tipo tipo, tb_raca raca where ani.id_tipo=tipo.id and ani.id_raca=raca.id";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Cadastro();
                tipo = new Tipo();
                raca = new Raca();

                tipo.setId(rs.getInt("tipo_id"));
                tipo.setDescricao(rs.getString("tipo_descricao"));

                raca.setId(rs.getInt("raca_id"));
                raca.setDescricao(rs.getString("raca_descricao"));

                obj.setNomeAnimal(rs.getString("nome_animal"));
                obj.setProprietario(rs.getString("proprietario"));
                obj.setId(rs.getInt("id"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getDate("data_nascimento"));
                obj.setTipo(tipo);
                obj.setRaca(raca);
                obj.setAtivo(rs.getBoolean("ativo"));
                cadastros.add(obj);
            }

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return cadastros;
        }
    }

    public boolean excluirAnimal(int id) {
        boolean retorno = false;
        try {
            String sql = "delete from tb_animais where id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public Cadastro buscarCadastro(int id) {
        Cadastro obj = new Cadastro();
        Tipo tipo;
        Raca raca;
        try {
            String sql = "select ani.*, tipo.id as tipo_id, tipo.descricao as tipo_descricao, raca.id as raca_id, raca.descricao as raca_descricao from tb_animais ani, tb_tipo tipo, tb_raca raca where ani.id_tipo=tipo.id and ani.id_raca=raca.id and ani.id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Cadastro();
                tipo = new Tipo();
                raca = new Raca();

                tipo.setId(rs.getInt("tipo_id"));
                tipo.setDescricao(rs.getString("tipo_descricao"));

                raca.setId(rs.getInt("raca_id"));
                raca.setDescricao(rs.getString("raca_descricao"));

                obj.setNomeAnimal(rs.getString("nome_animal"));
                obj.setProprietario(rs.getString("proprietario"));
                obj.setId(rs.getInt("id"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getDate("data_nascimento"));
                obj.setTipo(tipo);
                obj.setRaca(raca);
                obj.setAtivo(rs.getBoolean("ativo"));
            }

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return obj;
        }
    }
}
