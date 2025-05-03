package models;

import javax.naming.InitialContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Consulta {
    protected Long idInicial = 100L;

    private Long id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private LocalTime horario;

    public Consulta(){}

    public Consulta(Paciente paciente, Medico medico, LocalDate data, LocalTime horario) {
        this.id = idInicial++;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.horario = horario;
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

    public LocalTime getHorario() {
        return horario;
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

    @Override
    public String toString() {
        return "Consulta{" +
                ", id=" + id +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", data=" + data +
                ", horario=" + horario +
                '}';
    }
}
