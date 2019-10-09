/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Raca;
import UTIL.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jonatas Teodoro
 */
public class RacaDAO extends Conexao{
    public RacaDAO()throws Exception{}
    
    public ArrayList<Raca> buscarRacas() {
        ArrayList<Raca> racas = new ArrayList<>();
        Raca obj;
        try {
            String sql = "select * from tb_raca";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                obj = new Raca();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                racas.add(obj);
            }
            
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        } finally {
            fechaConexao();
            return racas;
        }
    }
    
    public boolean verificarForeignKey(int id) {
        boolean retorno = false;
        try {
            String sql = "select count(*) as qnt from tb_animais where id_raca=?";
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
    
    public boolean excluirRaca(int id) {
        boolean retorno = false;
        try {
            String sql = "delete from tb_raca where id=?";
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
    
    public boolean editarRaca(Raca obj) {
        boolean retorno = false;
        try {
            String sql = "update tb_raca set descricao=? where id=?";
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
    
    public boolean cadastrarRaca(String descricao) {
        boolean retorno = false;
        try {
            String sql = "insert into tb_raca(descricao) values(?)";
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
