/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;
import util.ConectaBanco;

/**
 *
 * @author nelson_amaral
 */
public class EnderecoDAO {

    private final String ENDERECO_NOVO_USUARIO = "INSERT INTO endereco (endereco_logradouro, endereco_numero, endereco_cidade, endereco_bairro, endereco_complemento, endereco_cep, endereco_uf, endereco_status)VALUES(?,?,?,?,?,?,?,?) RETURNING endereco_id";

    public Endereco cadastaNovoEndereco(Endereco endereco) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(ENDERECO_NOVO_USUARIO);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt   (2, endereco.getNumero());
            pstmt.setString(3, endereco.getCidade());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getComplemento());
            pstmt.setInt(6, endereco.getCep());
            pstmt.setString(7, endereco.getUf());
            pstmt.setBoolean(8,endereco.isStatus());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                endereco.setId_endereco(rs.getInt("endereco_id"));
            }
            return endereco;
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
