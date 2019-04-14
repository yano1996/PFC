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
import java.util.ArrayList;
import model.Calendario;
import model.StatusVacinaCalendario;
import util.ConectaBanco;

/**
 *
 * @author nelson_amaral
 */
public class CalendarioDAO {

    private final String CADASTRO_CALENDARIO = "INSERT INTO public.calendario(calendario_dataprevista, calendario_idvacina, calendario_statusvacinacalendario) VALUES ( ?, ?, ?, ?);";
    private final String EXIBIR_LISTA_CALENDARIO = "SELECT * FROM calendario WHERE calendario_statusvacinacalendario != 'MEDICAMENTO_DELETADO'";
    private final String ATUALIZAR_CALENDARIO = "UPDATE public.calendario SET calendario_dataprevista=?, calendario_idvacina=?, calendario_statusvacinacalendario=? WHERE calendario_id=? ;";
    private final String DELETAR_CALENDARIO = "UPDATE public.calendario SET calendario_statusvacinacalendario='MEDICAMENTO_DELETADO' WHERE calendario_id=? ;";
    
    public void cadastrarCalendario(ArrayList<Calendario> listacalendario) {
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            for (int i = 0; i < listacalendario.size(); i++) {
                conexao = ConectaBanco.getConexao();
                pstmt = conexao.prepareStatement(CADASTRO_CALENDARIO);
                pstmt.setDate(0, listacalendario.get(i).getDataPrevista());
                pstmt.setInt(1, listacalendario.get(i).getVacina().getId_vacina());
                pstmt.setString(2, listacalendario.get(i).getStatus().toString());
                pstmt.execute();
            }
        } catch (SQLException erro) {
            System.out.println("Erro SQL(CalendarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(CalendarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }

    }
    public ArrayList<Calendario> exibirVacinaCalendario(){
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         try {
                
                conexao = ConectaBanco.getConexao();
                pstmt = conexao.prepareStatement(EXIBIR_LISTA_CALENDARIO);
                rs = pstmt.executeQuery();
                ArrayList<Calendario> listaCalendario = new ArrayList<>();
                
                while(rs.next()){
                        Calendario calendario = new Calendario();
                        calendario.setId(rs.getInt("calendario_id"));
                        calendario.setDataPrevista(rs.getDate("calendario_dataprevista"));
                        calendario.setDataDeinsercaoDoMedicamento(rs.getDate("calendario_datadeinsercaodomedicamento"));
                        
                        //Passando apenas o ID e Não A classe Vacina Arrumar 
                        calendario.getVacina().setId_vacina(rs.getInt("calendario_idvacina"));
                        calendario.setComentarioEventos(rs.getString("calendario_comentarioeventos"));
                        calendario.setStatus(StatusVacinaCalendario.valueOf(rs.getString("calendario_statusvacinacalendario")));
                        
                        listaCalendario.add(calendario);
                        
                        
                }
                
                return listaCalendario;
                
        } catch (SQLException erro) {
            System.out.println("Erro SQL(CalendarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(CalendarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
         
    }
    public void alterarVacinaCalendario(ArrayList<Calendario> listacalendario){
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            for (int i = 0; i < listacalendario.size(); i++) {
                conexao = ConectaBanco.getConexao();
                pstmt = conexao.prepareStatement(ATUALIZAR_CALENDARIO);
                pstmt.setDate(0, listacalendario.get(i).getDataPrevista());
                pstmt.setInt(1, listacalendario.get(i).getVacina().getId_vacina());
                pstmt.setString(2, listacalendario.get(i).getStatus().toString());
                pstmt.setInt(3, listacalendario.get(i).getId());
                pstmt.execute();
            }
        } catch (SQLException erro) {
            System.out.println("Erro SQL(CalendarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(CalendarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
    
    }
    public void DeletarVacinaCalendario(ArrayList<Calendario> listacalendario){
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            for (int i = 0; i < listacalendario.size(); i++) {
                conexao = ConectaBanco.getConexao();
                pstmt = conexao.prepareStatement(DELETAR_CALENDARIO);
                pstmt.setInt(0, listacalendario.get(i).getId());
                pstmt.execute();
            }
        } catch (SQLException erro) {
            System.out.println("Erro SQL(CalendarioDAO)" + erro);
            throw new RuntimeException(erro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException erroSQL) {
                    System.out.println("Erro SQL(CalendarioDAO)" + erroSQL);
                    throw new RuntimeException(erroSQL);
                }
            }
        }
    
    }
}
