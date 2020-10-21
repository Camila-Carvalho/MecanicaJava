import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ServicoView {
	//char opcao;

	Scanner leitor = new Scanner(System.in);

	// instancia servico
	// Servico servico = new Servico();

	// variaveis auxiliares
	private int id;
	private String descricao;

	void retornaView(char opcao, ArrayList<Servico> listServico) {
		switch (opcao) {
		case 'i':
			System.out.println("===== Cadastrar Servico =====");
			System.out.print("Descricao:");
			descricao = leitor.nextLine();
			// id = listServico.size() + 1;
			Servico s = new Servico(descricao, listServico);
			listServico.add(s);
			break;
		case 'a':
			System.out.println("====== Alterar Servico ======");
			Servico sAux = new Servico();
			System.out.print("Código: ");
			int codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.id == codigoBusca) {
					sAux = servico;
				}
				;
			}
			System.out.print("Altera descricao (s)Sim (n)Nao ");
			char op = leitor.next().charAt(0);
			if (op == 's' || op == 'S') {
				System.out.print("Nova descricao:");
				sAux.descricao = leitor.next();
			}
			break;
		case 'c':
			System.out.println("====== Consultar Servico ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.id == codigoBusca) {
					System.out.println("=== Dados Servico ===");
					System.out.println(servico.id + "|" + servico.descricao);
					System.out.println("====================");
				}
			}
			break;
		case 'e':
			System.out.println("====== Excluir Servico ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.id == codigoBusca) {
					listServico.remove(servico);
				}
				;
			}
			// System.out.println("==================");
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}
}
