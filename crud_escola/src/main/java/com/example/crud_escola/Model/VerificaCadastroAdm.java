package com.example.crud_escola.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//essa classe servirá para verificar a pré-existência do cpf cadastrado
@Entity
public class VerificaCadastroAdm implements Serializable {

    // atributos
    @Id
    private String cpf;
    private String nome;

    // métodos modificadores de acesso

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

}
