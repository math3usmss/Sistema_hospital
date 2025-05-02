package models;

import java.util.Objects;

public class Pessoa {

    private String nome;
    private String CPF;

    public Pessoa(){}

    public Pessoa(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, CPF);
    }
}
