import models.Medico;
import models.Paciente;
import services.ConsultaService;
import services.MedicoService;
import services.PacienteService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MedicoService ms = new MedicoService();
        PacienteService ps = new PacienteService();
        ConsultaService cs = new ConsultaService(ps, ms);

        int option = menu();

        do {
            switch (option) {
                case 1:
                    System.out.println("Digite o nome do médico:");
                    String nomeMedico = sc.nextLine();
                    System.out.println("Digite o CPF do médico:");
                    String CPFMedico = sc.nextLine();
                    System.out.println("Digite o CRM do médico:");
                    String CRMMedico = sc.nextLine();
                    System.out.println("Digite a especialidade do médico:");
                    String especialidadeMedico = sc.nextLine();

                    ms.CadastrarMedico(nomeMedico, CPFMedico, CRMMedico, especialidadeMedico);
                    option = menu();
                    break;
                case 2:
                    System.out.println("Digite o CRM do médico:");
                    String CRMMedicoBusca = sc.nextLine();

                    Medico medico = ms.BuscarMedico(CRMMedicoBusca);
                    System.out.println(medico);
                    option = menu();
                    break;
                case 3:
                    System.out.println("Médicos: ");
                    ms.ListarMedicos();
                    option = menu();
                    break;
                case 4:
                    System.out.println("Digite o nome do Paciente:");
                    String nomePaciente = sc.nextLine();
                    System.out.println("Digite o CPF do paciente:");
                    String CPFPaciente = sc.nextLine();
                    System.out.println("Digite o Plano de saúde do paciente:");
                    String PlanoDeSaude = sc.nextLine();
                    System.out.println("Digite a idade do paciente:");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    ps.CadastrarPaciente(nomePaciente, CPFPaciente, PlanoDeSaude, idade);
                    option = menu();
                    break;
                case 5:
                    System.out.println("Digite o CPF do paciente:");
                    String CPFPacienteBuscar = sc.nextLine();
                    System.out.println("Digite o plano de saúde do paciente:");
                    String planoDeSaudeBuscar = sc.nextLine();

                    Paciente paciente = ps.BuscarPaciente(CPFPacienteBuscar, planoDeSaudeBuscar);
                    System.out.println(paciente);
                    option = menu();
                    break;
                case 6:
                    System.out.println("Pacientes: ");
                    ps.ListarPacientes();
                    option = menu();
                    break;
                case 7:
                    System.out.println("Digite o CPF do paciente:");
                    String CPFPacienteConsulta = sc.nextLine();
                    System.out.println("Digite o plano de saúde do paciente:");
                    String planoDeSaudeConsulta = sc.nextLine();
                    System.out.println("Digite o CRM do médico:");
                    String CRMMedicoConsulta = sc.nextLine();
                    System.out.println("Digite a data da consulta(dd/MM/yyyy):");
                    String dataConsulta = sc.nextLine();
                    System.out.println("Digite o horario da consulta(hh:mm):");
                    String horarioConsulta = sc.nextLine();

                    cs.NovaConsulta(CPFPacienteConsulta, planoDeSaudeConsulta, CRMMedicoConsulta, dataConsulta, horarioConsulta);
                    option = menu();
                    break;
                case 8:
                    cs.ConsultasDeHoje();
                    option = menu();
                    break;
                case 9:
                    System.out.println("Digite o CPF do paciente:");
                    String CPFPacienteCancelar = sc.nextLine();
                    System.out.println("Digite o CRM do médico:");
                    String CRMMedicoCancelar = sc.nextLine();
                    System.out.println("Digite a data da consulta(dd/MM/yyyy):");
                    String dataConsultaCancelar = sc.nextLine();

                    cs.CancelarConsulta(CPFPacienteCancelar, CRMMedicoCancelar,dataConsultaCancelar);
                    option = menu();
                    break;
            }
        } while (option != 0);


    }

    public static Integer menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar médico");
        System.out.println("2 - Buscar médico");
        System.out.println("3 - Listar médicos");
        System.out.println("4 - Cadastrar paciente");
        System.out.println("5 - Buscar paciente");
        System.out.println("6 - Listar pacientes");
        System.out.println("7 - Marcar consulta");
        System.out.println("8 - Buscar consultas do dia");
        System.out.println("9 - Cancelar consulta");
        System.out.println("----------");

        return sc.nextInt();
    }
}