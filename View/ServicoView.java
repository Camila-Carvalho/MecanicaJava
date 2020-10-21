import java.util.ArrayList;
import java.util.Scanner;

public class ServicoView {
	Scanner leitor = new Scanner(System.in);
	// variaveis auxiliares
	private String descricao;

	void view(char opcao, ArrayList<Servico> listServico) {
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
			System.out.print("C�digo: ");
			int codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.getId() == codigoBusca) {
					sAux = servico;
				}
				;
			}
			System.out.print("Altera descricao (s)Sim (n)Nao ");
			char op = leitor.next().charAt(0);
			if (op == 's' || op == 'S') {
				System.out.print("Nova descricao:");
				String novaDescricao = leitor.nextLine();
				sAux.setDescricao(novaDescricao);
			}
			break;
		case 'c':
			System.out.println("====== Consultar Servico ======");
			System.out.print("C�digo: ");
			codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.getId() == codigoBusca) {
					System.out.println("=== Dados Servico ===");
					System.out.println(servico.getId() + " | " + servico.getDescricao());
					System.out.println("====================");
				}
			}
			break;
		case 'e':
			System.out.println("====== Excluir Servico ======");
			System.out.print("C�digo: ");
			codigoBusca = leitor.nextInt();
			for (Servico servico : listServico) {
				if (servico.getId() == codigoBusca) {
					listServico.remove(servico);
				}
				;
			}
			// System.out.println("==================");
			break;
		default:
			System.out.println("Valor informado inv�lido!");
		}
	}
}
