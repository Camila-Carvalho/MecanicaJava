import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RelatoriosView {
	Scanner leitor = new Scanner(System.in);

	void view(int opcao, ArrayList<Cliente> listCliente, ArrayList<Funcionario> listFuncionario,
			ArrayList<Servico> listServico, ArrayList<Veiculo> listVeiculo, ArrayList<Atendimento> listAtendimento) {
		switch (opcao) {
		case 1:
			System.out.println("===== Relat�rio Clientes =====");
			for (Cliente cliente : listCliente) {
				System.out.println("C�digo: " + cliente.getId());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("CPF: " + cliente.getCpf());
				System.out.println("Telefone: " + cliente.getTelefone());
				System.out.println("Data Nascimento: " + cliente.getDataNascimento());
				System.out.println("Email: " + cliente.getEmail());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Endere�o: " + cliente.getEndereco());
				System.out.println("Estado Civil: " + cliente.getEstadoCivil());
				System.out.println("Situa��o: " + cliente.getSituacao());
				System.out.println("===============================");
			}
			break;
		case 2:
			System.out.println("====== Relat�rio Clientes por situa��o ======");

			ArrayList<Cliente> listClientesAtivos = (ArrayList<Cliente>) listCliente.stream()
					.filter(cliente -> cliente.getSituacao().equals("Ativo")).collect(Collectors.toList());
			ArrayList<Cliente> listClientesInativos = (ArrayList<Cliente>) listCliente.stream()
					.filter(cliente -> cliente.getSituacao().equals("Inativo")).collect(Collectors.toList());

			if (listClientesAtivos.size() > 0) {
				System.out.println("====== CLIENTES ATIVOS ======");
				for (Cliente cliente : listClientesAtivos) {
					System.out.println("C�digo: " + cliente.getId());
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Data Nascimento: " + cliente.getDataNascimento());
					System.out.println("Email: " + cliente.getEmail());
					System.out.println("Sexo: " + cliente.getSexo());
					System.out.println("Endere�o: " + cliente.getEndereco());
					System.out.println("Estado Civil: " + cliente.getEstadoCivil());
					System.out.println("Situa��o: " + cliente.getSituacao());
					System.out.println("--------------------------------");
				}
			}

			if (listClientesInativos.size() > 0) {
				System.out.println("====== CLIENTES INATIVOS ======");
				for (Cliente cliente : listClientesInativos) {
					System.out.println("C�digo: " + cliente.getId());
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Data Nascimento: " + cliente.getDataNascimento());
					System.out.println("Email: " + cliente.getEmail());
					System.out.println("Sexo: " + cliente.getSexo());
					System.out.println("Endere�o: " + cliente.getEndereco());
					System.out.println("Estado Civil: " + cliente.getEstadoCivil());
					System.out.println("Situa��o: " + cliente.getSituacao());
					System.out.println("--------------------------------");
				}
			}

			break;
		case 3:
			System.out.println("====== Relat�rio Servi�os ======");
			for (Servico servico : listServico) {
				System.out.println("C�digo: " + servico.getId());
				System.out.println("Nome: " + servico.getDescricao());
				System.out.println("===============================");
			}
			break;
		case 4:
			System.out.println("====== Relat�rio Funcionarios ======");
			for (Funcionario functionario : listFuncionario) {
				System.out.println("C�digo: " + functionario.getId());
				System.out.println("Nome: " + functionario.getNome());
				System.out.println("CPF: " + functionario.getCpf());
				System.out.println("Telefone: " + functionario.getTelefone());
				System.out.println("Email: " + functionario.getEmail());
				System.out.println("===============================");
			}
			break;
		case 5:
			System.out.println("====== Relat�rio Agenda ======");
			System.out.print("Informe a data: DD/MM/AAAA");
			String data = leitor.nextLine();
			String spDataConsulta[] = data.split("/");
			int dia = Integer.parseInt(spDataConsulta[0]);
			int mes = Integer.parseInt(spDataConsulta[1]);
			int ano = Integer.parseInt(spDataConsulta[2]);
			ArrayList<Atendimento> listAtendimentoDia = (ArrayList<Atendimento>) listAtendimento.stream()
					.filter(atendimento -> atendimento.getAno() == ano && atendimento.getMes() == mes
							&& atendimento.getDia() == dia)
					.collect(Collectors.toList());

			System.out.println("====== Agenda do dia " + data + " ======");
			for (Atendimento atendimento : listAtendimentoDia) {
				System.out.println("Cliente: " + atendimento.getCliente().getNome());
				System.out.println("Contato do cliente: " + atendimento.getCliente().getTelefone() + " | "
						+ atendimento.getCliente().getEmail());
				System.out.println("Funcionario: " + atendimento.getFuncionario().getNome());
				System.out.println("Servi�o: " + atendimento.getServico().getId() + " | "
						+ atendimento.getServico().getDescricao());
				System.out.println("Tipo do veiculo: " + atendimento.getVeiculo().getTipo());
				System.out.println("Hora do in�cio: " + atendimento.getHoraFim());
				System.out.println("Status: " + atendimento.getStatus());
				System.out.println("Descri��o: " + atendimento.getDescricao());
				System.out.println("===============================");
			}
			break;
		case 6:
			System.out.println("====== Relat�rio Servi�os por cliente ======");
			break;
		case 7:
			System.out.println("====== Relat�rio Veiculos ======");
			for (Veiculo veiculo : listVeiculo) {
				System.out.println("C�digo: " + veiculo.getId());
				System.out.println("Tipo: " + veiculo.getTipo());
				System.out.println("===============================");
			}
			break;
		default:
			System.out.println("Valor informado inv�lido!");
		}
	}
}
