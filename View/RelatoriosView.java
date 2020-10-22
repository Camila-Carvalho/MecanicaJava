import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RelatoriosView {
	Scanner leitor = new Scanner(System.in);
	
	void view(int opcao, ArrayList<Cliente> listCliente, ArrayList<Funcionario> listFuncionario,
			ArrayList<Servico> listServico, ArrayList<Veiculo> listVeiculo, ArrayList<Atendimento> listAtendimento) {
		switch (opcao) {
		case 1:
			System.out.println("===== Relatório Clientes =====");
			for (Cliente cliente : listCliente) {
				System.out.println("Código: " + cliente.getId());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("CPF: " + cliente.getCpf());
				System.out.println("Telefone: " + cliente.getTelefone());
				System.out.println("Data Nascimento: " + cliente.getDataNascimento());
				System.out.println("Email: " + cliente.getEmail());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Endereço: " + cliente.getEndereco());
				System.out.println("Estado Civil: " + cliente.getEstadoCivil());
				System.out.println("Situação: " + cliente.getSituacao());
				System.out.println("===============================");
			}
			break;
		case 2:
			System.out.println("====== Relatório Clientes por situação ======");
			
			ArrayList<Cliente> listClientesAtivos = (ArrayList<Cliente>) listCliente.stream().filter(cliente -> cliente.getSituacao().equals("Ativo")).collect(Collectors.toList());
			ArrayList<Cliente> listClientesInativos = (ArrayList<Cliente>) listCliente.stream().filter(cliente -> cliente.getSituacao().equals("Inativo")).collect(Collectors.toList());
			
			if(listClientesAtivos.size() > 0) {
				System.out.println("====== CLIENTES ATIVOS ======");
				for (Cliente cliente : listClientesAtivos) {
					System.out.println("Código: " + cliente.getId());
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Data Nascimento: " + cliente.getDataNascimento());
					System.out.println("Email: " + cliente.getEmail());
					System.out.println("Sexo: " + cliente.getSexo());
					System.out.println("Endereço: " + cliente.getEndereco());
					System.out.println("Estado Civil: " + cliente.getEstadoCivil());
					System.out.println("Situação: " + cliente.getSituacao());
					System.out.println("--------------------------------");
				}
			}
			
			if(listClientesInativos.size() > 0) {
				System.out.println("====== CLIENTES INATIVOS ======");
				for (Cliente cliente : listClientesInativos) {
					System.out.println("Código: " + cliente.getId());
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Data Nascimento: " + cliente.getDataNascimento());
					System.out.println("Email: " + cliente.getEmail());
					System.out.println("Sexo: " + cliente.getSexo());
					System.out.println("Endereço: " + cliente.getEndereco());
					System.out.println("Estado Civil: " + cliente.getEstadoCivil());
					System.out.println("Situação: " + cliente.getSituacao());
					System.out.println("--------------------------------");
				}
			}
	
			break;
		case 3:
			System.out.println("====== Relatório Serviços ======");
			for (Servico servico : listServico) {
				System.out.println("Código: " + servico.getId());
				System.out.println("Nome: " + servico.getDescricao());
				System.out.println("===============================");
			}
			break;
		case 4:
			System.out.println("====== Relatório Funcionarios ======");
			for (Funcionario functionario : listFuncionario) {
				System.out.println("Código: " + functionario.getId());
				System.out.println("Nome: " + functionario.getNome());
				System.out.println("CPF: " + functionario.getCpf());
				System.out.println("Telefone: " + functionario.getTelefone());
				System.out.println("Email: " + functionario.getEmail());
				System.out.println("===============================");
			}
			break;
		case 5:
			System.out.println("====== Relatório Agenda ======");
			break;
		case 6:
			System.out.println("====== Relatório Agenda ======");
			break;
		case 7:
			System.out.println("====== Relatório Serviços por cliente ======");
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}
}
