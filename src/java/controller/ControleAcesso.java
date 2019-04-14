/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PerfilDeAcesso;
import model.Usuario;
import dao.UsuarioDAO;

/**
 *
 * @author nelson_amaral
 */
@WebServlet(name = "ControleAcesso", urlPatterns = {"/ControleAcesso"})
public class ControleAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String acao = request.getParameter("acao");
            switch (acao) {
                case "Acesso":
                    acesso(request, response);
                    break;
                case "Voltar":
                    voltar(request, response);
                    break;
                case "Sair":
                    sair(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception erro) {
            System.out.println("Erro (ControleAcesso): " + erro);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
        }
    }
    private void acesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setRg(request.getParameter("txtRg"));
        usuario.setSenha(request.getParameter("txtSenha"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.autenticaUsuario(usuario);
        //se o usuario existe no banco de dados.
        if (usuarioAutenticado != null) {
            //cria uma sessao para o usuario
            HttpSession sessaoUsuario = request.getSession();
            sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);

            PerfilDeAcesso nivelacesso = usuarioAutenticado.getAcesso();

            switch (nivelacesso) {
                case MEDICO:
                    //redireciona para a pagina princiapal
                    response.sendRedirect("paginas_erro/desenvolvimentoMedico.jsp");
                    break;
                case EMFERMEIRO:
                    //redireciona para a pagina princiapal
                    response.sendRedirect("paginas_erro/desenvolvimento.jsp");
                    break;
                case ADMINISTRADOR:
                    //redireciona para a pagina princiapal
                    response.sendRedirect("paginas_adm/principal.jsp");
                    break;
                case USUARIO:
                    //redireciona para a pagina princiapal
                    response.sendRedirect("paginas_paciente/principal_paciente.jsp");
                    break;
                default:
                    break;
            }

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "Rg ou Senha Incorreto!");
            rd.forward(request, response);
        }
    }
    
    private void voltar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession sessaoUsuario = request.getSession();

        sessaoUsuario.setAttribute("usuarioAutenticado", sessaoUsuario.getAttribute("usuarioAutenticado"));

        //redireciona para a pagina princiapal
        response.sendRedirect("paginas_adm/principal.jsp");
    }
    
    private void sair(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.removeAttribute("usuarioAutenticado");
        response.sendRedirect("index.jsp");
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
