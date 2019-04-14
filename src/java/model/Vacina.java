/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelson_amaral
 */
public class Vacina {
    private int id_vacina;
    private String nome;
    private int dose;       //quantidade de dosses dentro da caderneta 
    private int intervalo;  //quantidade de dias entre as dosses 
    private boolean status;
    private ArrayList<Restricao> restricoes;
    private TipoVacina tipo;

    public Vacina(String nome, int dose, int intervalo, TipoVacina tipo) {
        this.nome = nome;
        this.dose = dose;
        this.intervalo = intervalo;
        this.tipo = tipo;
    }

    public Vacina() {
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
    
    public int getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(int id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoVacina getTipo() {
        return tipo;
    }

    public void setTipo(TipoVacina tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Restricao> getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(ArrayList<Restricao> restricoes) {
        this.restricoes = restricoes;
    }

    
    
    
}
