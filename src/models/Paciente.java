package models;

import java.util.Objects;

public class Paciente extends Pessoa{

    private Integer idade;
    private String planoDeSaude;

    public Paciente(){}

    public Paciente(String nome, String CPF, String planoDeSaude, Integer idade) {
        super(nome, CPF);
        this.planoDeSaude = planoDeSaude;
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Paciente paciente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(planoDeSaude, paciente.planoDeSaude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planoDeSaude);
    }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getPlanoDeSaude() + " " + this.getCPF() + " " + this.getCPF();
    }
}
