import java.util.ArrayList;
import java.util.Scanner;

public class AtendimentoView {
	RelatoriosView rView = new RelatoriosView();
	Scanner leitor = new Scanner(System.in);

	// variaveis auxiliares
	private String data;
	private int ano;
	private int mes;
	private int dia;
	private int horaInicio;
	private Funcionario funcionario;
	private Cliente cliente;
	private Servico servico;
	private Veiculo veiculo;
	private String status;
	private String descricao;

	void view(char opcao, ArrayList<Atendimento> listAtendimento, ArrayList<Cliente> listCliente,
			ArrayList<Funcionario> listFuncionario, ArrayList<Servico> listServico, ArrayList<Veiculo> listVeiculo) {
		switch (opcao) {
		case 'i':
			System.out.println("===== Novo Atendimento =====");
			// DATA
			System.out.print("Informe a data: DD/MM/AAAA");
			data = leitor.nextLine();
			String spData[] = data.split("/");
			dia = Integer.parseInt(spData[0]);
			mes = Integer.parseInt(spData[1]);
			ano = Integer.parseInt(spData[2]);
			// HORARIO
			System.out.print("Horário: (8hrs / 10hrs / 14hrs / 16hrs)");
			horaInicio = leitor.nextInt();
			// FUNCIONARIO
			rView.view(4, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Funcionario:");
			int cod = leitor.nextInt();
			funcionario = GetFuncionarioById(cod, listFuncionario);
			// CLIENTE
			rView.view(2, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Cliente:");
			cod = leitor.nextInt();
			cliente = GetClienteById(cod, listCliente);
			// SERVICO
			rView.view(3, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Servico:");
			cod = leitor.nextInt();
			servico = GetServicoById(cod, listServico);
			// VEICULO
			rView.view(7, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Veiculo:");
			cod = leitor.nextInt();
			veiculo = GetVeiculoById(cod, listVeiculo);
			// DESCRICAO
			leitor.nextLine();
			System.out.print("Descricao:");
			descricao = leitor.nextLine();
			// STATUS
			status = "PENDENTE";
			Atendimento aInclui = new Atendimento(ano, mes, dia, horaInicio, funcionario, cliente, servico, veiculo,
					status, descricao, listAtendimento);
			listAtendimento.add(aInclui);
			break;
		case 'a':
			System.out.println("====== Alterar Atendimento ======");
			Atendimento aAltera = null;
			Atendimento aux = null;
			char op;
			boolean verifica;
			do {
				// DATA
				System.out.print("Informe a data para consulta previa: DD/MM/AAAA ");
				data = leitor.nextLine();
				String spDataAltera[] = data.split("/");
				dia = Integer.parseInt(spDataAltera[0]);
				mes = Integer.parseInt(spDataAltera[1]);
				ano = Integer.parseInt(spDataAltera[2]);
				// HORARIO
				System.out.print("Horário para consulta previa: (8 / 10 / 14 / 16) hrs");
				horaInicio = leitor.nextInt();
				aAltera = aAltera.getAtendimentoByData(ano, mes, dia, horaInicio, listAtendimento);
				System.out.println("=== Dados Atendimento Busca ===");
				System.out.println(
						"CODIGO|   DATA ATENDIMENTO   |          NOME CLIENTE          |         SERVIÇO        | DESCRICAO ");
				System.out.println(aAltera.getCodigo() + " | " + aAltera.getDia() + "/" + aAltera.getMes() + " | "
						+ aAltera.getCliente().getNome() + " | " + aAltera.getServico().getDescricao() + " | "
						+ aAltera.getDescricao());
				System.out.print("Alterar atendimento? (s)Sim (n)Nao ");
				op = leitor.next().charAt(0);
			} while (op == 'n' || op == 'N');

			System.out.println("=== Novos dados do Atendimento ===");
			// Verificar data e hora livre
			do {
				System.out.print("Informe a data: DD/MM/AAAA ");
				data = leitor.nextLine();
				String[] spDataAltera = data.split("/");
				dia = Integer.parseInt(spDataAltera[0]);
				mes = Integer.parseInt(spDataAltera[1]);
				ano = Integer.parseInt(spDataAltera[2]);
				// HORARIO
				System.out.print("Horário: (8 / 10 / 14 / 16) hrs");
				horaInicio = leitor.nextInt();
				verifica = aux.verificaAtendimento(ano, mes, dia, horaInicio, listAtendimento);
			} while (verifica);

			// FUNCIONARIO
			rView.view(4, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Funcionario:");
			cod = leitor.nextInt();
			funcionario = GetFuncionarioById(cod, listFuncionario);
			// CLIENTE
			rView.view(2, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Cliente:");
			cod = leitor.nextInt();
			cliente = GetClienteById(cod, listCliente);
			// SERVICO
			rView.view(3, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Servico:");
			cod = leitor.nextInt();
			servico = GetServicoById(cod, listServico);
			// VEICULO
			rView.view(5, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
			System.out.print("Codigo Veiculo:");
			cod = leitor.nextInt();
			veiculo = GetVeiculoById(cod, listVeiculo);
			// DESCRICAO
			leitor.nextLine();
			System.out.print("Descricao:");
			descricao = leitor.nextLine();
			// STATUS
			status = "PENDENTE";
			aAltera.UpdateAtendimento(aux, listAtendimento);
			break;
		case 'c':
			System.out.println("====== Consultar atendimento ======");
			Atendimento aConsulta = null;
			// DATA
			System.out.print("Informe a data: DD/MM/AAAA");
			data = leitor.nextLine();
			String spDataConsulta[] = data.split("/");
			dia = Integer.parseInt(spDataConsulta[0]);
			mes = Integer.parseInt(spDataConsulta[1]);
			ano = Integer.parseInt(spDataConsulta[2]);
			// HORARIO
			System.out.print("Horário: (8hrs / 10hrs / 14hrs / 16hrs)");
			horaInicio = leitor.nextInt();
			aConsulta = aConsulta.getAtendimentoByData(ano, mes, dia, horaInicio, listAtendimento);
			if (aConsulta != null) {
				System.out.println("=== Dados Atendimento ===");
				System.out.println(
						"CODIGO|   DATA ATENDIMENTO   |          NOME CLIENTE          |         SERVIÇO        | DESCRICAO ");
				System.out.println(aConsulta.getCodigo() + " | " + aConsulta.getDia() + "/" + aConsulta.getMes() + " | "
						+ aConsulta.getCliente().getNome() + " | " + aConsulta.getServico().getDescricao() + " | "
						+ aConsulta.getDescricao());
				System.out.println("====================");
			} else {
				System.out.print("Atendimento não encontrado!");
			}
			break;
		case 'e':
			System.out.println("====== Excluir Atendimento ======");
			Atendimento aExclui = null;
			// DATA
			System.out.print("Informe a data: DD/MM/AAAA");
			data = leitor.nextLine();
			String spDataExclui[] = data.split("/");
			dia = Integer.parseInt(spDataExclui[0]);
			mes = Integer.parseInt(spDataExclui[1]);
			ano = Integer.parseInt(spDataExclui[2]);
			// HORARIO
			System.out.print("Horário: (8hrs / 10hrs / 14hrs / 16hrs)");
			horaInicio = leitor.nextInt();
			aExclui = aExclui.getAtendimentoByData(ano, mes, dia, horaInicio, listAtendimento);
			if (aExclui != null) {
				System.out.print("Excluir atendimento? ");
				op = leitor.next().charAt(0);
				if (op == 's' || op == 'S') {
					aExclui.excluiAtendimento(ano, mes, dia, horaInicio, listAtendimento);
				}
			} else {
				System.out.print("Atendimento não encontrado!");
			}
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}

	private Funcionario GetFuncionarioById(int cod, ArrayList<Funcionario> listFuncionario) {
		Funcionario funcionario = null;
		for (Funcionario f : listFuncionario) {
			if (f.getId() == cod) {
				funcionario = f;
			}
		}

		return funcionario;
	}

	private Cliente GetClienteById(int idBusca, ArrayList<Cliente> todosClientes) {
		Cliente cliente = null;
		for (Cliente c : todosClientes) {
			if (c.getId() == idBusca) {
				cliente = c;
			}
		}
		return cliente;
	}

	private Servico GetServicoById(int idBusca, ArrayList<Servico> todosServicos) {
		Servico servico = new Servico();
		for (Servico s : todosServicos) {
			if (s.getId() == idBusca) {
				servico = s;
			}
		}
		return servico;
	}

	private Veiculo GetVeiculoById(int idBusca, ArrayList<Veiculo> todosVeiculos) {
		Veiculo veiculo = null;
		for (Veiculo v : todosVeiculos) {
			if (v.getId() == idBusca) {
				veiculo = v;
			}
		}
		return veiculo;
	}
}
