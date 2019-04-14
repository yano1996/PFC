/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RestricaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Restricao;

/**
 *
 * @author Victor Aguiar
 */
public class ControleRestricoes extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
           String acao = request.getParameter("acao");  
            switch (acao) {
                case "Cadastrar":
                    cadastro(request, response);
                    break;                   
                case "Listar":
                    //Vitor Verificar 
                    listarRestricoes(request, response);
                    break;
                case "Deletar":
                    delete(request, response);
                    break;
                case "Alterar":
                    //Vitor Verificar Construir forme 
                    atualizaRestricao(request, response);
                    break;
                case "CadastrarVacinas":
                    boxVacinas(request, response);
                    break;
                default:
                    break;
            }
            
           
           
        } catch (Exception erro) {
            System.out.println("Erro (ControleRestricao)" + erro);
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }
    }
    
    private void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Restricao restricao = new Restricao();
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        restricao.setRestricao_nome(request.getParameter("txtNome"));
        restricao.setRestricao_tipo(request.getParameter("txtTipo"));
        restricao.setRestricao_status(true);

        restricaoDAO.cadastaNovoRestricao(restricao);

        ArrayList<Restricao> listrestricao = new ArrayList<>();
        listrestricao = restricaoDAO.consultarRestricao();
        request.setAttribute("listarestricaoz", listrestricao);
        RequestDispatcher rd = request.getRequestDispatcher("/paginas_restricoes/consultar_restricoes.jsp");
        rd.forward(request, response);
    }
            
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        restricaoDAO.deletarRestricao(Integer.parseInt(request.getParameter("id_restricao")));

        ArrayList<Restricao> listrestricaoda = new ArrayList<>();
        listrestricaoda = restricaoDAO.consultarRestricao();
        request.setAttribute("listarestricaoz", listrestricaoda);
        RequestDispatcher rdd = request.getRequestDispatcher("/paginas_restricoes/consultar_restricoes.jsp");
        rdd.forward(request, response);
    }
    
    private void boxVacinas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        ArrayList<Restricao> listrestricaoz = new ArrayList<>();
        listrestricaoz = restricaoDAO.consultarRestricao();
        request.setAttribute("listarestricao", listrestricaoz);
        RequestDispatcher rdz = request.getRequestDispatcher("/paginas_vacina/cadastrar_vacina.jsp");
        rdz.forward(request, response);
    }
    
    private void atualizaRestricao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Restricao restricao = new Restricao();
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        restricao.setRestricao_nome(request.getParameter("txtNome"));
        restricao.setRestricao_tipo(request.getParameter("txtTipo"));
        ArrayList<Restricao> listrestricaoz = new ArrayList<>();
        restricaoDAO.atualizaRestricao(restricao);
        request.setAttribute("listarestricao", listrestricaoz);
        RequestDispatcher rdz = request.getRequestDispatcher("/paginas_vacina/cadastrar_vacina.jsp");
        rdz.forward(request, response);
    }
    
    private void listarRestricoes(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        ArrayList<Restricao> listrestricaoz = new ArrayList<>();
        listrestricaoz = restricaoDAO.consultarRestricao();
        request.setAttribute("listarestricao", listrestricaoz);
        RequestDispatcher rdz = request.getRequestDispatcher("/paginas_vacina/cadastrar_vacina.jsp");
        rdz.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
