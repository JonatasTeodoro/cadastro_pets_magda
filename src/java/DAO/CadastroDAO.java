/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Cadastro;
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
            String sql = "insert into tb_animais(proprietario, nome_animal, tipo) values(?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getProprietario());
            ps.setString(2, obj.getNomeAnimal());
            ps.setString(3, obj.getTipo());

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
            String sql = "update tb_animais set proprietario=?, nome_animal=?, tipo=? where id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getProprietario());
            ps.setString(2, obj.getNomeAnimal());
            ps.setString(3, obj.getTipo());
            ps.setInt(4, obj.getId());

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
        try {
            String sql = "select * from tb_animais";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Cadastro();
                obj.setNomeAnimal(rs.getString("nome_animal"));
                obj.setProprietario(rs.getString("proprietario"));
                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo"));
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
        try {
            String sql = "select * from tb_animais where id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Cadastro();
                obj.setNomeAnimal(rs.getString("nome_animal"));
                obj.setProprietario(rs.getString("proprietario"));
                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo"));
            }

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return obj;
        }
    }
}
