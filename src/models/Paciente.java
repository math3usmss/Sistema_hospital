package models;

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

}
