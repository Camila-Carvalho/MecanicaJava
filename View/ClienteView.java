import java.util.ArrayList;
import java.util.Scanner;

public class ClienteView {
	Scanner leitor = new Scanner(System.in);

	// variaveis auxiliares
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String endereco;
	private String dataNascimento;
	private char sexo;
	private String estadoCivil;

	void view(char opcao, ArrayList<Cliente> listCliente) {
		switch (opcao) {
		case 'i':
			System.out.println("===== Cadastrar Cliente =====");
			try {
				System.out.print("Nome:");
				nome = leitor.nextLine();
				System.out.print("CPF:");
				cpf = leitor.nextLine();
				System.out.print("Telefone:");
				telefone = leitor.nextLine();
				System.out.print("Email:");
				email = leitor.nextLine();
				System.out.print("Endereco:");
				endereco = leitor.nextLine();
				System.out.print("Data Nascimento:");
				dataNascimento = leitor.nextLine();
				System.out.print("Sexo: (F)feminino (M)masculino");
				sexo = leitor.nextLine().charAt(0);
				System.out.print("Estado civil:");
				estadoCivil = leitor.nextLine();
				
				Cliente c = new Cliente(nome, cpf, telefone, email, endereco, dataNascimento, sexo, estadoCivil,
						listCliente);
				listCliente.add(c);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;
		case 'a':
			System.out.println("====== Alterar Cliente ======");
			Cliente cAux = new Cliente();
			System.out.print("Código: ");
			int codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.getId() == codigoBusca) {
					cAux = cliente;
				}
				;
			}
			System.out.print("Altera nome (s)Sim (n)Nao ");
			char op = leitor.next().charAt(0);
			if (op == 's' || op == 'S') {
				System.out.print("Novo Nome/Razao Social:");
				String novoNome = leitor.nextLine();
				cAux.setNome(novoNome);
			}
			break;
		case 'c':
			System.out.println("====== Consultar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					System.out.println("=== Dados Cliente ===");
					System.out.println(cliente.getId() + " | " + cliente.getNome() + " | " + cliente.getCpf());
					System.out.println("====================");
				}
			}
			break;
		case 'e':
			System.out.println("====== Inativar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					cliente.InativarCliente();
					System.out.println("!!! Cliente Inativado com Sucesso !!!");
				}
				;
			}
			break;
		case 'r':
			System.out.println("====== Reativar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					cliente.AtivarCliente();
					System.out.println("!!! Cliente Reativado com Sucesso !!!");
				}
				;
			}
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}
}
