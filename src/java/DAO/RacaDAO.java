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
    
    public ArrayList<Raca> buscarTipos() {
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
}
