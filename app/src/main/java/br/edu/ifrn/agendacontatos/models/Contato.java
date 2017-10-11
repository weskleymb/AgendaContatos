package br.edu.ifrn.agendacontatos.models;

import java.io.Serializable;

public class Contato implements Serializable {

    private static Integer sequencia = 0;

    private Integer id;
    private String nome;
    private String fone;

    public Contato() {
        sequencia++;
        this.id = sequencia;
    }

    public Contato(String nome, String fone) {
        sequencia++;
        this.id = sequencia;
        this.nome = nome;
        this.fone = fone;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFone() {
        return this.fone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public boolean equals(Object outroContato) {
        Contato contato = (Contato) outroContato;
        return this.nome.equals(contato.nome);
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.fone;
    }

}
