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
public class Usuario {
    private int id;    
    private String nome;
    private int idade;
    private String cpf;
    private String rg;
    private long telefone;
    private long celular;
    private String tiposague;
    private float peso;
    private float altura;
    private Date nascimento;
    private Endereco endereco;
    private PerfilDeAcesso acesso;
    private String senha;
    private boolean Status;

    public Usuario() {
    }
    
    public Usuario( String nome, int idade, String cpf, String rg, long telefone, long celular, String tiposague, float peso, float altura, Date nascimento, Endereco endereco, PerfilDeAcesso acesso, String senha, boolean Status) {
        
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
        this.tiposague = tiposague;
        this.peso = peso;
        this.altura = altura;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.acesso = acesso;
        this.senha = senha;
        this.Status = Status;
    }

    public Usuario(String nome, int idade, String cpf, String rg, long telefone, long celular, String tiposague, float peso, float altura, Date nascimento, PerfilDeAcesso acesso, String senha, boolean Status) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
        this.tiposague = tiposague;
        this.peso = peso;
        this.altura = altura;
        this.nascimento = nascimento;
        this.acesso = acesso;
        this.senha = senha;
        this.Status = Status;
    }
    
    
    
    

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getTiposague() {
        return tiposague;
    }

    public void setTiposague(String tiposague) {
        this.tiposague = tiposague;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public PerfilDeAcesso getAcesso() {
        return acesso;
    }

    public void setAcesso(PerfilDeAcesso acesso) {
        this.acesso = acesso;
    }

}
