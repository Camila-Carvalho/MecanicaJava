import java.util.Scanner;

public class Menu {

	// int opcao;

	Scanner leitor = new Scanner(System.in);
	FuncionarioView fView = new FuncionarioView();
	ClienteView cView = new ClienteView();
	ServicoView sView = new ServicoView();

	// MENU PRINCIPAL
	public void menuPrincipal() {
		int opcao = 0;

		do {
			System.out.println("====== MENU OFICINA ======");
			System.out.println("(1) Cadastrar"); // cadastrar pessoa/funcionario/serviço
			System.out.println("(2) Novo Atendimento");
			System.out.println("(3) Consultar Atendimentos");
			System.out.println("(4) Relatórios");
			System.out.println("(5) Sair");

			opcao = leitor.nextInt();
			switch (opcao) {
			case 1:
				menuCadastro();
				break;
			case 2:
				// novoAtendimento();
				break;
			case 3:
				// consultarAtendimentos();
				break;
			case 4:
				// relatorios();
				break;
			case 5:
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
		fView.retornaView(opcao);
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
		cView.retornaView(opcao);
	}

	// MENU SERVICO
	public void menuServico() {
		System.out.println("====== MENU SERVICO ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir");
		char opcao = leitor.next().charAt(0);
		sView.retornaView(opcao);
	}

}
