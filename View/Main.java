import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// int opcao;
	ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>(); //"BD"
	ArrayList<Servico> listServico = new ArrayList<Servico>(); //"BD"
	ArrayList<Cliente> listCliente = new ArrayList<Cliente>(); //"BD"
	ArrayList<Veiculo> listVeiculo = new ArrayList<Veiculo>(); //"BD"
	ArrayList<Atendimento> listAtendimento = new ArrayList<Atendimento>(); //"BD"

	Scanner leitor = new Scanner(System.in);
	FuncionarioView fView = new FuncionarioView();
	ClienteView cView = new ClienteView();
	ServicoView sView = new ServicoView();
	VeiculoView vView = new VeiculoView();
	RelatoriosView rView = new RelatoriosView();
	AtendimentoView aView = new AtendimentoView();
	
	// MENU PRINCIPAL
	public void menuPrincipal() {
		int opcao = 0;

		do {
			System.out.println("====== MENU OFICINA ======");
			System.out.println("(1) Cadastrar"); // cadastrar pessoa/funcionario/serviço/veiculo
			System.out.println("(2) Atendimento");
			System.out.println("(3) Relatórios");
			System.out.println("(4) Sair");

			opcao = leitor.nextInt();
			switch (opcao) {
			case 1:
				menuCadastro();
				break;
			case 2:
				menuAtendimento();
				break;
			case 3:
				menuRelatorios();
				break;
			case 4:
				System.out.println("====== PROGRAMA FINALIZADO ======");
				break;
			default:
				System.out.println("******* Valor informado inválido! *******");
			}

		} while (opcao != 5);
	}

	// MENU CADASTRO
	public void menuCadastro() {
		System.out.println("====== MENU CADASTRO ======");
		System.out.println("(1) Cadastro Funcionario");
		System.out.println("(2) Cadastro Cliente");
		System.out.println("(3) Cadastro Servico");
		System.out.println("(4) Cadastro Veiculo");
		int opcao = leitor.nextInt();
		switch (opcao) {
		case 1:
			menuFuncionario();
			break;
		case 2:
			menuCliente();
			break;
		case 3:
			menuServico();
			break;
		case 4:
			menuVeiculo();
			break;
		default:
			System.out.println("******* Valor informado inválido! *******");
		}
	}

	// MENU FUNCIONARIO
	public void menuFuncionario() {
		System.out.println("====== MENU FUNCIONARIO ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir");
		char opcao = leitor.next().charAt(0);
		fView.view(opcao, listFuncionario);
	}

	// MENU CLIENTE
	public void menuCliente() {
		System.out.println("====== MENU CLIENTE ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir (Inativar)");
		System.out.println("(r) Reativar");
		char opcao = leitor.next().charAt(0);
		cView.view(opcao, listCliente);
	}

	// MENU SERVICO
	public void menuServico() {
		System.out.println("====== MENU SERVICO ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir");
		char opcao = leitor.next().charAt(0);
		sView.view(opcao, listServico);
	}
	
	// MENU SERVICO
	public void menuVeiculo() {
		System.out.println("====== MENU VEICULOS ======");
		System.out.println("(i) Incluir");
		char opcao = leitor.next().charAt(0);
		vView.view(opcao, listVeiculo);
	}
	
	// MENU ATENDIMENTO
	public void menuAtendimento() {
		System.out.println("====== MENU ATENDIMENTO ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir");
		char opcao = leitor.next().charAt(0);
		aView.view(opcao, listAtendimento, listCliente, listFuncionario, listServico, listVeiculo);
	}
	
	// MENU RELATORIOS
	public void menuRelatorios() {
			System.out.println("====== MENU RELATORIOS ======");
			System.out.println("(1) Clientes");
			System.out.println("(2) Clientes por situação");
			System.out.println("(3) Serviços");
			System.out.println("(4) Funcionarios");
			System.out.println("(5) Agenda");
			System.out.println("(6) Serviços por cliente");
			int opcao = leitor.nextInt();
			rView.view(opcao, listCliente, listFuncionario, listServico, listVeiculo, listAtendimento);
		}

}
