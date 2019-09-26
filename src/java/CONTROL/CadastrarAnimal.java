/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DAO.CadastroDAO;
import MODEL.Cadastro;
import MODEL.Usuario;
import UTIL.criptografia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonatas Teodoro
 */
@WebServlet(name = "CadastrarAnimal", urlPatterns = {"/CadastrarAnimal"})
public class CadastrarAnimal extends HttpServlet {

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

            int status = 0;

            HttpSession sessao = request.getSession();
            Usuario autenticado = (Usuario) sessao.getAttribute("autenticado");
            if (autenticado == null) {
                status = 4;
            } else {

                criptografia crip = new criptografia();

                String proprietario = crip.hexToAscii(request.getParameter("proprietario"));
                String nomeAnimal = crip.hexToAscii(request.getParameter("nomeAnimal"));
                String tipo = crip.hexToAscii(request.getParameter("tipo"));
                int id = Integer.parseInt(request.getParameter("id"));

                Cadastro obj = new Cadastro();
                obj.setId(id);
                obj.setNomeAnimal(nomeAnimal);
                obj.setProprietario(proprietario);
                obj.setTipo(tipo);

                CadastroDAO dao;

                if (id == 0) {
                    //Novo cadastro
                    dao = new CadastroDAO();
                    if (dao.cadastrarAnimal(obj)) {
                        //Cadastrou
                        status = 0;
                    } else {
                        //Não cadastrou
                        status = 1;
                    }
                } else {
                    //Editar cadastro
                    dao = new CadastroDAO();
                    if (dao.editarAnimal(obj)) {
                        //Cadastrou
                        status = 2;
                    } else {
                        //Não cadastrou
                        status = 3;
                    }
                }
            }

            String json = "{\"status\": \"" + status + "\"}";

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
