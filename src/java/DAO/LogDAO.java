/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Log;
import UTIL.Conexao;
import java.sql.PreparedStatement;

/**
 *
 * @author Jonatas Teodoro
 */
public class LogDAO extends Conexao {

    public LogDAO() throws Exception {
    }

    public boolean cadastrarLog(Log obj) {
        boolean retorno = false;
        try {
            String sql = "insert into tb_log(usuario, data, hora) values(?, ?, ?)";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ps.setInt(1, obj.getUsuario().getId());
            ps.setDate(2, new java.sql.Date(obj.getData().getTime()));
            ps.setTime(3, obj.getHora());

            retorno = ps.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return retorno;
        }
    }
}
