/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editsor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PerfilDeAcesso;
import model.Usuario;
import util.ConectaBanco;

/**
 *
 * @author nelson_amaral
 */
public class UsuarioDAO {

    private final String CADASTRA_NOVO_USUARIO = "INSERT INTO usuario (usuario_nome, usuario_idade, usuario_cpf, usuario_rg, usuario_senha, usuario_telefone, usuario_celular, usuario_tiposague, usuario_peso, usuario_altura, usuario_nascimento, usuario_acesso, usuario_status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING usuario_id";
    private final String AUTENTICA_USUARIO = "SELECT * FROM usuario WHERE usuario_rg = ? AND usuario_senha = ? ";
    private final String CADASTRA_ENDERECO_HAS_USUARIO = "INSERT INTO endereco_has_usuario (endereco_id, usuario_id)VALUES(?,?)";
    private final String BUSCAR_USUARIO = "SELECT * FROM usuario WHERE usuario_status != false";
    private final String BUSCAR_DE_ACORDO_ACESSO = "SELECT * FROM usuario WHERE usuario_acesso=? AND usuario_status != false ORDER BY usuario_id";
    private final String DELETA_USUARIO = "UPDATE usuario SET usuario_status = false WHERE usuario_id = ? RETURNING usuario_status";
    private final String UPDATE_USUARIO = "UPDATE usuario SET usuario_nome = ?, usuario_idade = ?, usuario_cpf = ?, usuario_rg = ?, usuario_senha = ?, usuario_telefone = ?, usuario_celular = ?, usuario_tiposague = ?, usuario_peso = ?, usuario_altura = ?, usuario_nascimento = ?, usuario_acesso = ? WHERE usuario_id = ?";
    private final String BUSCAR_USUARIO_UNICO = "SELECT * FROM usuario WHERE usuario_id=?";
    
    
    //Valida senha com uma quere 
    
    public void cadastaNovoUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CADASTRA_NOVO_USUARIO);
            pstmt.setString(1, usuario.getNome());
            pstmt.setInt(2, usuario.getIdade());
            pstmt.setString(3, usuario.getCpf());
            pstmt.setString(4, usuario.getRg());
            pstmt.setString(5, usuario.getSenha());
            pstmt.setLong(6, usuario.getTelefone());
            pstmt.setLong(7, usuario.getCelular());
            pstmt.setString(8, usuario.getTiposague());
            pstmt.setFloat(9, usuario.getPeso());
            pstmt.setFloat(10, usuario.getAltura());
            pstmt.setDate(11, usuario.getNascimento());
            pstmt.setString(12, usuario.getAcesso().toString());
            pstmt.setBoolean(13, true);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("usuario_id"));
            }

        } catch (SQLException erro) {
            System.out.println("Erro SQL(UsuarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
//        try {
//
//            
//            conexao = ConectaBanco.getConexao();
//            pstmt = conexao.prepareStatement(CADASTRA_ENDERECO_HAS_USUARIO);
//            pstmt.setInt(1, usuario.getEndereco().getId_endereco());
//            pstmt.setInt(2, usuario.getId());
//            pstmt.execute();
//
//        } catch (SQLException erro) {
//            System.out.println("Erro SQL(UsuarioDAO)" + erro);
//            throw new RuntimeException(erro);
//        } finally {
//            if (conexao != null) {
//                try {
//                    conexao.close();
//                } catch (SQLException erroSQL) {
//                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
//                    throw new RuntimeException(erroSQL);
//                }
//            }
//        }
    }

    public Usuario autenticaUsuario(Usuario usuario) {
        Usuario usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICA_USUARIO);
            pstmt.setString(1, usuario.getRg());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();
           while (rsUsuario.next()) {
               if(usuario.getRg().equals(rsUsuario.getString("usuario_rg")) && usuario.getSenha().equals(rsUsuario.getString("usuario_senha"))){
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setId(rsUsuario.getInt("usuario_id"));
                usuarioAutenticado.setNome(rsUsuario.getString("usuario_nome"));
                usuarioAutenticado.setAcesso(PerfilDeAcesso.valueOf(rsUsuario.getString("usuario_acesso")));
                usuarioAutenticado.setSenha(rsUsuario.getString("usuario_senha"));
               }}
        } catch (SQLException errosql) {
            System.out.println("Erro SQL(UsuarioDAO)" + errosql);
            throw new RuntimeException(errosql);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException errosql) {
                    System.out.println("Erro SQL(UsuarioDAO)" + errosql);
                    throw new RuntimeException(errosql);
                }
            }
        }
        return usuarioAutenticado;
    }

    public ArrayList<Usuario> exibirUsuarios() {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(BUSCAR_DE_ACORDO_ACESSO);
            ArrayList<Usuario> listaUsuario = new ArrayList<>();
            pstmt.setString(1, "USUARIO");
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("usuario_id"));
                usuario.setNome(rs.getString("usuario_nome"));
                usuario.setIdade(rs.getInt("usuario_idade"));
                usuario.setCpf(rs.getString("usuario_cpf"));
                usuario.setRg(rs.getString("usuario_rg"));
                usuario.setTelefone(rs.getInt("usuario_telefone"));
                usuario.setCelular(rs.getLong("usuario_celular"));
                usuario.setTiposague(rs.getString("usuario_tiposague"));
                usuario.setPeso(rs.getInt("usuario_peso"));
                usuario.setAltura(rs.getInt("usuario_altura"));
                usuario.setNascimento(rs.getDate("usuario_nascimento"));
                usuario.setAcesso(PerfilDeAcesso.valueOf(rs.getString("usuario_acesso")));
                usuario.setStatus(rs.getBoolean("usuario_status"));
                if (usuario.isStatus() == true) {
                    listaUsuario.add(usuario);
                }
            }
            return listaUsuario;
        } catch (SQLException erro) {
            System.out.println("Erro SQL(UsuarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }

    }
    
   
    public boolean excluirUsuario(int id) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(DELETA_USUARIO);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                status = rs.getBoolean("usuario_status");
            }

            return status;
        } catch (SQLException erro) {
            System.out.println("Erro SQL(UsuarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
    }

    public void atualizar_usuario(Usuario usuario) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(UPDATE_USUARIO);
            pstmt.setString(1, usuario.getNome());
            pstmt.setInt(2, usuario.getIdade());
            pstmt.setString(3, usuario.getCpf());
            pstmt.setString(4, usuario.getRg());
            pstmt.setString(5, usuario.getSenha());
            pstmt.setLong(6, usuario.getTelefone());
            pstmt.setLong(7, usuario.getCelular());
            pstmt.setString(8, usuario.getTiposague());
            pstmt.setFloat(9, usuario.getPeso());
            pstmt.setFloat(10, usuario.getAltura());
            pstmt.setDate(11, usuario.getNascimento());
            pstmt.setString(12, usuario.getAcesso().toString());
            pstmt.setInt(13, usuario.getId());
            pstmt.execute();
            
            

        } catch (SQLException erro) {
            System.out.println("Erro SQL(UsuarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
    }

    public Usuario buscaUsuarioUnico(int id) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(BUSCAR_USUARIO_UNICO);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {        
                    usuario.setId(rs.getInt("usuario_id"));
                    usuario.setNome(rs.getString("usuario_nome"));
                    usuario.setIdade(rs.getInt("usuario_idade"));
                    usuario.setCpf(rs.getString("usuario_cpf"));
                    usuario.setRg(rs.getString("usuario_rg"));
                    usuario.setSenha(rs.getString("usuario_senha"));
                    usuario.setTelefone(rs.getInt("usuario_telefone"));
                    usuario.setCelular(rs.getLong("usuario_celular"));
                    usuario.setTiposague(rs.getString("usuario_tiposague"));
                    usuario.setPeso(rs.getInt("usuario_peso"));
                    usuario.setAltura(rs.getInt("usuario_altura"));
                    usuario.setNascimento(rs.getDate("usuario_nascimento"));
                    usuario.setAcesso(PerfilDeAcesso.valueOf(rs.getString("usuario_acesso")));
                    usuario.setStatus(rs.getBoolean("usuario_status"));                           
            }
            return usuario;

        } catch (SQLException erro) {
            System.out.println("Erro SQL(UsuarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(UsuarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
    }

}
