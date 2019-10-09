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
public class TipoDAO extends Conexao{
    public TipoDAO()throws Exception{}
    
    public ArrayList<Tipo> buscarTipos() {
        ArrayList<Tipo> tipos = new ArrayList<>();
        Tipo obj;
        try {
            String sql = "select * from tb_tipo";
            PreparedStatement ps = getConexao().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
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
}
