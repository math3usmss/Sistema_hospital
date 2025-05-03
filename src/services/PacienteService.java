package services;

import models.Medico;
import models.Paciente;

import java.util.ArrayList;

public class PacienteService {

    ArrayList<Paciente> pacientes = new ArrayList<>();

    public void CadastrarPaciente(String nome, String CPF, String planoDeSaude, Integer idade){
        try{
            Paciente paciente = new Paciente(nome, CPF, planoDeSaude, idade);
            pacientes.add(paciente);
            System.out.println("Paciente cadastrado com sucesso!");
        }
        catch (RuntimeException e){
            System.out.println("Erro ao cadastrar um Paciente" + e.getMessage());
        }
    }

    public Paciente BuscarPaciente(String CPF, String planoDeSaude){
        for(Paciente paciente : pacientes){
            if(paciente.getCPF().equals(CPF) && paciente.getPlanoDeSaude().equals(planoDeSaude)){
                return paciente;
            }
        }
        return null;
    }

    public void ListarPacientes(){
        if(!pacientes.isEmpty()){
            for(Paciente paciente : pacientes){
                System.out.println(paciente);
            }
        }
        else {System.out.println("Sem pacientes cadastrados!");}
    }
}
