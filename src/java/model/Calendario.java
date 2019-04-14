/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author nelson_amaral
 */
public class Calendario {
    private int id;
    private Date dataPrevista;
    private Date dataDeinsercaoDoMedicamento;
    private Vacina vacina;
    private String ComentarioEventos;
    private StatusVacinaCalendario status;

    public Calendario() {
    }

    public Calendario(Date dataPrevista, Date dataDeinsercaoDoMedicamento, Vacina vacina, String ComentarioEventos, int id, StatusVacinaCalendario status) {
        this.dataPrevista = dataPrevista;
        this.dataDeinsercaoDoMedicamento = dataDeinsercaoDoMedicamento;
        this.vacina = vacina;
        this.ComentarioEventos = ComentarioEventos;
        this.id = id;
        this.status = status;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataDeinsercaoDoMedicamento() {
        return dataDeinsercaoDoMedicamento;
    }

    public void setDataDeinsercaoDoMedicamento(Date dataDeinsercaoDoMedicamento) {
        this.dataDeinsercaoDoMedicamento = dataDeinsercaoDoMedicamento;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String getComentarioEventos() {
        return ComentarioEventos;
    }

    public void setComentarioEventos(String ComentarioEventos) {
        this.ComentarioEventos = ComentarioEventos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusVacinaCalendario getStatus() {
        return status;
    }

    public void setStatus(StatusVacinaCalendario status) {
        this.status = status;
    }
}
