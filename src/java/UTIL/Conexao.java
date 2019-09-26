/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatas Teodoro
 */
public class Conexao {

    private Connection Conexao;

    public Conexao() {
        try {


            String url = "jdbc:postgresql://190.0.0.205:5432/CADPETPREFEITURA";
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            Conexao = DriverManager.
                    getConnection(url, "postgres", "#Batec2807$");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao banco de dados\nVerificar configurações!", "Erro de conexão", 2);
        }

    }

    public Connection getConexao() {
        return Conexao;
    }

    public void fechaConexao() {
        try {
            Conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
