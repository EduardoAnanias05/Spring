package com.webapp.escola_xyz_b.Model;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professores implements Serializable {
    //Atributos Professor 
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha; 
    private String disciplina; 
    private String ensino; 


   
    //métodos
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    } 
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public String getEnsino() {
        return ensino;
    }
    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

}
