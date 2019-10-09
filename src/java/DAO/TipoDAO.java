/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Tipo;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jonatas Teodoro
 */
public class TipoDAO extends Conexao {

    public TipoDAO() throws Exception {
    }

    public ArrayList<Tipo> buscarTipos() {
        ArrayList<Tipo> tipos = new ArrayList<>();
        Tipo obj;
        try {
            String sql = "select * from tb_tipo";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj = new Tipo();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                tipos.add(obj);
            }

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return tipos;
        }
    }

    public boolean editarTipo(Tipo obj) {
        boolean retorno = false;
        try {
            String sql = "update tb_tipo set descricao=? where id=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, obj.getDescricao());
            ps.setInt(2, obj.getId());

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean excluirTipo(int id) {
        boolean retorno = false;
        try {
            String sql = "delete from tb_tipo where id=?";
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

    public boolean verificarForeignKey(int id) {
        boolean retorno = false;
        try {
            String sql = "select count(*) as qnt from tb_animais where id_tipo=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getInt("qnt") > 0;
            }

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }

    public boolean cadastrarTipo(String descricao) {
        boolean retorno = false;
        try {
            String sql = "insert into tb_tipo(descricao) values(?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, descricao.toUpperCase());

            retorno = ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }
}
