package models;

import java.util.ArrayList;
import java.util.Objects;

public class Medico extends Pessoa{

    private String CRM;
    private String especialidade;

    public Medico(){}

    public Medico(String nome, String CPF, String CRM, String especialidade) {
        super(nome, CPF);
        this.CRM = CRM;
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Medico medico)) return false;
        return Objects.equals(CRM, medico.CRM) && Objects.equals(especialidade, medico.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CRM, especialidade);
    }
}
