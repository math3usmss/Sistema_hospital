package services;

import models.Consulta;
import models.Medico;
import models.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsultaService {

    ArrayList<Consulta> consultas = new ArrayList<>();
    PacienteService pacienteService;
    MedicoService medicoService;

    public ConsultaService() {
    }

    public ConsultaService(PacienteService pacienteService, MedicoService medicoService) {
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public void NovaConsulta(String CPFpaciente, String planoDeSaude, String CRMmedico, String data, String horario) {
        try {
            LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horarioFormatada = LocalTime.parse(horario, DateTimeFormatter.ofPattern("HH:mm"));

            Paciente paciente = pacienteService.BuscarPaciente(CPFpaciente, planoDeSaude);
            Medico medico = medicoService.BuscarMedico(CRMmedico);

            if (!MedicoDisponivel(medico, dataFormatada, LocalTime.from(horarioFormatada))) {
                Consulta consulta = new Consulta(paciente, medico, dataFormatada, horarioFormatada);
                consultas.add(consulta);
            } else {
                System.out.println("O médico já possui uma consulta nesse horário!");
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao marcar uma nova consulta" + e.getMessage());
        }
    }

    public boolean MedicoDisponivel(Medico medico, LocalDate data, LocalTime horario) {
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) && consulta.getData().equals(data) && consulta.getHorario().equals(horario)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void ConsultasDeHoje() {
        LocalDate hoje = LocalDate.now();
        if (!consultas.isEmpty()) {
            for (Consulta consulta : consultas) {
                if (consulta.getData().equals(hoje)) {
                    System.out.println(consulta);
                }
            }
        } else {
            System.out.println("Não existem consultas");
        }
    }

//    public Consulta buscarConsulta(String CPFpaciente, String planoDeSaude, String CRMmedico){
//        try {
//            Paciente paciente = pacienteService.BuscarPaciente(CPFpaciente, planoDeSaude);
//            Medico medico = medicoService.BuscarMedico(CRMmedico);
//
//            for (Consulta consulta : consultas) {
//                if(consulta.getPaciente().getCPF().equals(CPFpaciente) && consulta.getMedico().getCRM().equals(CRMmedico)){
//                    return consulta;
//                }else {return null;}
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    public void CancelarConsulta(String CPFpaciente, String CRMmedico, String data) {
        Consulta consultaDeletar = null;
        LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (Consulta consulta : consultas) {
            if(consulta.getPaciente().getCPF().equals(CPFpaciente) && consulta.getMedico().getCRM().equals(CRMmedico) && consulta.getData().equals(dataFormatada)){
                consultaDeletar = consulta;
            }
        }
        System.out.println("Consulta cancelada!");
        consultas.remove(consultaDeletar);
    }
}
