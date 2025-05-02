package models;

import java.time.LocalDate;
import java.util.Objects;

public class Consulta {

    private Long id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private  String diagnostico;

    public Consulta(){}

    public Consulta(Long id, Paciente paciente, Medico medico, LocalDate data, String diagnostico) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.diagnostico = diagnostico;
    }

    public Long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Consulta consulta)) return false;
        return Objects.equals(id, consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
