package services;

import models.Medico;

import java.util.ArrayList;

public class MedicoService {

    ArrayList<Medico> medicos = new ArrayList<>();

    public void CadastrarMedico(String nome, String CPF, String CRM, String especialidade){
       try{
           Medico medico = new Medico(nome, CPF, CRM, especialidade);
           medicos.add(medico);
       }
       catch (RuntimeException e){
           System.out.println("Erro ao cadastrar um médico" + e.getMessage());
       }
    }

    public Medico BuscarMedico(String CRM){
        for(Medico medico : medicos){
            if(medico.getCRM().equals(CRM)){
                return medico;
            }
        }
        return null;
    }
}
