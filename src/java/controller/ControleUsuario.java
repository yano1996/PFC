/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.PerfilDeAcesso;
import model.Usuario;
import dao.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author nelson_amaral
 */
@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            switch (acao) {
                case "Cadastrar": {
                    cadastro(request, response);
                    break;
                }
                case "Consultar Pacientes": {
                    consultarPacientes(request, response);
                    break;
                }
                case "Editar": {
                    editar(request, response);
                    break;
                }
                case "Comfirma": {
                    comfirma(request, response);
                    break;
                }
                case "Deletar": {
                    deletar(request, response);
                    break;
                }
                default:
                    break;
            }
        } catch (Exception erro) {
            System.out.println("Erro (ControleUsuario)" + erro);
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        }
    }

    private void cadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        System.out.println("Cadastro");
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("txtNome"));
        usuario.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
        usuario.setCpf(request.getParameter("txtCpf"));
        usuario.setRg(request.getParameter("txtRg"));
        String num = request.getParameter("txtTelefone");
        num = num.replaceAll("[^0-9]*", "");
        usuario.setTelefone(Long.parseLong(num));
        num = request.getParameter("txtCelular");
        num = num.replaceAll("[^0-9]*", "");
        usuario.setCelular(Long.parseLong(num));
        usuario.setTiposague(request.getParameter("txtTiposague"));
        usuario.setPeso(Integer.parseInt(request.getParameter("txtPeso")));
        usuario.setAltura(Integer.parseInt(request.getParameter("txtAtura")));
        usuario.setNascimento(Date.valueOf(request.getParameter("txtDate")));
        usuario.setSenha(request.getParameter("txtSenha"));
        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("administrador")) {
            usuario.setAcesso(PerfilDeAcesso.ADMINISTRADOR);
        } else if (perfil.equalsIgnoreCase("USUARIO")) {
            usuario.setAcesso(PerfilDeAcesso.USUARIO);
        }
        Endereco endereco = new Endereco();
        endereco.setLogradouro(request.getParameter("txtLog"));
        endereco.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
        endereco.setCidade(request.getParameter("txtCidade"));
        endereco.setBairro(request.getParameter("txtBairro"));
        endereco.setComplemento(request.getParameter("txtComplemento"));
        endereco.setCep(Integer.parseInt(request.getParameter("txtCep")));
        endereco.setUf(request.getParameter("txtUf"));
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.cadastaNovoEndereco(endereco);
        usuario.setEndereco(endereco);
        UsuarioDAO usuariodao = new UsuarioDAO();
        usuariodao.cadastaNovoUsuario(usuario);
        request.setAttribute("msg", "Cadastrado com Sucesso");
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = usuariodao.exibirUsuarios();
        request.setAttribute("lista", listaUsuario);
        RequestDispatcher rd = request.getRequestDispatcher("paginas_usuario/exibir_usuario.jsp");
        rd.forward(request, response);
    }

    private void consultarPacientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = usuarioDAO.exibirUsuarios();
        request.setAttribute("lista", listaUsuario);
        RequestDispatcher rd = request.getRequestDispatcher("paginas_usuario/exibir_usuario.jsp");
        rd.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuarioModelo = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioModelo = usuarioDAO.buscaUsuarioUnico(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", usuarioModelo);
        RequestDispatcher rd = request.getRequestDispatcher("paginas_usuario/atualizar_usuario.jsp");
        rd.forward(request, response);
    }

    private void comfirma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();

        usuario.setId(Integer.parseInt(request.getParameter("txtId")));
        usuario.setNome(request.getParameter("txtNome"));
        usuario.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
        usuario.setCpf(request.getParameter("txtCpf"));
        usuario.setRg(request.getParameter("txtRg"));
        usuario.setSenha(request.getParameter("txtSenha"));
        String num = request.getParameter("txtTelefone");

        num = num.replaceAll("[^0-9]*", "");

        usuario.setTelefone(Long.parseLong(num));

        num = request.getParameter("txtCelular");

        num = num.replaceAll("[^0-9]*", "");

        usuario.setCelular(Long.parseLong(num));

        usuario.setTiposague(request.getParameter("txtTiposague"));
        usuario.setPeso(Float.parseFloat(request.getParameter("txtPeso")));
        usuario.setAltura(Float.parseFloat(request.getParameter("txtAtura")));
        usuario.setNascimento(Date.valueOf(request.getParameter("txtDate")));

        String perfil = request.getParameter("optPerfil");
        if (perfil.equalsIgnoreCase("ADMINISTRADOR")) {
            usuario.setAcesso(PerfilDeAcesso.ADMINISTRADOR);
        } else if (perfil.equalsIgnoreCase("USUARIO")) {
            usuario.setAcesso(PerfilDeAcesso.USUARIO);
        }
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizar_usuario(usuario);
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = usuarioDAO.exibirUsuarios();
        request.setAttribute("lista", listaUsuario);
        RequestDispatcher rd = request.getRequestDispatcher("/paginas_usuario/exibir_usuario.jsp");
        rd.forward(request, response);
    }

    private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(request.getParameter("id")));
        usuarioDAO.excluirUsuario(usuario.getId());
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        listaUsuario = usuarioDAO.exibirUsuarios();
        request.setAttribute("lista", listaUsuario);
        RequestDispatcher rd = request.getRequestDispatcher("/paginas_usuario/exibir_usuario.jsp");
        rd.forward(request, response);
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
