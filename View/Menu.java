import java.util.Scanner;

public class Menu {
	
	//int opcao;
	
	Scanner leitor = new Scanner(System.in);
	FuncionarioView fView = new FuncionarioView();
	ClienteView cView = new ClienteView();
	ServicoView sView = new ServicoView();
	
	//MENU PRINCIPAL
	public void menuPrincipal() {
		System.out.println("====== MENU OFICINA ======");
		System.out.println("(1) Cadastrar"); //cadastrar pessoa/funcionario/serviço
		System.out.println("(2) Novo Atendimento");
		System.out.println("(3) Consultar Atendimentos");
		System.out.println("(4) Relatórios");
		int opcao = leitor.nextInt();
		switch(opcao) {
		case 1:
			menuCadastro();
			break;
		}
	}
	
	//MENU CADASTRO
	public void menuCadastro() {
		System.out.println("====== MENU CADASTRO ======");
		System.out.println("(1) Cadastro Funcionario");
		System.out.println("(2) Cadastro Cliente");
		System.out.println("(3) Cadastro Servico");
		int opcao = leitor.nextInt();
		switch(opcao) {
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
			  System.out.println("Valor informado inválido!");
		}
	}
	
	//MENU FUNCIONARIO
	public void menuFuncionario() {
		System.out.println("====== MENU FUNCIONARIO ======");
		System.out.println("(i) Incluir");
		System.out.println("(c) Consultar");
		System.out.println("(a) Alterar");
		System.out.println("(e) Excluir");
		char opcao = leitor.next().charAt(0);
		fView.retornaView(opcao);
	}
	
	//MENU CLIENTE
		public void menuCliente() {
			System.out.println("====== MENU CLIENTE ======");
			System.out.println("(i) Incluir");
			System.out.println("(c) Consultar");
			System.out.println("(a) Alterar");
			System.out.println("(e) Excluir");
			char opcao = leitor.next().charAt(0);
			cView.retornaView(opcao);
		}
		
	//MENU SERVICO
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
