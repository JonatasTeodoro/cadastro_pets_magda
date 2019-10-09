/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DAO.CadastroDAO;
import MODEL.Cadastro;
import batec.util.ConverterData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Jonatas Teodoro
 */
@WebServlet(name = "BuscarTabela", urlPatterns = {"/BuscarTabela"})
public class BuscarTabela extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            ConverterData conv = new ConverterData();

            CadastroDAO dao;
            dao = new CadastroDAO();

            ArrayList<Cadastro> cadastros = dao.buscarCadastros();

            String json = "[";

            for (int i = 0; i < cadastros.size(); i++) {
                if (i == (cadastros.size() - 1)) {
                    json = json + "{\"botao\":\"<a href='javascript:editarAnimal(" + cadastros.get(i).getId() + ", \\\"" + cadastros.get(i).getNomeAnimal() + "\\\")' class='btn btn-warning btn-circle'><i class='fas fa-exclamation-triangle'></i></a><a style='margin-left: 3px' href='javascript:excluirAnimal(" + cadastros.get(i).getId() + ", \\\"" + cadastros.get(i).getNomeAnimal() + "\\\")' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a>\",\"proprietario\":\"" + cadastros.get(i).getProprietario() + "\", \"nomeanimal\":\"" + cadastros.get(i).getNomeAnimal() + "\", \"tipo\":\"" + cadastros.get(i).getTipo().getDescricao() + "\", \"id\":\"" + cadastros.get(i).getId() + "\", \"sexo\":\""+cadastros.get(i).getSexo()+"\", \"raca\":\""+cadastros.get(i).getRaca().getDescricao()+"\", \"nascimento\":\""+conv.dateToString(cadastros.get(i).getDataNascimento())+"\", \"status\":\""+cadastros.get(i).isAtivo()+"\"}";
                } else {
                    json = json + "{\"botao\":\"<a href='javascript:editarAnimal(" + cadastros.get(i).getId() + ", \\\"" + cadastros.get(i).getNomeAnimal() + "\\\")' class='btn btn-warning btn-circle'><i class='fas fa-exclamation-triangle'></i></a><a style='margin-left: 3px' href='javascript:excluirAnimal(" + cadastros.get(i).getId() + ", \\\"" + cadastros.get(i).getNomeAnimal() + "\\\")' class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a>\",\"proprietario\":\"" + cadastros.get(i).getProprietario() + "\", \"nomeanimal\":\"" + cadastros.get(i).getNomeAnimal() + "\", \"tipo\":\"" + cadastros.get(i).getTipo().getDescricao() + "\", \"id\":\"" + cadastros.get(i).getId() + "\", \"sexo\":\""+cadastros.get(i).getSexo()+"\", \"raca\":\""+cadastros.get(i).getRaca().getDescricao()+"\", \"nascimento\":\""+conv.dateToString(cadastros.get(i).getDataNascimento())+"\", \"status\":\""+cadastros.get(i).isAtivo()+"\"},";
                }
            }

            json = json + "]";

//            Status
//            0 = cadastrado com sucesso
//            1 = erro ao cadastrar
//            2 = editado com sucesso
//            3 = erro ao editar    
            HttpServletResponse f = new HttpServletResponseWrapper(response);
            f.getWriter().print(json);
        } catch (Exception ex) {
            System.out.println("!Erro: " + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
