/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Usuario;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jonatas Teodoro
 */
public class UsuarioDAO extends Conexao {

    public UsuarioDAO() throws Exception {
    }

    public boolean verificarUsuario(String usuario, String senha) {
        boolean retorno = false;
        try {
            String sql = "select count(*) as qnt from tb_usuario where usuario=? and senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, senha);

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
    
    public Usuario buscarUsuario(String usuario, String senha) {
        Usuario obj = new Usuario();
        try {
            String sql = "select * from tb_usuario where usuario=? and senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setNome(rs.getString("nome"));
                obj.setId(rs.getInt("id"));
            }
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return obj;
        }
    }
}
